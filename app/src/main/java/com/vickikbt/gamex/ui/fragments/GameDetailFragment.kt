package com.vickikbt.gamex.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.vickikbt.data.util.DataFormatter.imageUrlx720
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.FragmentGameDetailBinding
import com.vickikbt.gamex.ui.adapter.ScreenshotsRecyclerviewAdapter
import com.vickikbt.gamex.ui.adapter.SimilarGamesRecyclerviewAdapter
import com.vickikbt.gamex.ui.viewmodel.GameDetailViewModel
import com.vickikbt.gamex.util.RatingCalculator.ratingCalc
import com.vickikbt.gamex.util.log
import com.vickikbt.gamex.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailFragment : Fragment() {

    private lateinit var binding: FragmentGameDetailBinding
    private val viewModel: GameDetailViewModel by activityViewModels()
    private val args: GameDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_detail, container, false)

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }

        initUI()

        return binding.root
    }

    private fun initUI() {
        val gameId = args.GameId

        viewModel.fetchGameDetails(gameId).observe(viewLifecycleOwner, { games ->
            val game = games[0]

            Glide.with(requireActivity()).load(imageUrlx720(game.cover?.imageId))
                .into(binding.imageViewGameCover)
            binding.textViewGameName.text = game.name
            binding.textViewCompanyName.text = game.companies?.get(0)?.company?.name
            binding.textViewSummary.text = game.summary
            //binding.textViewSummary.text = game.storyLine

            if (game.totalRating != null) {
                binding.ratingBarGameRating.rating = ratingCalc(game.totalRating!!.toFloat())
                requireActivity().log("${ratingCalc(game.totalRating!!.toFloat())}")
            } else binding.ratingBarGameRating.visibility = View.GONE

            binding.recyclerviewScreenshots.adapter =
                ScreenshotsRecyclerviewAdapter(requireActivity(), game.screenShots!!)

            binding.recyclerviewSimilarGames.adapter = SimilarGamesRecyclerviewAdapter(
                requireActivity(),
                game.similarGames!!
            )
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                requireActivity().toast("To be added to favorites")
            }
        }
        return false
    }


}