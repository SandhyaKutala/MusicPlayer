package com.example.musicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter( private var musiclist : MutableList<Music>,private var itemClicked: itemClicked) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MusicViewHolder {

        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view =inflater.inflate(R.layout.music_items,viewGroup,shouldAttachToParentImmediately)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        val item = musiclist[position]

        holder.bindMusic(item)

    }

    override fun getItemCount(): Int {

        return  musiclist.size
    }

    inner class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private lateinit var music: Music
        private var artistName  : TextView
        private var songName: TextView

        init {
            artistName = view.findViewById(R.id.artist_view_text)
            songName = view.findViewById(R.id.song_text_view)

            view.setOnClickListener(this)
        }

        fun bindMusic(music: Music) {
            this.music = music

            artistName.text = music.artistName
            songName.text = music.songName
        }

        override fun onClick(v: View?) {

            itemClicked.itemClicked(adapterPosition)
        }

    }
}