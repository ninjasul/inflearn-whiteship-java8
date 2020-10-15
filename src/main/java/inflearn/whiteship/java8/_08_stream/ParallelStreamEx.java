package inflearn.whiteship.java8._08_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
          "ninjasul",
          "dy",
          "sy",
          "foo"
        );

        /**
         * stream 은 같은 스레드에서 직렬로 처리
         * parallelStream 은 서로 다른 스레드에서 병렬로 처리
         * 하지만 parallelStream 은 조합 시간이 별도로 소요되므로 stream 보다 항상 빠르다는 보장은 없음.
         * 대량의 데이터 처리 시에는 parallelStream 을 사용해 보는 것도 나쁘지 않음.
         */
        long start = System.currentTimeMillis();

        names.stream()
            .map(ParallelStreamEx::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("stream elapsed: " + (System.currentTimeMillis() - start));

        System.out.println("---------------------");

        start = System.currentTimeMillis();
        names.parallelStream()
            .map(ParallelStreamEx::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("parallelStream elapsed: " + (System.currentTimeMillis() - start));
    }

    private static String toUpperCase(String str) {
        System.out.println(Thread.currentThread().getName() + ": " + str);
        return str.toUpperCase();
    }
}
