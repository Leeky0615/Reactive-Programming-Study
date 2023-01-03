package practice.chapter05.filtering;

import io.reactivex.rxjava3.core.Observable;
import practice.common.Car;
import practice.common.SampleData;

public class ObservableTakeUntilExample01 {
    public static void main(String[] args) {
        System.out.println("----기존 데이터----");
        Observable.fromIterable(SampleData.carList)
                .subscribe(car -> System.out.println(car.getCarName()));
        System.out.println("----takeUntil 적용----");
        Observable.fromIterable(SampleData.carList)
                .takeUntil((Car car) -> car.getCarName().equals("트랙스"))
                .subscribe(car -> System.out.println(car.getCarName()));

        try {
            TimeUtil.sleep(300L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
