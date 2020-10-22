package inflearn.whiteship.java8._10_optional;

import inflearn.whiteship.java8.onlineclass.OnlineClass;
import inflearn.whiteship.java8.onlineclass.Progress;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class OptionalEx {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Progress progress = getProgressUsingFlatMap(springClasses, "spring");
        log.info("progress: {}", progress);

        Optional<Progress> optionalProgress = getOptionalProgressUsingFlatMap(springClasses, "spring");
        optionalProgress.ifPresent((p) -> log.info("optionalProgress: {}", p));

        OnlineClass orElseClass = getFirstClassUsingOrElse(springClasses, "spring");
        log.info("orElseClass: {}", orElseClass);

        String springTitle = getFirstTitleUsingOrElse(springClasses, "spring");
        log.info("springTitle: {}", springTitle);

        OnlineClass orElseGetClass = getFirstClassUsingOrElseGet(springClasses, "spring");
        log.info("orElseGetClass: {}", orElseGetClass);

        OnlineClass orElseThrowClass = getFirstClassUsingOrElseThrow(springClasses, "spring");
        log.info("orElseThrowClass: {}", orElseThrowClass);

        OnlineClass orElseThrowClass2 = getFirstClassUsingOrElseThrow(springClasses, "node");
        log.info("orElseThrowClass2: {}", orElseThrowClass2);
    }

    private static Optional<OnlineClass> getFirstClass(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .findFirst();
    }

    /**
     * orElse() 는 인자에 값이 들어가므로
     * 해당 인자에 값을 얻어오는 메소드가 들어가는 경우 이 메소드를 반드시 한번 실행 해줘야 함.
     * 따라서, 해당 인자에 새 객체를 생성하는 메소드 같은게 들어가면 쓸데없이 객체를 생성하게 될 수도 있으므로 주의해야 함.
     * orElse() 인자의 값으로 상수가 들어갈 때에 사용하면 유용함.
     */
    private static OnlineClass getFirstClassUsingOrElse(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .findFirst()
            .orElse(getDefaultClass());
    }

    private static String getFirstTitleUsingOrElse(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .map(OnlineClass::getTitle)
            .findFirst()
            .orElse("");
    }

    /**
     * orElseGet() 은 인자에 값이 아닌 Supplier 가 들어가므로
     * 메소드를 실행하지 않고 Optional에 값이 존재하는 지를 먼저 판단함.
     * 값이 없을 때만 Supplier를 실행 해 줌.
     */
    private static OnlineClass getFirstClassUsingOrElseGet(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .findFirst()
            .orElseGet(OptionalEx::getDefaultClass);
    }

    private static OnlineClass getDefaultClass() {
        log.info("getNewOnlineClass()");
        return new OnlineClass(-1, "default class", false);
    }

    private static OnlineClass getFirstClassUsingOrElseThrow(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }


    private static Progress getProgressUsingFlatMap(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title) && Objects.nonNull(oc.getProgress()))
            .findFirst()
            .flatMap(OptionalEx::getProgress)
            .orElseGet(() -> new Progress(Duration.ZERO, false));
    }

    private static Optional<Progress> getOptionalProgressUsingFlatMap(List<OnlineClass> classes, String title) {
        return classes.stream()
            .filter(oc -> oc.getTitle().contains(title))
            .findFirst()
            .flatMap(OptionalEx::getProgress);
    }

    private static Optional<Progress> getProgress(OnlineClass onlineClass) {
        return Optional.ofNullable(onlineClass.getProgress());
    }
}
