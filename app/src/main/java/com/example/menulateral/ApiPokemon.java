package com.example.menulateral;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiPokemon {
    //tipo de archivo a aceptar
    @Headers({"Accept: application/json , Content-Type: application/json"})
    //obtener recursos
    @GET(ConstantsAndUtils.POKEMON_FORM)
    //lib retrofit pokemon-form en la pokeapi hay que ver si la cabecera te pide Query o paff
    //en la Query es como se llama en la api si queremos varios parámetros @Query("name") String name,
    //@Query("url") String url, si trabajamos con Path el get es @GET("{/name}") y el @Path("name") String name)
    Call <JsonResponse> getListPokemon();
    //si queremos añadir un parametro
}
