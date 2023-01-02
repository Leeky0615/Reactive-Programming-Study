package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableDistinctExample01 {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car));
    }
}
