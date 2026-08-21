package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

/**
 * GET 요청 처리
 * -- 만드는 규칙 --
 * 1. HttpHandler 인터페이스를 구현한다.
 * 2. handle(HttpExchange exchange) 메서드 하나를 재정의한다.
 * 3. main에서 createContext로 경로를 짝지어 등록한다.
 */
public class HomeHandler implements HttpHandler {

    private static final String HOME_PAGE = """
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Java HTTP Server</title>

  <style>
    * {
      box-sizing: border-box;
    }

    body {
      min-height: 100vh;
      margin: 0;

      display: grid;
      place-items: center;

      color: #34251d;
      background:
        repeating-linear-gradient(
          90deg,
          transparent 0 70px,
          #8b735520 71px
        ),
        #e8dec5;

      font-family: Georgia, "Noto Serif KR", serif;
    }

    /* 전통 가옥 형태 */
    main {
      position: relative;

      width: min(90%, 700px);
      margin-top: 70px;
      padding: 55px 60px 45px;

      border: 12px solid #633b25;
      border-top-color: #7b4a2d;
      border-radius: 4px;

      background:
        linear-gradient(#fffdf6dd, #f3ead5ee);

      box-shadow:
        0 18px 0 #3e281d,
        0 28px 30px #3e281d55;

      text-align: center;
    }

    /* 기와지붕 */
    main::before {
      content: "";

      position: absolute;
      left: 50%;
      bottom: 100%;

      width: calc(100% + 100px);
      height: 80px;

      background:
        repeating-radial-gradient(
          ellipse at 50% 100%,
          #343638 0 10px,
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

    .status {
      display: inline-block;
      padding: 7px 18px;

      border: 2px solid #356859;
      border-radius: 3px;

      color: #356859;
      background: #edf1df;

      font-weight: bold;
      letter-spacing: 2px;
    }

    h1 {
      margin: 25px 0 15px;

      color: #8c302b;
      font-size: clamp(2.2rem, 7vw, 4rem);
      letter-spacing: 0.08em;

      text-shadow: 2px 2px #d6b36a;
    }

    .description {
      color: #645044;
      line-height: 1.8;
      word-break: keep-all;
    }

    nav {
      margin-top: 30px;
      padding-top: 25px;
      border-top: 3px double #b38b56;
    }

    nav h2 {
      margin-top: 0;
      color: #3d554b;
      font-size: 1.2rem;
    }

    ul {
      margin: 0;
      padding: 0;

      display: grid;
      gap: 12px;

      list-style: none;
    }

    a {
      display: block;
      padding: 14px 18px;

      border: 2px solid #a66a3f;
      border-radius: 3px;

      color: #4d3021;
      background: #f3dfb5;

      font-weight: bold;
      text-decoration: none;

      transition: 0.2s;
    }

    a::before {
      content: "❖";
      margin-right: 10px;
      color: #a02f2a;
    }

    a:hover {
      color: white;
      background: #356859;
      border-color: #294c42;

      transform: translateY(-3px);
      box-shadow: 0 5px 0 #294c42;
    }

    footer {
      margin-top: 30px;
      color: #8b735f;
      font-size: 0.85rem;
    }

    @media (width < 600px) {
      main {
        padding: 45px 25px 35px;
      }

      main::before {
        width: calc(100% + 40px);
      }
    }
  </style>
</head>

<body>
  <main>
    <div class="status">서버 정상 가동 중</div>

    <h1>자바 HTTP 객잔</h1>

    <p class="description">
      순수 Java로 구현한 HTTP 서버입니다.<br>
      아래 문을 통해 준비된 경로로 이동할 수 있습니다.
    </p>

    <nav>
      <h2>경로 안내</h2>

      <ul>
        <li>
          <a href="/health">
            서버 상태 확인
          </a>
        </li>

        <li>
          <a href="/api/users">
            사용자 목록(JSON)
          </a>
        </li>
      </ul>
    </nav>

    <footer>
      Java Simple HTTP Server
    </footer>
  </main>
</body>
</html>
            """;

    private static final String NOT_FOUND_PAGE = """
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>404 - 페이지를 찾을 수 없습니다</title>

  <style>
    * {
      box-sizing: border-box;
    }

    body {
      min-height: 100vh;
      margin: 0;

      display: grid;
      place-items: center;

      color: #34251d;
      background:
        repeating-linear-gradient(
          90deg,
          transparent 0 70px,
          #8b735520 71px
        ),
        #e8dec5;

      font-family: Georgia, "Noto Serif KR", serif;
    }

    main {
      position: relative;

      width: min(90%, 700px);
      margin-top: 70px;
      padding: 55px 60px 45px;

      border: 12px solid #633b25;
      border-radius: 4px;

      background: linear-gradient(#fffdf6dd, #f3ead5ee);

      box-shadow:
        0 18px 0 #3e281d,
        0 28px 30px #3e281d55;

      text-align: center;
    }

    /* 기와지붕 */
    main::before {
      content: "";

      position: absolute;
      left: 50%;
      bottom: 100%;

      width: calc(100% + 100px);
      height: 80px;

      background:
        repeating-radial-gradient(
          ellipse at 50% 100%,
          #343638 0 10px,
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

    .error-code {
      margin: 0;

      color: #8c302b;
      font-size: clamp(5rem, 18vw, 10rem);
      line-height: 0.9;

      text-shadow:
        3px 3px #d6b36a,
        6px 6px #633b25;
    }

    h1 {
      margin: 25px 0 15px;

      color: #3d554b;
      font-size: clamp(1.7rem, 5vw, 2.6rem);
    }

    p {
      color: #645044;
      line-height: 1.8;
      word-break: keep-all;
    }

    .notice {
      display: inline-block;
      margin-bottom: 15px;
      padding: 7px 18px;

      border: 2px solid #8c302b;

      color: #8c302b;
      background: #f5dfca;

      font-weight: bold;
      letter-spacing: 2px;
    }

    nav {
      margin-top: 30px;
      padding-top: 25px;

      border-top: 3px double #b38b56;
    }

    ul {
      margin: 0;
      padding: 0;

      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 12px;

      list-style: none;
    }

    a {
      display: block;
      padding: 14px 18px;

      border: 2px solid #a66a3f;
      border-radius: 3px;

      color: #4d3021;
      background: #f3dfb5;

      font-weight: bold;
      text-decoration: none;

      transition: 0.2s;
    }

    a::before {
      content: "❖";
      margin-right: 8px;
      color: #a02f2a;
    }

    a:hover {
      color: white;
      background: #356859;
      border-color: #294c42;

      transform: translateY(-3px);
      box-shadow: 0 5px 0 #294c42;
    }

    @media (width < 600px) {
      main {
        padding: 45px 25px 35px;
      }

      main::before {
        width: calc(100% + 40px);
      }

      ul {
        grid-template-columns: 1fr;
      }
    }
  </style>
</head>

<body>
  <main>
    <div class="notice">출입할 수 없는 문입니다</div>

    <p class="error-code">404</p>

    <h1>길을 잘못 드셨습니다</h1>

    <p>
      요청하신 경로에는 아직 문이 놓이지 않았습니다.<br>
      아래 안내를 따라 원래 길로 돌아가 주세요.
    </p>

    <nav aria-label="이동 가능한 경로">
      <ul>
        <li>
          <a href="/">대문으로 돌아가기</a>
        </li>

        <li>
          <a href="/health">서버 상태 확인</a>
        </li>
      </ul>
    </nav>
  </main>
</body>
</html>
            """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //    / 패스의 유의점
        //			다른 핸들러가 맡지 않은 모든 경로를 받는다.
        //			따라서 정확히 "/"인지 직접 확인하고 아니면 404를 출력하는 구현이 필요하다.


        try (exchange) {
            String path = exchange.getRequestURI().getPath();

            if (!path.equals("/")) {
                // 404 NOT FOUND
                SimpleHttpServer.sendResponse(exchange, 404, SimpleHttpServer.TYPE_HTML, NOT_FOUND_PAGE);
                return;
            }

            // MAIN PAGE
            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, HOME_PAGE);

        }
    }
}
