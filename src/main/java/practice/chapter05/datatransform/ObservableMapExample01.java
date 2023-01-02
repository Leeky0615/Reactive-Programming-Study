package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Arrays;
import java.util.List;

public class ObservableMapExample01 {
    public static void main(String[] args) {
        List<Integer> odds = Arrays.asList(1, 3, 5, 7);
        Observable.fromIterable(odds)
                .map(data -> "1을 더한 결과: " + (data + 1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
