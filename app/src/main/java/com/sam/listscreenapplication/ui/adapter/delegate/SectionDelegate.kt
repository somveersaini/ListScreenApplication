package com.sam.listscreenapplication.ui.adapter.delegate


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sam.listscreenapplication.R
import com.sam.listscreenapplication.databinding.SectionItemBinding
import com.sam.listscreenapplication.repository.model.Car
import com.sam.listscreenapplication.repository.model.ListScreenItem
import com.sam.listscreenapplication.repository.model.Section
import com.sam.listscreenapplication.ui.adapter.ViewType

class SectionDelegate : AdapterDelegate<ListScreenItem, RecyclerView.ViewHolder> {

    override fun isItemforViewType(data: ListScreenItem) = data is Section

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false))
    }

    override fun onBindViewHolder(data: ListScreenItem, holder: RecyclerView.ViewHolder, position: Int) {
        if (data is Section && holder is SectionViewHolder){
            holder.binding?.section = data
        }
    }

    override fun getViewType(data: ListScreenItem) = ViewType.SECTION.ordinal

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<SectionItemBinding>(itemView)
    }
}
