package com.oop10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    // static main 메서드 - 코드 진입점
    public static void main(String[] args) {
        int game1 = LottoNumberMaker.makeNumber();
        int game2 = LottoNumberMaker.makeNumber();
        int game3 = LottoNumberMaker.makeNumber();
        int game4 = LottoNumberMaker.makeNumber();
        int game5 = LottoNumberMaker.makeNumber();
        int game6 = LottoNumberMaker.makeNumber();

        //System.out.println(game1 + ", " + game2 + ", " + game3 + ", " + game4 + ", " + game5 + ", " + game6);

        // 스트림으로 join 연결해보기
        String msg = IntStream.of(game1, game2, game3, game4, game5, game6)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        // 풀어써보기
        IntStream myIntStream = IntStream.of(game1, game2, game3, game4, game5, game6);
        Stream<String> myStrStream = myIntStream.mapToObj(x -> String.valueOf(x));
        String msg2 = myStrStream.collect(Collectors.joining(", "));

        System.out.println(msg2);

    }


}
