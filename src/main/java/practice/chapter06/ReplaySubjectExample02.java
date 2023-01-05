package practice.chapter06;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import practice.utils.LogType;
import practice.utils.Logger;

public class ReplaySubjectExample02 {
    public static void main(String[] args) {
        ReplaySubject<Object> subject = ReplaySubject.createWithSize(2);
        subject.onNext(500);
        subject.onNext(1000);
        subject.onNext(1500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 A: " + price));
        subject.onNext(2000);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 B: " + price));
        subject.onNext(3000);

        subject.onComplete();

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 C: " + price));
    }
}
