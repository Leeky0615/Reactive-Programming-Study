package practice.chapter06;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import practice.utils.LogType;
import practice.utils.Logger;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        AsyncSubject<Object> subject = AsyncSubject.create();
        subject.onNext(2000);

        subject
                .doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 A: " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 A: " + price));
        subject.onNext(3500);
        subject
                .doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 B: " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 B: " + price));
        subject.onNext(3300);
        subject
                .doOnNext((price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 C: " + price)))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 C: " + price));
        subject.onNext(4000);

        subject.onComplete();

        subject
                .doOnNext((price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 D: " + price)))
                .subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 D: " + price));
    }
}
