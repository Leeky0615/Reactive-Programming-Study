package practice.chapter05.error;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorResumeNextExample {
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num / i)
                        .onErrorResumeNext(throwable -> {
                            Logger.log(LogType.PRINT, "# 이메일 발송: " + throwable.getMessage());
                            return Observable
                                    .interval(200L, TimeUnit.MILLISECONDS)
                                    .take(5)
                                    .skip(1)
                                    .map(i -> num / i);
                        }))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);

    }
}
