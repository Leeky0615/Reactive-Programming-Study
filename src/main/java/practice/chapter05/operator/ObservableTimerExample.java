package practice.chapter05.operator;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# start");
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .map(count -> "Do Work!")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
