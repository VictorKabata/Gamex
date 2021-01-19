package com.vickikbt.gamex.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.FragmentHomeBinding
import com.vickikbt.gamex.ui.adapter.HomeRecyclerviewAdapter
import com.vickikbt.gamex.ui.adapter.HomeViewPagerAdapter
import com.vickikbt.gamex.ui.viewmodel.HomeViewModel
import com.vickikbt.gamex.util.StateListener
import com.vickikbt.gamex.util.log
import com.vickikbt.gamex.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        //setHasOptionsMenu(true)

        viewModel.stateListener = this


        initViewPager()
        initRecyclerview()

        return binding.root
    }

    private fun initViewPager() {
        viewModel.unreleasedPopularGames.observe(viewLifecycleOwner, { games ->
            binding.viewPagerHomeSlider.adapter = HomeViewPagerAdapter(requireActivity(), games)
            binding.dotsHomeSlider.setViewPager(binding.viewPagerHomeSlider)
        })
    }

    private fun initRecyclerview() {
        viewModel.unreleasedPopularGames.observe(viewLifecycleOwner, { games ->
            binding.recyclerviewUpcomingGames.adapter =
                HomeRecyclerviewAdapter(requireActivity(), games)
        })

        viewModel.releasedPopularGames.observe(viewLifecycleOwner, { games ->
            binding.recyclerviewNewandpopularGames.adapter =
                HomeRecyclerviewAdapter(requireActivity(), games)
        })
    }

    override fun loading() {

    }

    override fun success() {

    }

    override fun failure(message: String) {

        requireActivity().toast(message)
        requireActivity().log(message)
    }
}