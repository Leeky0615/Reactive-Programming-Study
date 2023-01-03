package practice.chapter05.utility;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAll;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.Arrays;

public class ObservableMaterializeExample02 {
    public static void main(String[] args) {
        Observable.concatEager(
                Observable.just(
                        getDBUser().subscribeOn(Schedulers.io()),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                .materialize()
                                .map(notification -> {
                                    if (notification.isOnError()) {
                                        Logger.log(LogType.PRINT, "# API user 에러 발생!");
                                    }
                                    return notification;
                                })
                                .filter(stringNotification -> !stringNotification.isOnError())
                                .dematerialize(notification -> notification)
                )
        ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(1000L);

    }

    private static Observable<String> getDBUser() {
        return Observable.fromIterable(Arrays.asList(
                "DB user1",
                "DB user2",
                "DB user3",
                "DB user4",
                "DB user5"
        ));
    }

    private static Observable<String> getAPIUser() {
        return Observable
                .just(
                        "API user1",
                        "API user2",
                        "Not user",
                        "API user4",
                        "API user5"
                )
                .map(user -> {
                    if (user.equals("Not user")) {
                        throw new RuntimeException();
                    }
                    return user;
                });
    }
}
