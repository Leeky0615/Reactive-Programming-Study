package practice.chapter04;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.DateUtil;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

public class CompletableCreateExample {
    public static void main(String[] args){
        completableCreate();
//        completableCreateByLambda();
//        completableJust();
    }

    private static void completableCreate(){
        System.out.println("-----completable create-----");
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Throwable {
                // 데이터를 통지하는 것이 아니라 특정 작업을 수행한 후, 완료를 통지
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                Logger.log(LogType.PRINT, "# 합계: " + sum);
                emitter.onComplete();
            }
        });
        // subscribeOn() -> 생산자 쪽에서 데이터를 통지하는 스레드를 별도로 분리 가능
        completable.subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.log(LogType.ON_ERROR, e);
                    }
                });

        TimeUtil.sleep(100L);
    }

    private static void completableCreateByLambda(){
        System.out.println("-----completable create by lambda-----");
        Completable completable = Completable.create(emitter -> {
            // 데이터를 통지하는 것이 아니라 특정 작업을 수행한 후, 완료를 통지
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            Logger.log(LogType.PRINT, "# 합계: " + sum);
            emitter.onComplete();
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(
                        () -> Logger.log(LogType.ON_COMPLETE),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(100L);
    }
}
