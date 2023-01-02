package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableSkipExample01 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .skip(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
