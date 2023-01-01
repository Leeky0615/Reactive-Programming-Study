package practice.chapter04;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import practice.utils.DateUtil;
import practice.utils.LogType;
import practice.utils.Logger;

public class SingleCreateExample {
    public static void main(String[] args) {
        singleCreate();
        singleCreateByLambda();
        singleJust();
    }

    private static void singleCreate() {
        System.out.println("-----single create-----");
        Single<String> single = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Throwable {
                emitter.onSuccess(DateUtil.getNowDate());
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 데이터를 한 건만 처리하기 때문에 추가 요청 필요없음
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Logger.log(LogType.ON_ERROR, e);
            }
        });
    }

    private static void singleCreateByLambda() {
        System.out.println("-----single create by lambda-----");
        Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

        single.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error)
        );
    }

    private static void singleJust() {
        System.out.println("-----single just-----");
        Single.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log( LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }
}
