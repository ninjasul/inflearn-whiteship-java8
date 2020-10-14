package inflearn.whiteship.java8._04_variablecapture;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class VariableCapture {

    public static void main(String[] args) {
        VariableCapture variableCapture = new VariableCapture();
        variableCapture.run();
    }

    private void run() {
        final int baseVariable = 10;
        final int baseField = 10;

        /**
         * 로컬 클래스: 별도 Scope이 적용됨.
         * baseVariable, baseField 라는 로컬 변수와 같은 이름의 변수를 재정의 할 수 있음.
         */
        class LocalClass {
            private int baseField = 20;

            void printBaseNumber(int number) {
                int baseVariable = 20;

                System.out.println("localClass baseVariable:" + baseVariable);
                System.out.println("localClass baseField:" + baseField);
            }
        }
        new LocalClass().printBaseNumber(0);

        /**
         * 익명 클래스: 별도 Scope이 적용됨.
         * baseVariable, baseField 라는 로컬 변수와 같은 이름의 변수를 재정의 할 수 있음.
         */
        Consumer<Integer> anonymousClass = new Consumer<Integer>() {
            private int baseField = 30;

            @Override
            public void accept(Integer number) {
                int baseVariable = 30;
                System.out.println("anonymousClass baseVariable:" + baseVariable);
                System.out.println("anonymousClass baseField:" + baseField);
            }
        };
        anonymousClass.accept(0);

        /**
         * 람다: run() 메소드 Scope을 적용 받음.
         * 따라서 람다 내에 baseVariable,  baseField 이름의 변수를 재정의 할 수 없음.(컴파일 오류 발생)
         */
        IntConsumer lambda = (i) -> {
            //int baseVariable = 40;
            //int baseField = 40;
            System.out.println("lambda baseVariable:" + baseVariable);
            System.out.println("lambda baseField:" + baseField);
        };
        lambda.accept(0);

    }
}
