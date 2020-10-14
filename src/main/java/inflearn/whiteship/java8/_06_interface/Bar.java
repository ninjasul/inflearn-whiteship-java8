package inflearn.whiteship.java8._06_interface;

public interface Bar extends Foo {
    /**
     * 부모 인터페이스의 default 메소드를 사용하고 싶지 않을 때는 아래와 같이 abstract로 변경
     */
    void printNameUpperCase();
}
