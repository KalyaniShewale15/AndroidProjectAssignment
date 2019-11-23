package com.example.androidassistant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.list_item.view.*
import com.facebook.drawee.view.SimpleDraweeView
import android.net.Uri
import com.example.androidassistant.R
import com.example.androidassistant.module.InfornationRow
import com.squareup.picasso.Picasso


class ContryAdapter(val context: Context, private val information: List<InfornationRow>) : RecyclerView.Adapter<ContryAdapter.MyViewHolder>() {

    companion object {

        val TAG: String = ContryAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return information.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val info = information[position]
        holder.setData(info, position)

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentInfo: InfornationRow? = null
        var currentPosition: Int = 0

        fun setData(currentInfo: InfornationRow?, pos: Int) {
            currentInfo?.let {

                itemView.txv_discription.text = currentInfo.cuntryDescription
                itemView.txv_title.text = currentInfo.cuntrySubTital

                if (currentInfo.cuntryDesImg == null && currentInfo.cuntryDescription == null && currentInfo.cuntrySubTital == null) {
                    itemView.card_view_row.visibility = View.GONE
                } else {
                    itemView.card_view_row.visibility = View.VISIBLE
                    if (currentInfo.cuntryDesImg == null) {
                        Picasso.get()
                            .load(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                            .into(itemView.img_info)
                    } else {
                        val imgUrl: String = currentInfo.cuntryDesImg!!

                        val output = imgUrl.replace("http", "https", ignoreCase = true)
                        val url = output.replace("httpss", "https", ignoreCase = true)
                        Picasso.get()
                            .load(url)
                            .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                            .into(itemView.img_info);
                    }
                }
                this.currentInfo = currentInfo
                this.currentPosition = pos
            }
        }
    }
}