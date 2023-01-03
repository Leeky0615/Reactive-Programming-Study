package practice.chapter05.error;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * RxJava에서는 에러 발생 시, Observable을 생성한 함수에서 onError()를 호출하고,
 * subscribe의 onError()에서 해당 error를 받아서 처리하는 구조를 가진다.
 */
public class GeneralErrorHandleExample {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                        .take(5)
                        .map(i -> num / i))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(1000);
    }
}
