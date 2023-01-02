package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample01 {
    public static void main(String[] args) throws InterruptedException {
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .concatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
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
        Thread.sleep(5000L);

        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .flatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
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
        Thread.sleep(5000L);

    }
}
