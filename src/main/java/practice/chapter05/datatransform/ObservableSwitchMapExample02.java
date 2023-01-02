package practice.chapter05.datatransform;

import io.reactivex.rxjava3.core.Observable;
import practice.utils.LogType;
import practice.utils.Logger;
import practice.utils.TimeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample02 {
    public static void main(String[] args) throws InterruptedException {
        TimeUtil.start();
        Searcher searcher = new Searcher();
        // 사용자가 입력하는 단어라고 가정
        final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .concatMap(data -> { // concatMap을 사용해서 매번 모든 키워드 검색 결과를 다 가져온다.
                            String keyword = keywords.get(data.intValue());
                            return Observable.just(searcher.search(keyword))
                                    .doOnNext(notUse -> System.out.println("==================="))
                                    .delay(1000L, TimeUnit.MILLISECONDS);
                        }
                )
                .flatMap(Observable::fromIterable)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {
                        },
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        }
                );
        Thread.sleep(6000L);
    }
}
