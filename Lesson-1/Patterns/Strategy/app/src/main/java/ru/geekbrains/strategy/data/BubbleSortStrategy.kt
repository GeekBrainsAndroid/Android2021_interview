package ru.geekbrains.strategy.data

class BubbleSortStrategy : SortableStrategy {
    override fun sort(list: MutableList<Int>) {
        for (i in 1 until list.size) {
            var swapped = false
            for (j in 0 until list.size - i) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1)
                    swapped = true
                }
            }
            if (!swapped){
                return
            }
        }
    }

    private fun swap(list: MutableList<Int>, i: Int, j:Int){
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }
}