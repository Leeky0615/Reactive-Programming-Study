package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ObservableMergeExample01 {
    public static void main(String[] args) {
        Observable<Long> observableA =
                Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .take(5);

        Observable<Long> observableB =
                Observable.interval(400L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(num -> num + 1000);
        Observable.merge(observableA, observableB)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4000L);
    }
}
