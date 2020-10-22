package inflearn.whiteship.java8.onlineclass;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;


public class OnlineClass {
    @Getter
    private Integer id;

    @Getter
    private String title;

    @Getter
    private boolean closed;

    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    @Builder
    public OnlineClass(Integer id, String title, boolean closed, Progress progress) {
        this.id = id;
        this.title = title;
        this.closed = closed;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", closed=" + closed +
            '}';
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
}
