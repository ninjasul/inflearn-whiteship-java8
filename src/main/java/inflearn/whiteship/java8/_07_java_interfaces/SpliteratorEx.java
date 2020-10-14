package inflearn.whiteship.java8._07_java_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
            "ninjasul",
            "dy",
            "sy",
            "foo"
        );

        Spliterator<String> spliterator1 = names.spliterator();

        /**
         * Spliterator의 trySplit() 메소드는 Spliterator를 기본적으로 둘로 쪼개줌.
         *
         * trySplit() 의 리턴 값에 첫번째 절반의 항목들이 들어있음. (ninjasul, dy)
         * trySplit() 의 콜러에 두번째 절반의 항목들이 들어있음. (sy, foo)
         */
        Spliterator<String> spliterator2 = spliterator1.trySplit();


        /**
         * tryAdvance() 메소드는 인자로 들어온 Consumer를 차례대로 실행하는데,
         * 다음 항목이 있으면 true, 없으면 false를 리턴함.
         */
        while (spliterator2.tryAdvance((str) -> {
            System.out.println("spliterator2's item: " + str);
        }));

        while (spliterator1.tryAdvance((str) -> {
            System.out.println("spliterator1's item: " + str);
        }));
    }
}
