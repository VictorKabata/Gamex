package com.vickikbt.gamex.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vickikbt.gamex.R
import com.vickikbt.gamex.ui.viewmodel.AuthViewModel
import com.vickikbt.gamex.util.StateListener
import com.vickikbt.gamex.util.log
import com.vickikbt.gamex.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(), StateListener {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_splash, container, false)
        viewModel.stateListener = this

        //viewModel.fetchAccessToken()

        viewModel.getAccessToken.observe(viewLifecycleOwner, { auth ->
            if (auth == null) viewModel.fetchAccessToken()
            else findNavController().navigate(R.id.splash_to_home)
        })

        return root
    }

    override fun loading() {}

    override fun success() {
        findNavController().navigate(R.id.splash_to_home)
    }

    override fun failure(message: String) {
        requireActivity().toast(message)
        requireActivity().log(message)
    }
}