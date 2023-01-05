package practice.chapter05.conditionandboolean;

import io.reactivex.rxjava3.core.Observable;
import practice.common.Car;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableAllExample {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .doOnNext(
                        car -> Logger.log(LogType.DO_ON_NEXT,
                                "Car Maker: " + car.getCarMaker() +
                                        "\tCar Name: " + car.getCarName()))
                .map(Car::getCarMaker)
                .all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
