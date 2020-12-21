package ru.geekbrains.strategy.data

class InsertionSortStrategy : SortableStrategy {
    override fun sort(list: MutableList<Int>)
    {
        for (i in 1 until list.size){
            val temp = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > temp){
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = temp
        }
    }
}