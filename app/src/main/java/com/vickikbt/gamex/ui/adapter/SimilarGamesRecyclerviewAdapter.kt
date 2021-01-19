package com.vickikbt.gamex.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.data.util.DataFormatter.imageUrlx720
import com.vickikbt.domain.models.SimilarGame
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.RecyclerviewItemGameSmallBinding
import com.vickikbt.gamex.util.toast


class SimilarGamesRecyclerviewAdapter constructor(
    private val context: Context,
    private val games: List<SimilarGame>
) : RecyclerView.Adapter<SimilarGamesRecyclerviewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimilarGamesRecyclerviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: RecyclerviewItemGameSmallBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.recyclerview_item_game_small,
                parent,
                false
            )

        return SimilarGamesRecyclerviewViewHolder(binding)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: SimilarGamesRecyclerviewViewHolder, position: Int) {
        val game = games[position]
        holder.bind(context, game)

        holder.itemView.setOnClickListener {
            context.toast("Clicked: ${game.name}")
            //val action = HomeFragmentDirections.homeToGameDetail(game.id!!)
            //it.findNavController().navigate(action)
        }
    }
}

class SimilarGamesRecyclerviewViewHolder(private val binding: RecyclerviewItemGameSmallBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, game: SimilarGame) {
        Glide.with(context).load(imageUrlx720(game.cover?.imageId)).into(binding.imageViewUpcoming)
        binding.textViewUpcoming.text = game.name
    }

}