package practice.chapter05.datacombine.exercise;

import io.reactivex.rxjava3.core.Observable;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Arrays;
import java.util.List;

public class ObservableCombineQuiz {
    public static void main(String[] args) {
        List<Observable<Integer>> observables = Arrays.asList(Observable.fromIterable(SampleData.salesOfBranchA),
                Observable.fromIterable(SampleData.salesOfBranchB),
                Observable.fromIterable(SampleData.salesOfBranchC),
                Observable.range(1, 12));

        Observable.zip(observables,
                        data -> data[3] + "월 매출: " + ((int) data[0] + (int) data[1] + (int) data[2]) + "원")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

    }
}
