package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Map;

public class ObservableToMapExample02 {
    public static void main(String[] args) {
        Observable
                .just("a-A", "b-B", "c-C", "d-D")
                .toMap(
                        data -> data.split("-")[0],
                        data -> data.split("-")[1])
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
