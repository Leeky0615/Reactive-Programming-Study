package practice.chapter03;

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
import practice.utils.TimeUtil;

public class RxJavaFlowableCreateSample {
    public static void main(String[] args) {
        // 데이터를 통지하는 부분
        Flowable<String> flowable =
                Flowable.create(new FlowableOnSubscribe<String>() {
                    /**
                     * 구독자 쪽에서 요청 받아 subscribe() 호출
                     */
                    @Override
                    public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Throwable {
                        String[] datas = {"Hello", "RxJava!"};
                        for (String data : datas) {
                            // 구독 해지시 처리 중단
                            if (emitter.isCancelled()) return;

                            // 데이터 통지
                            emitter.onNext(data);
                        }

                        // 데이터 통지 완료
                        emitter.onComplete();
                    }
                }, BackpressureStrategy.BUFFER);// (배합전략)구독자의 처리가 늦을 경우 데이터를 버퍼에 담아둠

        // 소비자 쪽에서 데이터를 구독하고 처리하는 부분
        flowable.observeOn(Schedulers.computation())
                .subscribe(
                        new Subscriber<String>() {
                            // 데이터 개수 요청 및 구독을 취소하기 위한 Subscription 객체
                            private Subscription subscription;

                            // 생산자 쪽에서 데이터를 통지할 준비가 되었음을 알리기위해 onSubscribe() 호출
                            @Override
                            public void onSubscribe(Subscription s) {
                                this.subscription = s;
                                // 생산자 쪽으로 데이터를 통지해달라고 요청
                                this.subscription.request(Long.MAX_VALUE);
                            }

                            // 데이터를 처리하는 부분
                            @Override
                            public void onNext(String s) {
                                Logger.log(LogType.ON_NEXT, s);
                            }

                            @Override
                            public void onError(Throwable t) {
                                Logger.log(LogType.ON_ERROR, t);
                            }

                            @Override
                            public void onComplete() {
                                Logger.log(LogType.ON_COMPLETE);
                            }
                        }
                );
        TimeUtil.sleep(500L);
    }


}
