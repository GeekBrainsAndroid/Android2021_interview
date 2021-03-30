package ru.geekbrains.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.geekbrains.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IViewMainActivity {

    lateinit var binding: ActivityMainBinding

    var presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.presenter = presenter
    }

    override fun renderData(){
        binding.invalidateAll()
        // Можно использовать binding таким образом:
        //binding.textResult.text = presenter.resultValue
    }
}