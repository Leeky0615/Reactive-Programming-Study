package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableCombineExample01 {
    public static void main(String[] args) {
        Observable<Long> observableA =
                Observable.interval(500L, TimeUnit.MILLISECONDS)
                        .take(4);

        Observable<Long> observableB =
                Observable.interval(700L, TimeUnit.MILLISECONDS)
                        .take(4);

        Observable.combineLatest(observableA, observableB, (data1, data2) -> "data1: " + data1 + "\tdata2: " + data2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4000L);
    }
}
