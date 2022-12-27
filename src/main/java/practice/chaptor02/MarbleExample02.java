package practice.chaptor02;

import io.reactivex.rxjava3.core.Observable;

public class MarbleExample02 {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(2, 25, 30, 15, 6);

        observable.subscribe(x -> System.out.println(x));
    }

}
