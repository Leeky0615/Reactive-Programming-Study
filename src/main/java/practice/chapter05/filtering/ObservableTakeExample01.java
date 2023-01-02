package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableTakeExample01 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d")
                .take(2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
