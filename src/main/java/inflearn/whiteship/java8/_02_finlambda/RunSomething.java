package inflearn.whiteship.java8._02_finlambda;

@FunctionalInterface
public interface RunSomething {
    /**
     * abstract 메소드가 하나만 존재해야만 @FunctionalInterface 를 붙일 수 있음.
     * default 메소드나 static 메소드는 추상이 아니므로 정의 되어 있어도 무방함.
     */
    int doIt(int number);

    default void printName() {
        System.out.println("Name");
    }

    static void printAge() {
        System.out.println("age");
    }
}
