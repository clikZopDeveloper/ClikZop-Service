package com.example.clikzop_service.Adapter

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clikzop_service.R
import com.example.clikzop_service.Model.AllExpensesBean
import com.example.clikzop_service.Utills.GeneralUtilities

import com.example.clikzop_service.Utills.RvStatusClickListner
import com.stpl.antimatter.Utils.ApiContants


class AllExpensesAdapter(var context: Activity, var list: List<AllExpensesBean.Data>, var rvClickListner: RvStatusClickListner) : RecyclerView.Adapter<AllExpensesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // infalte the item Layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_all_expenses, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)

   /*     holder.tvAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvQtyAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQtyMinus.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQty.background = RoundView(Color.TRANSPARENT, RoundView.getRadius(20f), true, R.color.orange)
        holder.tvOff.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvAdd.visibility = View.VISIBLE*/


        holder.tvName.text= list[position].title
        holder.tvMobile.text=list[position].category
        holder.tvDepartment.text=list[position].amount.toString()
        holder.tvActive.text=list[position].comments.toString()
        holder.tvDate.text= list[position].expDate.toString()

       // holder.ivImage.setImageDrawable(context.resources.getDrawable(list[position].drawableId))

      /*  if ("Retailer"=="Retailer"){
      //      holder.itemView.visibility=View.GONE
        }*/
        holder.ivView.setOnClickListener {
           // openExpesneDialog(list[position].file)
        }

        holder.ivView.setOnClickListener {
            rvClickListner.clickPos("",list[position].id)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvName: TextView = itemview.findViewById(R.id.tvName)
        val tvMobile: TextView = itemview.findViewById(R.id.tvMobile)
        val tvDepartment: TextView = itemview.findViewById(R.id.tvDepartment)
        val tvActive: TextView = itemview.findViewById(R.id.tvActive)
        val tvDate: TextView = itemview.findViewById(R.id.tvDate)
        val ivView: ImageView = itemview.findViewById(R.id.ivView)
    }

    fun openExpesneDialog(file: String) {
        val dialog: Dialog = GeneralUtilities.openBootmSheetDailog(
            R.layout.dialog_view_expense, R.style.AppBottomSheetDialogTheme,
            context
        )
        val ivClose = dialog.findViewById<ImageView>(R.id.ivClose)
        val ivExpesneImg = dialog.findViewById<ImageView>(R.id.ivExpesneImg) as ImageView

        Glide.with(context).load(ApiContants.BaseUrl+file).into(ivExpesneImg)
        ivClose.setOnClickListener { dialog.dismiss() }
    }

}