package geekbrains.ru.translator.view.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import geekbrains.ru.translator.databinding.SearchDialogFragmentBinding
import geekbrains.ru.translator.utils.getEmptyString

class SearchDialogFragment : BottomSheetDialogFragment() {

    private var onSearchClickListener: OnSearchClickListener? = null
    private lateinit var binding: SearchDialogFragmentBinding

    private val textWatcher = object : TextWatcher {

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            with(binding) {
                if (searchEditText.text != null && !searchEditText.text.toString()
                        .isEmpty()
                ) {
                    searchButtonTextview.isEnabled = true
                    clearTextImageview.visibility = View.VISIBLE
                } else {
                    searchButtonTextview.isEnabled = false
                    clearTextImageview.visibility = View.GONE
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {}
    }

    private val onSearchButtonClickListener =
        View.OnClickListener {
            onSearchClickListener?.onClick(binding.searchEditText.text.toString())
            dismiss()
        }

    internal fun setOnSearchClickListener(listener: OnSearchClickListener) {
        onSearchClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchDialogFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            searchButtonTextview.setOnClickListener(onSearchButtonClickListener)
            searchEditText.addTextChangedListener(textWatcher)
        }
        addOnClearClickListener()
    }

    override fun onDestroyView() {
        onSearchClickListener = null
        super.onDestroyView()
    }

    private fun addOnClearClickListener() {
        with(binding) {
            clearTextImageview.setOnClickListener {
                searchEditText.setText(String.getEmptyString())
                searchButtonTextview.isEnabled = false
            }
        }
    }

    interface OnSearchClickListener {

        fun onClick(searchWord: String)
    }

    companion object {
        fun newInstance(): SearchDialogFragment {
            return SearchDialogFragment()
        }
    }
}
