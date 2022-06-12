package com.example.project.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Order> items;

    public cartAdapter(Context context, ArrayList<Order>items){
        this.context = context;
        this.items = items;
    }



    @Override
    public cartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_card_order,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Order pizza = items.get(position);
        CardView cardView = holder.cardView;

        TextView name = (TextView)cardView.findViewById(R.id.order_name);
        TextView price = (TextView)cardView.findViewById(R.id.order_price);
        TextView time = (TextView)cardView.findViewById(R.id.order_date);
        TextView description = (TextView)cardView.findViewById(R.id.order_status);
        TextView diner = (TextView)cardView.findViewById(R.id.textDescription);

        name.setText("order id: "+pizza.getDinner_id());
        price.setText("order Price: "+String.valueOf(pizza.getPrice()));
        time.setText(String.valueOf(pizza.getOrder_date()));
        description.setText("order status:"+pizza.getOrder_Status());
        diner.setText("Name:"+pizza.getDinner_name());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }


}
