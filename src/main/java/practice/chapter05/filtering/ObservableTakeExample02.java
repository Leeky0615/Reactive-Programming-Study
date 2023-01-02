package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ObservableTakeExample02 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(3500L, TimeUnit.MILLISECONDS)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(3500L);
    }
}
