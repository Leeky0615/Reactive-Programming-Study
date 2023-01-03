package practice.chapter05.error;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample03 {
    private final static int RETRY_MAX = 5;

    public static void main(String[] args) {
        Observable.just(10, 12, 15, 16)
                .zipWith(Observable.just(1, 2, 0, 4), (a, b) -> {
                    int result;
                    try {
                        result = a / b;
                    } catch (ArithmeticException e) {
                        Logger.log(LogType.PRINT, "error: " + e.getMessage());
                        throw e;
                    }
                    return result;
                })
                .retry(3)
                .onErrorReturn(throwable -> -1)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(6000L);
    }
}
