package practice.chapter05.dataaccumulation;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableScenExample03 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
                .scan((x, y) -> "(" + x + ", " + y + ")")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
