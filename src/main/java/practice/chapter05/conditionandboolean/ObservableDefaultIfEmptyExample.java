package practice.chapter05.conditionandboolean;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableDefaultIfEmptyExample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .filter(num -> num > 10)
                .defaultIfEmpty(10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
