package com.moringaschool.ricky_morty.network;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MortyClient {
    private static Retrofit retrofit = null;
    public static MortyApi getClient(){
        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(MortyApi.class);
    }

}
