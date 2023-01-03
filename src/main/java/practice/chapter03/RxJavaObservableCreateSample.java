package practice.chapter03;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

public class RxJavaObservableCreateSample {
    public static void main(String[] args) {
        // 데이터를 통지하는 부분
        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                        String[] datas = {"Hello", "RxJava!"};
                        for (String data : datas) {
                            // 구독 해지시 처리 중단
                            if (emitter.isDisposed()) return;

                            // 데이터 통지
                            emitter.onNext(data);
                        }

                        // 데이터 통지 완료
                        emitter.onComplete();
                    }
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // 아무것도 안함
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Logger.log(LogType.ON_NEXT, s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.log(LogType.ON_ERROR, e);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });

        TimeUtil.sleep(500L);
    }
}
