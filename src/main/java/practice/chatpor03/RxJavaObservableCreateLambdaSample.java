package practice.chatpor03;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;

public class RxJavaObservableCreateLambdaSample {
    public static void main(String[] args) throws InterruptedException {
        // 데이터를 통지하는 부분
        Observable<String> observable =
                Observable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for (String data : datas) {
                        // 구독 해지시 처리 중단
                        if (emitter.isDisposed()) return;

                        // 데이터 통지
                        emitter.onNext(data);
                    }

                    // 데이터 통지 완료
                    emitter.onComplete();
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE));

        Thread.sleep(500L);
    }
}
