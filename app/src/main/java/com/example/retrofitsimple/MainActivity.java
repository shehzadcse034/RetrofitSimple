package com.example.retrofitsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Hero> MovieLists;
    RecyclerViewadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById (R.id.recyclerview);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));

//        recyclerView = findViewById(R.id.recyclerview);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        listView = (ListView) findViewById(R.id.listViewHeroes);

        //calling the method to display the heroes
        gettHeroes();
    }

    private void gettHeroes() {

        Api apiService =RetrofitClient.getClient().create(Api.class);


        Call<List<Hero>> call = apiService.getHeroes();

        call.enqueue(new Callback<List<Hero>> () {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if(response.isSuccessful()){
                    MovieLists=response.body ();
                }

                adapterset();
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void adapterset(){

        adapter=new RecyclerViewadapter (this,MovieLists);
        recyclerView.setAdapter (adapter);
    }
}
