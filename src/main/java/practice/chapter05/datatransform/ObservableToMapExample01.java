package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Map;

public class ObservableToMapExample01 {
    public static void main(String[] args) {
        Single<Map<String, String>> single =
                Observable.just("a-A", "b-B", "c-C", "d-D")
                        .toMap(data -> data.split("-")[0]); // - 구분자
        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
