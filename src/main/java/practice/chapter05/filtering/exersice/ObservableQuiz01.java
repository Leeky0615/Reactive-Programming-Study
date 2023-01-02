package practice.chapter05.filtering.exersice;

import io.reactivex.rxjava3.core.Observable;
import practice.common.CarMaker;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableQuiz01 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker() == CarMaker.SSANGYOUNG)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data.getCarMaker()));
    }
}
