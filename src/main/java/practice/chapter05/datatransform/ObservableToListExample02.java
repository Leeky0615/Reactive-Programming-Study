package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import practice.common.SampleData;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.List;

public class ObservableToListExample02 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .toList()
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
