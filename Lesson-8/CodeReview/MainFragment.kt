package ru.geekbrains.codereview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import ru.geekbrains.codereview.R
import ru.geekbrains.codereview.databinding.MainFragmentBinding

class MainFragment() : Fragment() {

    constructor(text: String) : this() {
        textEdit!!.setText(text)
    }

    lateinit var b: MainFragmentBinding
    private lateinit var view: MainViewModel
    private var textEdit: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = MainFragmentBinding.inflate(inflater, container, false)
        view = MainViewModel(this, context, RepositoryImpl())
        var root = b.root
        var button : Button = root.findViewById(R.id.button)
        button?.let{
            it.textSize = 20 as Float
            it.setOnClickListener {
                var text: EditText = root.findViewById(R.id.editText)
                view.Do(text)
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textEdit = view.findViewById(R.id.editText)
        val p = arguments!!.getString("text")!!
        textEdit!!.setText(p)
    }

    fun showResult(text: String){
        textEdit!!.setText(text)
    }
}