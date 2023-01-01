package practice.chapter04;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import practice.utils.DateUtil;
import practice.utils.LogType;
import practice.utils.Logger;

public class MaybeCreateExample {
    public static void main(String[] args) {
        maybeCreate();
        maybeCreateByLambda();
        maybeJust();
        maybeFromSingle();
    }

    /**
     * onSuccess()가 onNext()의 역할을 한다.
     * onSuccess()를 통해 데이터를 한 건 전달받았다면 onComplete()는 호출되지 않는다.
     * 생산자 쪽에서 데이터 통지 없이 complete를 보내면 onComplete()가 호출됨.
     */
    private static void maybeCreate() {
        System.out.println("-----maybe create-----");

        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Throwable {
//                emitter.onSuccess(DateUtil.getNowDate());
                emitter.onComplete();
            }
        });
        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + s);
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

    }

    private static void maybeCreateByLambda() {
        System.out.println("-----maybe create by lambda-----");
        Maybe.create(emitter -> {
                    emitter.onSuccess(DateUtil.getNowDate());
//                    emitter.onComplete();
                })
                .subscribe(data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }

    private static void maybeJust() {
        System.out.println("-----maybe just-----");
        Maybe.just(DateUtil.getNowDate())
                .subscribe(data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        // 데이터를 한 건도 통지하지 않고 complete -> onComplete()만 호출됨
        Maybe.empty()
                .subscribe(data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }

    private static void maybeFromSingle() {
        System.out.println("-----maybe from single-----");
        Single<String> single = Single.just(DateUtil.getNowDate());
        Maybe.fromSingle(single)
                .subscribe(data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
