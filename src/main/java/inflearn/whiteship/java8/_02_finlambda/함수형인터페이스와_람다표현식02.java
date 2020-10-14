package inflearn.whiteship.java8._02_finlambda;

/**
 * 함수형 프로그래밍은 같은 값을 입력 했을 때 같은 결과를 리턴해야 함.
 * 상황에 따라서는 그렇지 못할 수도 있음.
 */
public class 함수형인터페이스와_람다표현식02 {
    public static void main(String[] args) {
        RunSomething lambda = (number) -> {
            int result = number + 10;
            System.out.println("lambda: " + result);
            return result;
        };

        lambda.doIt(5);
        lambda.doIt(5);

        lambda.doIt(10);
        lambda.doIt(10);

        RunSomething anonymousClass = new RunSomething() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                baseNumber++;
                int result = number + baseNumber;
                System.out.println("anonymousClass: " + result);
                return result;
            }
        };

        anonymousClass.doIt(5);
        anonymousClass.doIt(5);

        anonymousClass.doIt(10);
        anonymousClass.doIt(10);
    }
}
