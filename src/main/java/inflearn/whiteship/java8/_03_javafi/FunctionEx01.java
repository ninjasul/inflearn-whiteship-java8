package inflearn.whiteship.java8._03_javafi;

import java.util.function.Function;

public class FunctionEx01 {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        /**
         * compose: 인자로 들어온 Function을 우선 실행
         * 즉, multiply2 실행 후 plus10 실행
         */
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        /**
         * andThen: 인자로 들어온 Function을 나중에 실행
         * 즉, plus10 실행 후 multiply2 실행
         */
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2));
    }
}
