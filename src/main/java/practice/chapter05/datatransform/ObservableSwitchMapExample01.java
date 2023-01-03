package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample01 {
    public static void main(String[] args) {
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                .switchMap(
                        num -> Observable.interval(300L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " x " + row + " = " + num * row)
                ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {
                        },
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        }
                );
        TimeUtil.sleep(5000L);
    }
}
