package com.example.locationreminder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.locationreminder.databinding.ListReminderBinding

class ReminderAdapter<T>(private val callback: ((item: T) -> Unit)? = null)
    : RecyclerView.Adapter<ReminderAdapter<T>.ReminderViewHolder<T>>(){

    private var _items: MutableList<T> = mutableListOf()
    private val items: List<T> get() = this._items

    inner class ReminderViewHolder<T>(private val binding: ListReminderBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(item: T) {

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder<T> {
        return ReminderViewHolder(
            ListReminderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ReminderViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            callback?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return _items.size
    }

    fun getItem(position: Int) = _items[position]
    fun addData(items: List<T>){
        _items.addAll(items)
        notifyDataSetChanged()
    }

    fun clear(){
        _items.clear()
        notifyDataSetChanged()
    }

//    @LayoutRes
//    fun getLayoutRes(viewType: Int): Int

    open fun getLifecycleOwner(): LifecycleOwner?{
        return null
    }
}