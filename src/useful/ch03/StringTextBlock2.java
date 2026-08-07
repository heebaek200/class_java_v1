package useful.ch03;

public class StringTextBlock2 {

    public static void main(String[] args) {

        String textBlock = """                
                <!doctype html>
                <html lang="ko"><head><meta charset="utf-8">
                <meta name="viewport" content="user-scalable=no, initial-scale=1, width=device-width, viewport-fit=cover">
                <title>HTML - 나무위키</title>
                <script src="https://securepubads.g.doubleclick.net/tag/js/gpt.js" async></script>
                <script src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-7162146779303471" crossorigin="anonymous"></script>
                <meta http-equv="x-ua-compatible" content="ie=edge">
                <meta name="generator" content="the seed">
                <meta name="mobile-web-app-capable" content="yes">
                <meta name="application-name" content="나무위키">
                <meta name="msapplication-tooltip" content="나무위키">
                <meta name="color-scheme" content="light dark">
                <meta name="msapplication-starturl" content="/w/%EB%82%98%EB%AC%B4%EC%9C%84%ED%82%A4:%EB%8C%80%EB%AC%B8">
                <meta name="robots" content="max-image-preview:large">
                <meta property="og:title" content="HTML">
                <meta property="og:site_name" content="나무위키">
                <meta property="og:image" content="//i.namu.wiki/i/jpcc0PLOa8U09Ddq5FZKOWI1-K-k__ycLxmPtk6XxBWgSyzO4ez7jI3MSniJsdupH1qmlTTDWosUs5BVLDtG_9XXNJbGx8Q_H1zpTDSdXLA1MFkXVwjD-9JvrHTZiPWv8WrvuGrOrM1apk7WB_YhRQ.svg">
                <meta property="og:description" content="웹사이트 의 모습을 기술하기 위한  마크업 언어 . 프로그래밍 언어 가 아니라 마크업 정보를 표현하는  마크업 언어">
                <meta property="og:url" content="https://namu.wiki/w/HTML">
                <meta property="og:type" content="article">
                <link rel="canonical" href="https://namu.wiki/w/HTML">
                <link rel="search" type="application/opensearchdescription+xml" title="나무위키" href="/opensearch.xml">
                <link rel="copyright" href="//creativecommons.org/licenses/by-nc-sa/2.0/kr/">
                <meta name="googlebot" content="noarchive">
                <meta name="theme-color" content="#00a69c">
                <meta name="apple-itunes-app" content="app-id=1623510780">
                <meta name="google-play-app" content="app-id=net.umanle.namuwiki">
                <link rel="icon" href="/favicon.svg" sizes="any" type="image/svg+xml">
                <link rel="icon" href="/favicon-32.png" sizes="32x32" type="image/png">
                <link rel="icon" href="/favicon-192.png" sizes="192x192" type="image/png">
                """;

        //System.out.println(textBlock);
        changeText(textBlock);

    } // end of main

    // 나무위키를 킹갓위키로 변경하는 코드
    public static void changeText(String str) {

        String result = str.replace("나무위키", "킹갓위키");

        System.out.println(result);
    }

}
