import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


data class Test2(val string: String, val string2: String)

fun main() {

//    val ob = Observable.just(Test2("Hello!!", "RxJava!!"))
//
//    ob.subscribe { println(it) }

    val list = mutableListOf<String>("S", "o", "S", "C", "A", "B", "C")

//    Observable.fromArray(list)
//        .subscribe { it.map { s -> println(s) } }

    val ob = Observable.just(list)
        .doOnNext { println(it) }
//        .subscribeOn(Schedulers.io())
//        .observeOn(Schedulers.computation())
        .map { it.map { it + "무" } }

    ob.subscribe { println(it) }

    println(list)
//    Thread.sleep(1000L)
    list.add("D")
    list.add("H")
    list.add("K")

    ob.subscribe { println(it) }

    val ob2 = Observable.create(ObservableOnSubscribe<String> { TODO("Not yet implemented") })

    val sub = object : Subscriber<String> {

        override fun onNext(t: String?) {
            println(t)
        }

        override fun onError(t: Throwable?) {

        }

        override fun onComplete() {

        }

        override fun onSubscribe(s: Subscription?) {

        }
    }


}