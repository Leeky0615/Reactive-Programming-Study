package practice.chapter05.utility;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableDelayExample02 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4)
                .delay(item -> {
                    TimeUtil.sleep(1000L);
                    return Observable.just(item);
                })
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2500);
    }
}
