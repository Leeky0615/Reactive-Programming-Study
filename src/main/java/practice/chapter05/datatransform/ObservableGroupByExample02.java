package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import practice.common.Car;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableGroupByExample02 {
    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList).groupBy(Car::getCarMaker);

        observable.subscribe(
                groupedObservable -> groupedObservable
                        .filter(car -> groupedObservable.getKey() == CarMaker.CHEVROLET)
                        .subscribe(
                                car -> Logger.log(LogType.ON_NEXT, "Group: " + groupedObservable.getKey() + " | Name: " + car.getCarName())
                        )
        );
    }
}
