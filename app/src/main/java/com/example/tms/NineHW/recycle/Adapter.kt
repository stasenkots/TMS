package com.example.tms.NineHW.recycle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.NineHW.entity.CryptoCurrency
import com.example.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_crypto_currency.view.*

private const val URL_IMAGE="https://s2.coinmarketcap.com/static/img/coins/64x64/"

class Adapter(val list:List<CryptoCurrency>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crypto_currency,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder.itemView){
            name_crypto_currency.text=list[position].name
            price_crypto_currency.text=list[position].price.toString()+"$"
            percent_change_crypto_currency.text=list[position].percentChange.toString()+"%"
            var color=getColor(context,R.color.green)
            if (list[position].percentChange<0) {
                color=getColor(context,R.color.red)
            }
            percent_change_crypto_currency.setTextColor(color)
            Picasso.get().load(URL_IMAGE+"${list[position].id}.png").into(icon_crypto_currency)
        }
    }

    override fun getItemCount()=list.size

}