package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableFlatMapExample03 {
    public static void main(String[] args) {
        Observable.range(3, 1)
                .flatMap(
                        data -> Observable.range(1, 9),
                        (source, transformSource) ->
                                source + " x " + transformSource + " = " + source * transformSource)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
