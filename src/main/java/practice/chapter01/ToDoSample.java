package practice.chapter01;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import practice.utils.TimeUtil;

/**
 * 리액티브 프로그래밍의 기본적인 규칙은
 * 데이터를 발행, 가공, 구독해서 처리한다.
 */
public class ToDoSample {
    public static void main(String[] args){
        Observable.just(100, 200, 300, 400, 500) // 데이터 발행
                // 각각의 데이터가 발행될때 doOnNext()가 실행된다
                .doOnNext(data -> System.out.println(getThreadName() + " : " + "#doOnNext() : " + data ))
                // 메인 스레드가 아닌 다른 스레드에서 실행된다. 데이터의 발행, 흐름을 정하는 스레드를 결정한다.
                .subscribeOn(Schedulers.io())
                // 발행된 데이터를 가공하고 구독해서 처리하는 스레드를 결정한다.
                .observeOn(Schedulers.computation())
                // 필터링(300 이상)
                .filter(value -> value > 300)
                // 가공된 데이터를 넘김
                .subscribe(value -> System.out.println(getThreadName() + " : result : " + value));


        TimeUtil.sleep(500);
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
