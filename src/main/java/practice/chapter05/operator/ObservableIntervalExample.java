package practice.chapter05.operator;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) {
        // 최초 통지 대기 시간 0L, 일정 대기 시간 1000L
        Observable.interval(0L, 1000L, TimeUnit.MICROSECONDS)
                .map(num -> num + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
