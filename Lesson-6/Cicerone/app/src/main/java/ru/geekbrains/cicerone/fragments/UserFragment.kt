package ru.geekbrains.cicerone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.geekbrains.cicerone.R

private const val ARG_USER = "user"

class UserFragment : Fragment() {
    private var userParam: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userParam = it.getString(ARG_USER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        val textUser = view.findViewById<TextView>(R.id.text_user)
        textUser.text = userParam ?: "User"
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(user: String) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER, user)
                }
            }
    }
}