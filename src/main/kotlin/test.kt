import java.lang.StringBuilder
import java.security.MessageDigest
import kotlin.experimental.and

class SingletonSample private constructor() {


}

fun main() {
    val str = "hello"
    val sb = StringBuilder()
    val digest = MessageDigest.getInstance("SHA-256")
    val bytes = digest.digest(str.toByteArray())

    for (data in bytes){
        sb.append(((data and 0xff.toByte()) + 0x100).toString(16)).substring(1)
    }

    println("해싱된 문자열 : $sb")
}