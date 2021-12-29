import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class RxSub : Subscriber<String> {
    override fun onSubscribe(s: Subscription?) {
        println("onSubscribe : ${s.toString()}")
    }

    override fun onNext(t: String?) {
        println("onNext : ${t.toString()}")
    }

    override fun onError(t: Throwable?) {
        println("onError : ${t.toString()}")

    }

    override fun onComplete() {
        println("onComplete")
    }


}