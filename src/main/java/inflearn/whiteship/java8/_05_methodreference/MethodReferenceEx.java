package inflearn.whiteship.java8._05_methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceEx {
    public static void main(String[] args) {
        /**
         * static 메소드 참조: 클래스명::메소드명
         */
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("ninjasul"));


        /**
         * 인스턴스 메소드 참조: 인스턴스변수명::메소드명
         */
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("ninjasul"));


        /**
         * 인자가 없는 생성자 참조: Supplier로 참조
         */
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greetingWithoutName = greetingSupplier.get();
        System.out.println(greetingWithoutName.hello("ninjasul"));


        /**
         * 인자가 있는 생성자 참조: Function으로 참조
         */
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting greetingWithName = greetingFunction.apply("ninjasul");
        System.out.println(greetingWithName.getName());

        /**
         * 특정 객체의 인스턴스 메소드 참조
         */
         List<String> names = Arrays.asList("ninjasul", "dy", "sy");
         names.sort(String::compareToIgnoreCase);
         System.out.println(names);
    }
}
