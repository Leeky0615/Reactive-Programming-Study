package practice.chapter05.filtering.exersice;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.concurrent.TimeUnit;

public class ObservableQuiz03 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(11500L);
    }
}
