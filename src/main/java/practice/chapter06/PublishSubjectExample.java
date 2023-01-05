package practice.chapter06;

import io.reactivex.rxjava3.subjects.PublishSubject;
import practice.utils.LogType;
import practice.utils.Logger;

public class PublishSubjectExample {
    public static void main(String[] args) {
        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 A: " + price));
        subject.onNext(3500);
        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 B: " + price));
        subject.onNext(3300);
        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 C: " + price));
        subject.onNext(4000);

        subject.subscribe(
                price -> Logger.log(LogType.ON_NEXT, "# 소비자 D: " + price),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        subject.onComplete();

    }
}
