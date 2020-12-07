package ru.geekbrains.strategy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.strategy.data.DigitList

class MainActivity : AppCompatActivity() {

    private lateinit var digitList: DigitList
    private lateinit var sortedList: DigitList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRandom.setOnClickListener {
            digitList = DigitList()
            digitList.initRandom()
            sourceList.adapter = ListRecyclerViewAdapter(digitList)
        }

        buttonSort.setOnClickListener {
            sortedList = digitList.sort()
            destList.adapter = ListRecyclerViewAdapter(sortedList)
        }
    }
}