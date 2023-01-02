package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.List;

public class ObservableToListExample01 {
    public static void main(String[] args) {
        Single<List<Integer>> single =
                Observable.just(2, 4, 6, 8).toList();

        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
