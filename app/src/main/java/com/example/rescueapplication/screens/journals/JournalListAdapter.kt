package com.example.rescueapplication.screens.journals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rescueapplication.databinding.ListJournalItemBinding
import com.example.rescueapplication.db.entity.JournalEntity

class JournalListAdapter(private val itemClick: (JournalEntity) -> Unit):
        ListAdapter<JournalEntity, JournalListAdapter.JournalViewHolder>(JournalDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListJournalItemBinding.inflate(layoutInflater, parent, false)
        return JournalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        val currentJournal = getItem(position)
        holder.bind(currentJournal, itemClick)
        }


    inner class JournalViewHolder(private var binding: ListJournalItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(currentJournal: JournalEntity, itemClick: (JournalEntity) -> Unit) = with(itemView) {
            binding.journalTv.text = currentJournal.title
            binding.journalDate.text = currentJournal.date
            setOnClickListener { itemClick(currentJournal) }

        }

    }


    object JournalDiffUtil : DiffUtil.ItemCallback<JournalEntity>() {
        override fun areItemsTheSame(oldItem: JournalEntity, newItem: JournalEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JournalEntity, newItem: JournalEntity): Boolean {
            return oldItem == newItem
        }
    }

}
