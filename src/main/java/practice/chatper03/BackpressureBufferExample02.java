package practice.chatper03;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

import static practice.utils.LogType.ON_ERROR;

/**
 * 생산자 쪽인 interval()에서는 0.3초에 한 번 데이터 통지
 * 소비자 쪽에서는 지연시간을 1초를 주어 처리속도가 더 느리게 설정
 * onBackpressureBuffer()를 사용해 Drop_LATEST 전략 설정 -> capacity(버퍼 안에 데이터가 들어올 수 있는 개수)
 * observeOn()에서 소비자쪽에서 데이터를 처리하는 쓰레드를 별도로 설정 -> bufferSize(소비자 쪽에서 요청하는 데이터의 개수)
 */
public class BackpressureBufferExample02 {
    public static void main(String[] args) {
        System.out.println("# 시작 : " + TimeUtil.getCurrentTimeFormatted());
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log("# interval doOnNext()", data))
                .onBackpressureBuffer(
                        2,
                        () -> Logger.log("overflow!!"),
                        BackpressureOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> Logger.log("# onBackpressureBuffer doOnNext()", data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(ON_ERROR, error)
                );

        TimeUtil.sleep(2800L);
    }
}
