package practice.chapter05;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.time.LocalTime;

/**
 * just()의 경우 구독 1, 2의 시간이 같다. 즉, just()가 선언되는 시점에 현재 시간을 통지한다.
 * defer()의 경우 구독 1, 2의 시간이 지연시간만큼 차이난다. 즉, defer()로 생성한 Observable로 구독을 한 시점의 시간을 출력한다.
 */
public class ObservableDeferExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> defer = Observable.defer(() -> {
            LocalTime now = LocalTime.now();
            return Observable.just(now);
        });

        Observable<LocalTime> just = Observable.just(LocalTime.now());

        defer.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독1의 구독시간: " + time));
        just.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독1의 구독시간: " + time));

        Thread.sleep(3000);

        defer.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독2의 구독시간: " + time));
        just.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독2의 구독시간: " + time));
    }
}
