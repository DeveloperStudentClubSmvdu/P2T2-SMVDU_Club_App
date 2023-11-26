package com.rishav.smvduclubapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rishav.smvduclubapp.databinding.RvClubitemBinding
import com.rishav.smvduclubapp.models.RvModel

class RvAdapter(private var dataList:ArrayList<RvModel>, private var context: Context):RecyclerView.Adapter<RvAdapter.MyViewHolder> (){

    inner class MyViewHolder(var binding: RvClubitemBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvClubitemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.profile.setImageResource(dataList[position].profile)
        holder.binding.clubName.text = dataList[position].name

        holder.itemView.setOnClickListener{
            Toast.makeText(context, dataList[position].name, Toast.LENGTH_SHORT).show()
        }
    }


}