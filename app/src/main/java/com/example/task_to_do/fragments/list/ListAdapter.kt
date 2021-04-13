package com.example.task_to_do.fragments.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.task_to_do.R
import com.example.task_to_do.model.User
import kotlinx.android.synthetic.main.custom_grid.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>()  {

    private var userList = emptyList<User>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_grid,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.name_txt.text = currentItem.firstName.toString()
        holder.itemView.last_txt.text = currentItem.lastName.toString()
        holder.itemView.age.text = currentItem.age.toString()

        holder.itemView.gridLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
      return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()

    }


}