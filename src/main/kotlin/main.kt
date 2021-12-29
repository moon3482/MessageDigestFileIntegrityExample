
fun solve(sum:Int, inputNumber:Int, cycle:Int):callAndResult{
    println("")
    println("사이클 : $cycle 회차의 영역")
    println("현재 입력 sum : $sum / n의 값 : $inputNumber")
    var cycles = cycle+1
    var result = 0
    var call = 1
    if(sum>inputNumber){
        println("sum 이 n 보다 큼")
        println("")
        return callAndResult(1,0)
    }
    if(sum == inputNumber){
        println("sum 과 n 이 같음")
        println("")
        return callAndResult(1,1)
    }

    for(i in 1..3){
        var callAndResult:callAndResult = solve(sum + i , inputNumber , cycles)
        result +=callAndResult.result
        call +=callAndResult.call
        println("함수 안 result 값: $result / i값 : $i / i+sum값 : ${sum+i}")
        println("")
        println("/////////////////////////////////////////////////////////////////////////////")
    }
    return callAndResult(call = call,result = result)
}

fun main() {
var result = solve(0,3,1)
    println("최종적 반환 result 값 : ${result.result}")
    println("함수 호출 횟수 : ${result.call}")
}
data class callAndResult(val call:Int ,val result:Int)