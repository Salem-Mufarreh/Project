package com.example.project.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project.R;
import com.example.project.databinding.FragmentGalleryBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private RecyclerView recycle;
    private ArrayList<Order> items = new ArrayList<Order>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recycle = root.findViewById(R.id.order_recycler);
        recycle.setLayoutManager(new LinearLayoutManager(root.getContext()));
        loadItems(binding.getRoot());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void loadItems(View root) {
        String BASE_URL = "http://192.168.1.72:8080/get_Cart.php?user=1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {
                            if(!items.isEmpty()){
                                items.clear();
                            }
                            JSONArray array = new JSONArray(response);
                            for(int i =0;i<array.length();i++){
                                JSONObject object = array.getJSONObject(i);
                                items.add(new Order(object.getString("order_id"),
                                        object.getString("dinnerID"),
                                        object.getString("order_status"),
                                        object.getString("customer_id"),
                                        object.getString("order_date"),
                                        object.getString("price"),
                                        object.getString("Dinner_name")));
                            }


                        }catch (Exception e){
                            Toast.makeText(root.getContext(), "Error", Toast.LENGTH_SHORT).show();

                        }

                        cartAdapter cartAdapter = new cartAdapter(root.getContext(), items);
                        recycle.setAdapter(cartAdapter);

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