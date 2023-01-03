package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableConcatExample01 {
    public static void main(String[] args) {
        Observable<Long> observableA =
                Observable.interval(500L, TimeUnit.MILLISECONDS)
                        .take(4);

        Observable<Long> observableB =
                Observable.interval(300L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(num -> num + 1000);
        Observable.concat(observableA, observableB)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3500L);
    }
}
