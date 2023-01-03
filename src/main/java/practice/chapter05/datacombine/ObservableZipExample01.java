package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableZipExample01 {
    public static void main(String[] args) {
        Observable<Long> observableA =
                Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .take(4);

        Observable<Long> observableB =
                Observable.interval(400L, TimeUnit.MILLISECONDS)
                        .take(6);

        Observable.zip(observableA, observableB, Long::sum)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4000L);
    }
}
