package practice.chapter05.conditionandboolean;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableContainsExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .contains(CarMaker.SAMSUNG)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
