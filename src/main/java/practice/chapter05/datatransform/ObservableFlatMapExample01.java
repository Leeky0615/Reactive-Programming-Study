package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableFlatMapExample01 {
    public static void main(String[] args) {
        Observable.just("hello")
                .flatMap(data -> Observable
                        .just("java", "python", "android")
                        .map(s -> data + " " + s))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
