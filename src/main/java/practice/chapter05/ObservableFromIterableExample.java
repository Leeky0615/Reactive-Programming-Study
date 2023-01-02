package practice.chapter05;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("korea", "USA", "Italy", "Spain");

        Observable.fromIterable(list)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

    }
}
