package com.vickikbt.gamex.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.data.util.DataFormatter.imageUrlx720
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.RecyclerviewItemGameSmallBinding
import com.vickikbt.gamex.ui.fragments.HomeFragmentDirections


class HomeRecyclerviewAdapter constructor(
    private val context: Context,
    private val games: List<Game>
) : RecyclerView.Adapter<HomeRecyclerviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: RecyclerviewItemGameSmallBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.recyclerview_item_game_small,
                parent,
                false
            )

        return HomeRecyclerviewViewHolder(binding)
    }

    override fun getItemCount() = 10 //games.size

    override fun onBindViewHolder(holder: HomeRecyclerviewViewHolder, position: Int) {
        val game = games[position]
        holder.bind(context, game)

        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.homeToGameDetail(game.id!!)
            it.findNavController().navigate(action)
        }
    }
}

class HomeRecyclerviewViewHolder(private val binding: RecyclerviewItemGameSmallBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, game: Game) {
        Glide.with(context).load(imageUrlx720(game.cover?.imageId)).into(binding.imageViewUpcoming)
        binding.textViewUpcoming.text = game.name
    }

}