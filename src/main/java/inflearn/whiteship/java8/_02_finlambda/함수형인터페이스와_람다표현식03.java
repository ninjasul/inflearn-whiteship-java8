package inflearn.whiteship.java8._02_finlambda;

/**
 * 람다 함수 내부에서는 final 이나 사실상 final 처럼 초기값을 변경하지 않는 변수만 참조할 수 있음.
 * 외부 변수 값을 변경할 경우 람다 함수 내부에서 외부 변수 참조를 하는 코드에 컴파일 오류가 발생함.
 */
public class 함수형인터페이스와_람다표현식03 {
    public static void main(String[] args) {
        int baseNumber = 10;

        RunSomething lambda = number -> {
            int result = number + baseNumber;
            System.out.println("anonymousClass: " + result);
            return result;
        };

        // baseNumber++;

        lambda.doIt(10);
    }
}
