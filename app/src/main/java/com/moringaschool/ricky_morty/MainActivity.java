package com.moringaschool.ricky_morty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.moringaschool.ricky_morty.adapter.RecyclerViewAdapter;
import com.moringaschool.ricky_morty.models.Response;
import com.moringaschool.ricky_morty.network.MortyApi;
import com.moringaschool.ricky_morty.network.MortyClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
Response responses;
@BindView(R.id.run2) Button mbutton;
@BindView(R.id.recyclerview) RecyclerView mrecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mbutton.setOnClickListener(V->ApiCall());

        ApiCall();


    }



    private void ApiCall(){
        MortyApi mortyApi = MortyClient.getClient();
        Call<Response> call = mortyApi.getCharacters();
        call.enqueue(new Callback<Response>(){

            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.isSuccessful()) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mrecyclerView.setLayoutManager(linearLayoutManager);
                    responses = response.body();
                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(responses.getResults(),getApplicationContext());

                    mrecyclerView.setAdapter(recyclerViewAdapter);

                    Log.d("Api call successful", "success");
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}