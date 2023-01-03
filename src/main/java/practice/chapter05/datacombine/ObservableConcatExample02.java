package practice.chapter05.datacombine;

import io.reactivex.rxjava3.core.Observable;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.Arrays;
import java.util.List;

public class ObservableConcatExample02 {
    public static void main(String[] args) {
        List<Observable<String>> observables = Arrays.asList(
                SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA),
                SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB),
                SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC)
        );

        Observable.concat(observables)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
