package inflearn.whiteship.java8._06_interface;

public interface Parent1 {
    default void method() {
        System.out.println("Parent1 method()");
    }
}
