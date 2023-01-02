package practice.chapter05.datatransform.exercise;

import io.reactivex.rxjava3.core.Observable;
import practice.common.Car;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class DataTransformQuiz03 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .toMultimap(Car::getCarMaker, Car::getCarName)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}

