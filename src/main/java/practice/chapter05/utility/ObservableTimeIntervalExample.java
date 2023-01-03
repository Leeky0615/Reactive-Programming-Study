package practice.chapter05.utility;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.NumberUtil;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableTimeIntervalExample {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7, 9)
                .delay(item -> {
                    TimeUtil.sleep(NumberUtil.randomRange(100, 1000));
                    return Observable.just(item);
                })
                .timeInterval()
                .subscribe(
                        timed -> Logger.log(
                                LogType.ON_NEXT,
                                "# 통지하는데 걸린 시간: " + timed.time() +
                                        "\t# 통지된 데이터: " + timed.value())
                );

        TimeUtil.sleep(4000L);
    }
}
