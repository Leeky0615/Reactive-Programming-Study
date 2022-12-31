package practice.chatpor03;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import practice.utils.LogType;
import practice.utils.Logger;

public class RxJavaFlowableCreateLambdaSample {
    public static void main(String[] args) throws InterruptedException {
        // 데이터를 통지하는 부분
        Flowable<String> flowable =
                Flowable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava!"};
                    for (String data : datas) {
                        // 구독 해지시 처리 중단
                        if (emitter.isCancelled()) return;

                        // 데이터 통지
                        emitter.onNext(data);
                    }

                    // 데이터 통지 완료
                    emitter.onComplete();
                }, BackpressureStrategy.BUFFER);// (배합전략)구독자의 처리가 늦을 경우 데이터를 버퍼에 담아둠

        // 소비자 쪽에서 데이터를 구독하고 처리하는 부분
        flowable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
        Thread.sleep(500L);
    }


}
