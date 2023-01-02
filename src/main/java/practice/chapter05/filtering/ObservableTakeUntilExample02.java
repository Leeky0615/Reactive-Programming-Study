package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.common.Car;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.concurrent.TimeUnit;

public class ObservableTakeUntilExample02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("----takeUntil 적용----");
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(5500L);

    }
}
