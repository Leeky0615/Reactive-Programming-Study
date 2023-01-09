package practice.chapter07;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.io.File;

public class SchedulersIOExample03 {
    public static void main(String[] args) {
        File[] files = new File("src/main/java/practice/").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# 데이터 통지"))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(File::isDirectory)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# filter() 거침"))
                .observeOn(Schedulers.computation())
                .map(File::getName)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# map() 거침"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);

    }
}
