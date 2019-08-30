package com.anil.telstraassignment.ui.aboutcanada

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anil.telstraassignment.R
import com.anil.telstraassignment.data.ItemListAboutCanada
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlist_aboutcanada.view.*

class AboutCanadaAdapter(private val context: Context) : RecyclerView.Adapter<AboutCanadaAdapter.ViewHolder>() {

    private var aboutCanadaList: MutableList<ItemListAboutCanada> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist_aboutcanada, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = aboutCanadaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var row = aboutCanadaList[holder.adapterPosition]

        holder.title.text = row.title
        holder.description.text = row.description
        Picasso.get().load(row.imageHref).fit().tag(context).placeholder(R.drawable.placeholder_image).error(R.drawable.placeholder_image).into(holder.imageHref)
    }

    fun setData(itemListAboutCanada: ArrayList<ItemListAboutCanada>){

        aboutCanadaList.clear()
        aboutCanadaList.addAll(itemListAboutCanada)
        notifyDataSetChanged()

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.tv_title
        var description = view.tv_description
        var imageHref = view.iv_href
    }
}