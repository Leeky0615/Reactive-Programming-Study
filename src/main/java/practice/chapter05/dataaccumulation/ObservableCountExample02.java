package practice.chapter05.dataaccumulation;

import io.reactivex.rxjava3.core.Observable;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Arrays;

public class ObservableCountExample02 {
    public static void main(String[] args) {
        Observable
                .concat(
                        Arrays.asList(
                                Observable.fromIterable(SampleData.seoulPM10List),
                                Observable.fromIterable(SampleData.busanPM10List),
                                Observable.fromIterable(SampleData.incheonPM10List)
                        )
                )
                .count()
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
