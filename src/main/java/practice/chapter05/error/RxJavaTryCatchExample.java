package practice.chapter05.error;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class RxJavaTryCatchExample {
    public static void main(String[] args) {
        try {
            Observable.just(2)
                    .map(num -> num / 0)
                    .subscribe(System.out::println);
        } catch (Exception e) {
            Logger.log(LogType.PRINT, "# 에러 처리 필요: " + e.getCause());
        }
    }
}
