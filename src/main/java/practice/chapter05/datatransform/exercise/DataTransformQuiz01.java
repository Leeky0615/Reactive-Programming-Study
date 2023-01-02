package practice.chapter05.datatransform.exercise;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;

public class DataTransformQuiz01 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .filter(data -> data % 2 == 0)
                .map(data -> data + "의 제곱: " + (data * data))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
