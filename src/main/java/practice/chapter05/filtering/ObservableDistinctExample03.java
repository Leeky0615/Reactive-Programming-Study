package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableDistinctExample03 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .distinct(car -> car.getCarMaker())
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
