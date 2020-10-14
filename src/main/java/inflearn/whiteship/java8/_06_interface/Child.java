package inflearn.whiteship.java8._06_interface;

/**
 * 같은 메소드 시그니처를 가진 두 인터페이스를 구현하고자 할 때는 메소드 상속은 불가하고 직접 구현해야 함.
 * 컴파일 오류가 발생
 */
public class Child implements Parent1, Parent2 {
    @Override
    public void method() {
        System.out.println("Child method()");
    }
}
