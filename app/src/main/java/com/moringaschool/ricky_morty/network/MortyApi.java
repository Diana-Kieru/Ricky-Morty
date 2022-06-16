package com.moringaschool.ricky_morty.network;

import com.moringaschool.ricky_morty.models.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MortyApi {
@GET ("character")
    Call<Response> getCharacters();

}
