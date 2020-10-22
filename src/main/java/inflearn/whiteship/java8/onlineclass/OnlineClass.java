package inflearn.whiteship.java8.onlineclass;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;


@Getter
public class OnlineClass {
    private Integer id;
    private String title;
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
}
