package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.concurrent.TimeUnit;

public class ObservableSkipExample02 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(300L, TimeUnit.MILLISECONDS)
                .skip(1000L, TimeUnit.MILLISECONDS)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(3000L);
    }
}
