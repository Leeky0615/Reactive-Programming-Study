package practice.chapter05.utility;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableMaterializeExample01 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                .materialize()
                .subscribe(notification -> {
                    String type = notification.isOnNext()
                            ? "onNext()"
                            : (notification.isOnError() ? "onError()" : "onComplete()");
                    Logger.log(LogType.PRINT, "notification 타입: " + type);
                    Logger.log(LogType.ON_NEXT, notification.getValue());
                });
    }
}
