package io.vasilenko.moviedb.ui.watchlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.vasilenko.moviedb.R
import io.vasilenko.moviedb.data.MockRepository
import kotlinx.android.synthetic.main.fragment_watchlist.*

class WatchlistFragment : Fragment(R.layout.fragment_watchlist) {

    val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        watchlistMoviesRecyclerView.layoutManager = GridLayoutManager(context, 4)
        watchlistMoviesRecyclerView.adapter = adapter.apply { addAll(listOf()) }

        val moviesList =
            MockRepository.getWatchlistMovies().map {
                MoviePreviewItem(
                    it
                ) { movie -> }
            }.toList()

        watchlistMoviesRecyclerView.adapter = adapter.apply { addAll(moviesList) }
    }

    companion object {

        @JvmStatic
        fun newInstance() = WatchlistFragment()
    }
}
