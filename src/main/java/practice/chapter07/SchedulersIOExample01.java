package practice.chapter07;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.io.File;

public class SchedulersIOExample01 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/practice/").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getName()))
                .filter(File::isDirectory)
                .map(File::getName)
                .subscribeOn(Schedulers.io())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);

    }
}
