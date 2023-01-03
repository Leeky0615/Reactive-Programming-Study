package practice.chapter05.error;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(
                        num -> Observable
                                .interval(200L, TimeUnit.MILLISECONDS)
                                .map(i -> {
                                    long result;
                                    try {
                                        result = num / i;
                                    } catch (ArithmeticException e) {
                                        Logger.log(LogType.PRINT, "error: " + e.getMessage());
                                        throw e;
                                    }
                                    return result;
                                })
                                .retry(5)
                                .onErrorReturn(throwable -> -1L))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(5000L);
    }
}
