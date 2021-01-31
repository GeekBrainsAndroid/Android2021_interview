package ru.geekbrains.aidlservice

class AidlFiboImpl() : IAidlFibo.Stub() {
    override fun calculate(param: Long): Long {
        var f1: Long = 0
        var f2: Long = 1
        var result: Long = 0
        for (i in 1..param){
            result = f1 + f2
            f1 = f2
            f2 = result
        }
        return result
    }
}