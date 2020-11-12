package com.example.menulateral;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //librería support design
    //<include layout="@layout/toolbar">
 final String TAG=getClass().getName();
 private List<PokemonList> mPokemonList;
    Button btnListPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllPokemon();    }

        public void getAllPokemon(){
            Retrofit retrofit =new Retrofit.Builder().baseUrl(ConstantsAndUtils.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            ApiPokemon apiPokemon=retrofit.create(ApiPokemon.class);
            //enqueue
            apiPokemon.getListPokemon().enqueue(new Callback<JsonResponse>() {
                //metodos Callback
                @Override
                public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                   if (response !=null && response.body() !=null ) {
                       mPokemonList = response.body().results;

                       for (PokemonList p : mPokemonList) {
                           Log.d(TAG,"pokemon name: "+p.getName());
                           Log.d(TAG,"URL pokemon: "+p.getUrl());


                       }

                       }
                   }


                @Override
                public void onFailure(Call<JsonResponse> call, Throwable t) {

                }
            });
        }

}