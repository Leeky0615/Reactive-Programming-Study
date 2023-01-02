package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class ObservableMapExample02 {
    public static void main(String[] args) {
        Observable.just("korea", "japan", "paris", "spain", "america ")
                .filter(data -> data.length() == 5)
                .map(data -> data.toUpperCase().charAt(0) + data.substring(1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
