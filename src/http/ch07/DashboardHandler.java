package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardHandler implements HttpHandler {

    private static final String DASHBOARD_PAGE = """
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- 5초마다 서버에 다시 요청 -->
  <meta http-equiv="refresh" content="5">

  <title>객잔 운영 현황</title>

  <style>
    * {
      box-sizing: border-box;
    }

    :root {
      --ink: #34251d;
      --wood: #633b25;
      --wood-light: #8b5432;
      --paper: #fffaf0;
      --paper-dark: #e8dec5;
      --red: #9b302c;
      --green: #356859;
      --gold: #d6b36a;
    }

    body {
      min-height: 100vh;
      margin: 0;
      padding: 90px 20px 40px;

      display: grid;
      place-items: center;

      color: var(--ink);
      background:
        repeating-linear-gradient(
          90deg,
          transparent 0 70px,
          rgb(139 115 85 / 12%) 71px
        ),
        var(--paper-dark);

      font-family: Georgia, "Noto Serif KR", serif;
    }

    main {
      position: relative;

      width: min(100%, 820px);
      padding: 55px 45px 40px;

      border: 12px solid var(--wood);
      border-top-color: var(--wood-light);
      border-radius: 4px;

      background:
        linear-gradient(
          rgb(255 253 246 / 95%),
          rgb(243 234 213 / 97%)
        );

      box-shadow:
        0 18px 0 #3e281d,
        0 30px 35px rgb(62 40 29 / 30%);
    }

    /* 기와지붕 */
    main::before {
      content: "";

      position: absolute;
      left: 50%;
      bottom: 100%;

      width: calc(100% + 110px);
      height: 85px;

      background:
        repeating-radial-gradient(
          ellipse at 50% 100%,
          #3a3c3e 0 10px,
          #202224 11px 16px
        );

      clip-path: polygon(
        12% 55%,
        50% 0,
        88% 55%,
        100% 75%,
        84% 68%,
        50% 28%,
        16% 68%,
        0 75%
      );

      transform: translateX(-50%);
    }

    header {
      text-align: center;
    }

    .eyebrow {
      margin: 0 0 10px;

      color: var(--red);
      font-size: 0.8rem;
      font-weight: bold;
      letter-spacing: 0.25em;
    }

    h1 {
      margin: 0;

      color: var(--ink);
      font-size: clamp(2rem, 7vw, 3.8rem);
      letter-spacing: 0.08em;

      text-shadow: 2px 2px var(--gold);
    }

    .status {
      display: inline-flex;
      align-items: center;
      gap: 9px;

      margin-top: 20px;
      padding: 8px 18px;

      border: 2px solid var(--green);
      border-radius: 999px;

      color: var(--green);
      background: #edf1df;

      font-weight: bold;
    }

    .status-dot {
      width: 10px;
      height: 10px;

      border-radius: 50%;
      background: #2b9b62;

      box-shadow: 0 0 0 0 rgb(43 155 98 / 60%);

      animation: pulse 1.8s infinite;
    }

    @keyframes pulse {
      70% {
        box-shadow: 0 0 0 9px rgb(43 155 98 / 0%);
      }

      100% {
        box-shadow: 0 0 0 0 rgb(43 155 98 / 0%);
      }
    }

    .cards {
      margin-top: 35px;

      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 14px;
    }

    .card {
      position: relative;

      padding: 24px 15px;

      border: 2px solid #a66a3f;
      border-radius: 4px;

      background:
        linear-gradient(135deg, #fffaf0, #f3dfb5);

      text-align: center;

      box-shadow: 4px 4px 0 #c3a16c;
    }

    .card::before {
      content: "◆";

      position: absolute;
      top: 7px;
      left: 10px;

      color: rgb(155 48 44 / 35%);
      font-size: 0.7rem;
    }

    .card-label {
      display: block;

      color: #76513c;
      font-size: 0.75rem;
      font-weight: bold;
      letter-spacing: 0.16em;
    }

    .card-value {
      display: block;
      margin-top: 8px;

      color: var(--red);
      font-size: clamp(1.7rem, 5vw, 2.5rem);
      font-weight: bold;
    }

    .time-panel {
      margin-top: 22px;
      padding: 18px 20px;

      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 20px;

      border-top: 3px double #b38b56;
      border-bottom: 3px double #b38b56;

      color: #604638;
    }

    .time-label {
      font-size: 0.85rem;
      font-weight: bold;
      letter-spacing: 0.12em;
    }

    time {
      color: var(--green);
      font-weight: bold;
    }

    nav {
      margin-top: 28px;
    }

    nav h2 {
      margin: 0 0 14px;

      color: #3d554b;
      font-size: 1rem;
      text-align: center;
      letter-spacing: 0.1em;
    }

    nav ul {
      margin: 0;
      padding: 0;

      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 12px;

      list-style: none;
    }

    nav a {
      display: block;
      padding: 13px 12px;

      border: 2px solid #a66a3f;
      border-radius: 3px;

      color: #4d3021;
      background: #f3dfb5;

      font-size: 0.9rem;
      font-weight: bold;
      text-align: center;
      text-decoration: none;

      transition:
        transform 0.2s,
        color 0.2s,
        background 0.2s,
        box-shadow 0.2s;
    }

    nav a::before {
      content: "❖";
      margin-right: 7px;
      color: var(--red);
    }

    nav a:hover {
      color: white;
      background: var(--green);
      border-color: #294c42;

      transform: translateY(-3px);
      box-shadow: 0 5px 0 #294c42;
    }

    nav a:hover::before {
      color: var(--gold);
    }

    footer {
      margin-top: 28px;

      color: #8b735f;
      font-size: 0.75rem;
      text-align: center;
    }

    @media (width < 650px) {
      body {
        padding-top: 75px;
      }

      main {
        padding: 45px 22px 32px;
      }

      main::before {
        width: calc(100% + 40px);
      }

      .cards,
      nav ul {
        grid-template-columns: 1fr;
      }

      .time-panel {
        flex-direction: column;
        gap: 6px;

        text-align: center;
      }
    }
  </style>
</head>

<body>
  <main>
    <header>
      <p class="eyebrow">JAVA HTTP SERVER</p>
      <h1>객잔 운영 현황</h1>

      <div class="status">
        <span class="status-dot"></span>
        서버 정상 가동 중
      </div>
    </header>

    <section class="cards" aria-label="서버 정보">
      <article class="card">
        <span class="card-label">PORT</span>
        <strong class="card-value">{{PORT}}</strong>
      </article>

      <article class="card">
        <span class="card-label">THREADS</span>
        <strong class="card-value">{{THREADS}}</strong>
      </article>

      <article class="card">
        <span class="card-label">USERS</span>
        <strong class="card-value">{{USERS}}</strong>
      </article>
    </section>

    <section class="time-panel">
      <span class="time-label">현재 서버 시각</span>
      <time>{{SERVER_TIME}}</time>
    </section>

    <nav aria-label="서버 경로">
      <h2>객잔의 다른 문으로 이동하기</h2>

      <ul>
        <li>
          <a href="/">대문</a>
        </li>

        <li>
          <a href="/health">상태 확인</a>
        </li>

        <li>
          <a href="/api/users">사용자 목록</a>
        </li>
      </ul>
    </nav>

    <footer>
      이 현황판은 5초마다 새로운 정보를 확인합니다.
    </footer>
  </main>
</body>
</html>
    """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try (exchange) {
            String method = exchange.getRequestMethod();

            System.out.println("메서드 : " + method);

            switch (method) {
                case "GET" -> handleGet(exchange);
                default -> {
                    exchange.getResponseHeaders().set("Allow", "GET");
                    SimpleHttpServer.sendResponse(exchange, 405,
                            SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드입니다.");
                }
            }

        }

    }

    private void handleGet(HttpExchange exchange) throws IOException {
        try (exchange) {

            int userCount = UserApiHandler.getUserCount();

            String bodyText = DASHBOARD_PAGE
                    .replace("{{PORT}}", String.valueOf(SimpleHttpServer.PORT))
                    .replace("{{THREADS}}", String.valueOf(SimpleHttpServer.THREAD_POOL_SIZE))
                    .replace("{{USERS}}", String.valueOf(userCount))
                    .replace("{{SERVER_TIME}}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss")));

            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, bodyText);
        }
    }
}
