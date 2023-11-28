package com.example.androidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapp.classes.CrCur
import com.example.androidapp.databinding.ItemAnimalBinding

class Crypto(
    val onClick:(country: CrCur, position: Int) -> Unit
) : RecyclerView.Adapter<Crypto.CryptoN>() {

    private val list = ArrayList<CrCur>()

    fun setList(newList: List<CrCur>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    inner class CryptoN(val binding: Crypto) : RecyclerView.ViewHolder(binding.root){
        fun bind(element:CrCur, position: Int){
            binding.Name.text = element.name
            binding.Description.text = element.currency
            binding.btn.setOnClickListener{
                onClick(element, position)
            }

            Glide.with(binding.iv1.context)
                .load(element.image)
                .into(binding.iv1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoN {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoN(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CryptoN, position: Int) {
        val element = list[position]
        holder.bind(element, position)

    }

}