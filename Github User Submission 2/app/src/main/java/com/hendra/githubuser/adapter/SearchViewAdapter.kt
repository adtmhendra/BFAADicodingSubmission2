package com.hendra.githubuser.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendra.githubuser.R
import com.hendra.githubuser.model.ItemsItem
import com.hendra.githubuser.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.users_row.view.*

class SearchViewAdapter(private val listItem: ArrayList<ItemsItem>) : RecyclerView.Adapter<SearchViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = SearchViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.users_row, viewGroup, false))

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val items = listItem[position]

        holder.bindItem(items)
        holder.itemView.setOnClickListener{
            Toast.makeText(it.context, "${R.string.you_choose}" + items.login, Toast.LENGTH_SHORT).show()

            val intentObject = Intent(it.context, DetailActivity::class.java)
            intentObject.putExtra(DetailActivity.EXTRA_DATA, items)
            it.context.startActivity(intentObject)
        }
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: ItemsItem) {
            with(itemView) {
                Glide.with(itemView).load(item.avatarUrl).into(imgProfile)
                tvName.text = item.login
                tvGithubLink.text = item.url
            }
        }
    }
}