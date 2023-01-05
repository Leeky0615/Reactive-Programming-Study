package practice.chapter05.dataaccumulation.exercise;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableDataAccumulationQuiz {
    public static void main(String[] args) {
        Observable.range(1, 9)
                .reduce(10, (x, y) -> x - y)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
