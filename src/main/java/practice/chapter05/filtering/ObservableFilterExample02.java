package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableFilterExample02 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker() == CarMaker.CHEVROLET)
                .filter(car -> car.getCarPrice() > 30000000)
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
