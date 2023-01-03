package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.NumberUtil;
import practice.utils.TimeUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ObservableCombineExample02 {
    public static void main(String[] args) {
        // 랜덤 온도
        Observable<Integer> observableA =
                Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                        .take(10)
                        .map(notUse -> SampleData.temperatureOfSeoul[NumberUtil.randomRange(0, 5)]);

        // 랜덤 습도
        Observable<Integer> observableB =
                Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                        .take(10)
                        .map(notUse -> SampleData.humidityOfSeoul[NumberUtil.randomRange(0, 5)]);

        Observable.combineLatest(observableA, observableB,
                        (temperature, humidity) -> "최신 온도 & 습도 -> 온도: " + temperature + "도\t습도: " + humidity + "%")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000L);
    }
}
