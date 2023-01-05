package practice.chapter05.dataaccumulation;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableReduceExample02 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, (x, y) -> {
                    // parameter seed -> 초기 값
                    Logger.log(LogType.PRINT, "# reduce 입력 값: " + x + ", " + y);
                    return x + y;
                })
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
