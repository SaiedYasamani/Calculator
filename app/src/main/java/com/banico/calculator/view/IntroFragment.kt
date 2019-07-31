package com.banico.calculator.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.fragment.findNavController
import com.banico.calculator.R

class IntroFragment : Fragment() {

    var welcomeText: AppCompatTextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_intro, container, false)
        initView(v)
        setNavigator()
        return v
    }

    private fun initView(v: View?) {
        welcomeText = v?.findViewById(R.id.welcome_text)
    }

    private fun setNavigator() {
        Handler().postDelayed({ findNavController().navigate(R.id.calculatorFragment) }, 3000)
    }
}
