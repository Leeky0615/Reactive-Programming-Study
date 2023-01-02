package practice.chapter05;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableRangeExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(0, 5);
        source.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
    }
}
