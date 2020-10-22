package inflearn.whiteship.java8._09_streamapi;

import inflearn.whiteship.java8.onlineclass.OnlineClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExercise {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("1. title 이 'spring' 이라는 텍스트로 시작하는 수업: " + getClassesStartsWithKeyword(springClasses, "spring"));
        System.out.println("2. closed 되지 않은 수업: " + getNotClosedClasses(springClasses));
        System.out.println("3. classTitles: " + getTitles(springClasses));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> classLists = new ArrayList<>();
        classLists.add(springClasses);
        classLists.add(javaClasses);

        System.out.println("4. 두 수업 목록에 들어있는 모든 수업 id 출력: " + getFlattedClasses(classLists));
        System.out.println("5. 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만: " + getIteratedStream(10, 1, 10, 10));
        System.out.println("6. 자바 수업 중에 Test 가 들어있는 수업이 있는지 확인: " + hasAnyClassContainingKeyword(javaClasses, "Test"));
        System.out.println("7. 스프링 수업 중에 제목에 spring이 들어간 수업: " + getClassesContainsKeyword(springClasses, "spring"));
    }

    /**
     * 1. 수업 이름이 특정 키워드로 시작되는 수업들만 획득
     */
    private static List<Integer> getClassesStartsWithKeyword(List<OnlineClass> springClasses, String keyword) {
        return springClasses.stream()
            .filter((c) -> c.getTitle().startsWith(keyword))
            .map(OnlineClass::getId)
            .collect(Collectors.toList());
    }

    /**
     * 2. 종료 되지 않은 수업들만 획득
     */
    private static List<Integer> getNotClosedClasses(List<OnlineClass> springClasses) {
        return springClasses.stream()
            .filter((c) -> !c.isClosed())
            .map(OnlineClass::getId)
            .collect(Collectors.toList());
    }

    /**
     * 3. 수업 이름들만 획득
     */
    private static List<String> getTitles(List<OnlineClass> classes) {
        return classes.stream()
            .map(OnlineClass::getTitle)
            .collect(Collectors.toList());
    }

    /**
     * 4. 두 수업 목록에 들어있는 모든 수업 id 획득
     */
    private static List<Integer> getFlattedClasses(List<List<OnlineClass>> classLists) {
        return classLists.stream()
            .flatMap(Collection::stream)
            .map(OnlineClass::getId)
            .collect(Collectors.toList());
    }

    /**
     * 5. 시작점, 증분, skip, maxSize  지정하여 long 리스트 획득
     */
    private static List<Long> getIteratedStream(long seed, final int increment, long skipCount, long maxSize) {
        return Stream.iterate(seed, i -> i + increment)
            .skip(skipCount)
            .limit(maxSize)
            .collect(Collectors.toList());
    }

    /**
     * 6. 수업 이름에 특정 키워드가 들어있는 수업이 있는지 확인
     */
    private static boolean hasAnyClassContainingKeyword(List<OnlineClass> classes, String keyword) {
        return classes.stream()
            .anyMatch(c -> c.getTitle().contains(keyword));
    }

    /**
     * 7. 수업 이름이 특정 키워드를 포함하는 수업의 이름들만 획득
     */
    private static List<String> getClassesContainsKeyword(List<OnlineClass> classes, String keyword) {
        return classes.stream()
            .filter(c -> c.getTitle().contains(keyword))
            .map(OnlineClass::getTitle)
            .collect(Collectors.toList());
    }
}
