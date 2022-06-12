package com.example.project.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
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
import com.example.project.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recycle;
    private int loaded =0;
    private ArrayList<Dinner> items = new ArrayList<Dinner>();
    private static  final String BASE_URL = "http://192.168.1.72:8080/config.php";
    private MenuInflater inflater;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recycle = root.findViewById(R.id.pizza_recycler);
        recycle.setLayoutManager(new LinearLayoutManager(root.getContext()));

        loadItems(root);
        

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadItems(View root) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {
                            if(!items.isEmpty()){
                                items.clear();
                            }
                            JSONArray array = new JSONArray(response);
                            for(int i=0; i<array.length();i++){
                                JSONObject object = array.getJSONObject(i);
                                Dinner dinner= new Dinner(object.getString("name"),object.optDouble("price"),object.getInt("time"), object.getString("Description") , object.getInt("id"));
                                items.add(dinner);
                            }


                        }catch (Exception e){
                            Toast.makeText(root.getContext(), "Error", Toast.LENGTH_SHORT).show();

                        }

                        itemsAdapter adapter = new itemsAdapter(getContext(),items);
                        recycle.setAdapter(adapter);

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