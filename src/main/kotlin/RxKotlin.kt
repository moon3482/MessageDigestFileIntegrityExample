import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.rxkotlin.subscribeBy
import java.util.function.Consumer

fun main() {
    Single.create(SingleOnSubscribe<String> {
//        it.onError(Throwable("에러"))
        it.onSuccess("데이터 발행!")
    }).subscribeBy(onSuccess = { println(it) }, onError = { println(it) })

    val observer = object :MaybeObserver<String>{
        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {
           println(e)
        }

        override fun onComplete() {
            println("Complete!!!")
        }

        override fun onSuccess(t: String) {
            println(t)
        }
    }

    Maybe.create(MaybeOnSubscribe<String> {
//        it.onSuccess("데이터 발행!")
//        it.onSuccess("데이터 발행2")
//        it.onError(Throwable("에러 발생!"))
        it.onComplete()
    }).subscribe(observer)

    Completable.create(CompletableOnSubscribe {
//        it.onError(Throwable("에러 발생!"))
        it.onComplete()
    }).subscribe(Action { println("Complete!!!") })


}