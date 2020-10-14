package inflearn.whiteship.java8._06_interface;

public interface Foo {
    String getName();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력함.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static String staticMethod() {
        return "staticMethod";
    }
}
