package practice.chapter07;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.Arrays;
import java.util.Collections;

public class SchedulersComputationExample {
    public static void main(String[] args) {
        Observable<Integer> observableA = Observable.fromIterable(SampleData.seoulPM10List);
        Observable<Integer> observableB = Observable.fromIterable(SampleData.busanPM10List);
        Observable<Integer> observableC = Observable.fromIterable(SampleData.incheonPM10List);

        Observable<Integer> observableD = Observable.range(1, 24);

        Observable<String> source = Observable.zip(
                observableA, observableB, observableC, observableD,
                (data1, data2, data3, hour) -> hour + "시: " + Collections.max(Arrays.asList(data1, data2, data3)));

        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        source.subscribeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(500L);


    }
}
