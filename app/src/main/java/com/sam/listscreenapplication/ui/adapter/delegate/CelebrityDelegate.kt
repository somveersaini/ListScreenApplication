package com.sam.listscreenapplication.ui.adapter.delegate

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sam.listscreenapplication.R
import com.sam.listscreenapplication.databinding.CelebrityItemBinding
import com.sam.listscreenapplication.repository.model.Celebrity
import com.sam.listscreenapplication.repository.model.ListScreenItem
import com.sam.listscreenapplication.ui.adapter.ViewType

class CelebrityDelegate : AdapterDelegate<ListScreenItem, RecyclerView.ViewHolder> {
    override fun isItemforViewType(data: ListScreenItem) = data is Celebrity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CelebrityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.celebrity_item, parent, false))
    }

    override fun onBindViewHolder(data: ListScreenItem, holder: RecyclerView.ViewHolder, position: Int) {
        if (data is Celebrity && holder is CelebrityViewHolder){
            Log.d("celeb", data.toString())
            holder.binding?.celeb = data
            holder.binding?.executePendingBindings()
        }
    }

    override fun getViewType(data: ListScreenItem) = ViewType.CELEBRITY.ordinal

    class CelebrityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<CelebrityItemBinding>(itemView)
    }

}
