package inflearn.whiteship.java8._02_finlambda;

/**
 * 익명 클래스는 람다로 변환 가능
 */
public class 함수형인터페이스와_람다표현식01 {
    public static void main(String[] args) {
        // 익명클래스
        RunSomething anonymousClass = new RunSomething() {
            @Override
            public int doIt(int number) {
                int result = number + 10;
                System.out.println("anonymousClass: " + result);
                return result;
            }
        };
        anonymousClass.doIt(5);

        // 익명 클래스는 람다로 변환 가능
        RunSomething lambda = (number) -> {
            int result = number + 10;
            System.out.println("lambda: " + result);
            return result;
        };

        lambda.doIt(5);
    }
}
