package com.sam.listscreenapplication.ui.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sam.listscreenapplication.repository.model.ListScreenData
import com.sam.listscreenapplication.repository.model.ListScreenItem
import com.sam.listscreenapplication.repository.model.Section
import com.sam.listscreenapplication.ui.adapter.delegate.AdapterDelegate
import com.sam.listscreenapplication.ui.adapter.delegate.CarDelegate
import com.sam.listscreenapplication.ui.adapter.delegate.CelebrityDelegate
import com.sam.listscreenapplication.ui.adapter.delegate.SectionDelegate
import javax.inject.Inject

class ListScreenAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val adapterDelegateManager: AdapterDelegateManager<AdapterDelegate<ListScreenItem, RecyclerView.ViewHolder>, ListScreenItem> = AdapterDelegateManager()
    private lateinit var items: List<ListScreenItem>

    init {
        adapterDelegateManager.addDelegate(ViewType.CELEBRITY.ordinal, CelebrityDelegate())
        adapterDelegateManager.addDelegate(ViewType.CAR.ordinal, CarDelegate())
        adapterDelegateManager.addDelegate(ViewType.SECTION.ordinal, SectionDelegate())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterDelegateManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapterDelegateManager.onBindViewHolder(items.get(position), position, holder)
    }


    override fun getItemViewType(position: Int): Int {
        return adapterDelegateManager.getItemViewType(items.get(position))
    }


    fun update(data: ListScreenData) {
        items = getItemList(data)
        notifyDataSetChanged()
    }

    private fun getItemList(data: ListScreenData): List<ListScreenItem> {
        val itemList = mutableListOf<ListScreenItem>()
        itemList.add(Section("Celebrities"))
        itemList.addAll(data.celebrities)
        itemList.add(Section("Cars"))
        itemList.addAll(data.cars)
        return itemList
    }

}