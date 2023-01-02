package practice.chapter05.datatransform.exercise;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class DataTransformQuiz02 {
    public static void main(String[] args) {
        Observable.range(2, 8)
                .filter(data -> data % 2 == 0)
                .flatMap(data -> Observable
                        .range(1, 9)
                        .map(row -> data + "x" + row + "=" + (data * row)))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
