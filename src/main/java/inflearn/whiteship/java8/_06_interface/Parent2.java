package inflearn.whiteship.java8._06_interface;

public interface Parent2 {
    default void method() {
        System.out.println("Parent2 method()");
    }
}
