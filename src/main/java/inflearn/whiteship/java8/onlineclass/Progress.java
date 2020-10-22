package inflearn.whiteship.java8.onlineclass;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class Progress {
    private Duration studyDuration;
    private boolean finished;

    @Builder
    public Progress(Duration studyDuration, boolean finished) {
        this.studyDuration = studyDuration;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Progress{" +
            "studyDuration=" + studyDuration +
            ", finished=" + finished +
            '}';
    }
}
