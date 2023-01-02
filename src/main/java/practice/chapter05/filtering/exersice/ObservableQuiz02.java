package practice.chapter05.filtering.exersice;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ObservableQuiz02 {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeWhile(data -> data != 10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(10000L);
    }
}
