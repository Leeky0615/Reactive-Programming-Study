package practice.chapter05.filtering.exersice;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.concurrent.TimeUnit;

public class ObservableQuiz04 {
    public static void main(String[] args) {
        Observable.range(1,15)
                .skipLast(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
