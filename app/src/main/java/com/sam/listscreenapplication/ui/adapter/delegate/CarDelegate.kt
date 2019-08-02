package com.sam.listscreenapplication.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sam.listscreenapplication.R
import com.sam.listscreenapplication.databinding.CarItemBinding
import com.sam.listscreenapplication.repository.model.Car
import com.sam.listscreenapplication.repository.model.ListScreenItem
import com.sam.listscreenapplication.ui.adapter.ViewType

class CarDelegate : AdapterDelegate<ListScreenItem, RecyclerView.ViewHolder> {

    override fun isItemforViewType(data: ListScreenItem) = data is Car

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false))
    }

    override fun onBindViewHolder(data: ListScreenItem, holder: RecyclerView.ViewHolder, position: Int) {
        if (data is Car && holder is CarViewHolder){
            holder.binding?.car = data
        }
    }

    override fun getViewType(data: ListScreenItem) = ViewType.CAR.ordinal

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<CarItemBinding>(itemView)
    }
}
