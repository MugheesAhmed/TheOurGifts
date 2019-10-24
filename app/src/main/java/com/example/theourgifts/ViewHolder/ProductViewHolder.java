package com.example.theourgifts.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theourgifts.Interface.ItemClickListener;
import com.example.theourgifts.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName, txtProductDescription,txtProductPrice;
    public ImageView imageView;
    public ItemClickListener listener;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_Image1);
        txtProductName = (TextView) itemView.findViewById(R.id.product_Name1);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_description1);
        txtProductPrice = (TextView) itemView.findViewById(R.id.product_price1);

    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        listener.onClick(v ,getAdapterPosition(), false);

    }
}
