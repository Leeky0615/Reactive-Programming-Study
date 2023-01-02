package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableFlatMapExample02 {
    public static void main(String[] args) {
        Observable.range(3, 1)
                .flatMap(data -> Observable
                        .range(1, 9)
                        .map(num -> data + " x " + num + " = " + data * num))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
