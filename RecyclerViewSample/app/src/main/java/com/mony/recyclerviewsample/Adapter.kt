package com.mony.recyclerviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mony.recyclerviewsample.models.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset : List<Affirmation>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        /* Links views from a view group to adapter. */
        val textView :TextView =
            view.findViewById(R.id.affirmationTextView)
        val imageView : ImageView =
            view.findViewById(R.id.affirmationImageView)
    }

    /* creates a view holder out of a layout and ViewGroup. */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.affirmation_card, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /* Binds data to views in view holder. */
    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = dataset[position]
        holder.textView.text =
            context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /* Returns the count of items in datasource. */
    override fun getItemCount(): Int = dataset.size
}