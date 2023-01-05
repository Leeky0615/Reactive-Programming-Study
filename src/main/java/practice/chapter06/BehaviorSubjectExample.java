package practice.chapter06;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import practice.utils.LogType;
import practice.utils.Logger;

public class BehaviorSubjectExample {
    public static void main(String[] args) {
        BehaviorSubject<Object> subject = BehaviorSubject.create();

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 A: " + price));
        subject.onNext(2000);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 B: " + price));
        subject.onNext(3000);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 C: " + price));
        subject.onNext(4000);
    }
}
