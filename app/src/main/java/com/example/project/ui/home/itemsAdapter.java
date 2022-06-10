package com.example.project.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Dinner> items;
    private static  final String BASE_URL = "http://192.168.1.72:8080/add_Cart.php";

    public itemsAdapter(Context context, ArrayList<Dinner> list) {
        this.context = context;
        this.items = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_card,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Dinner pizza = items.get(position);
        CardView cardView = holder.cardView;

        TextView name = (TextView)cardView.findViewById(R.id.txtName);
        TextView price = (TextView)cardView.findViewById(R.id.price);
        TextView time = (TextView)cardView.findViewById(R.id.time);
        TextView description = (TextView)cardView.findViewById(R.id.textDescription);
        Button add = cardView.findViewById(R.id.AddToCart);
        TextView id = (TextView)cardView.findViewById(R.id.textid);

        name.setText(pizza.getName());
        price.setText(String.valueOf(pizza.getPrice()));
        time.setText(String.valueOf(pizza.getTime()));
        description.setText(pizza.getDescription());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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



    private void loadItems(View root) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {
                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();


                        }catch (Exception e){
                            Toast.makeText(root.getContext(), "Error", Toast.LENGTH_SHORT).show();

                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(root.getContext(), error.toString() +"ERRor",Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(root.getContext()).add(stringRequest);

    }


}
