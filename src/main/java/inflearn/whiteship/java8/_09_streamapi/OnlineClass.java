package inflearn.whiteship.java8._09_streamapi;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    @Builder
    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
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
