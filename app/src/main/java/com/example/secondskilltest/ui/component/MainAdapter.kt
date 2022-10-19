package com.example.secondskilltest.ui.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.secondskilltest.data.model.ReportItem
import com.example.secondskilltest.databinding.ItemMainBinding
import com.example.secondskilltest.util.GenericDiffUtil

class MainAdapter(
) :
    ListAdapter<ReportItem, RecyclerView.ViewHolder>(GenericDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReportItem) {
            binding.title = item.title
            binding.body = item.body.toString()
        }
    }
}