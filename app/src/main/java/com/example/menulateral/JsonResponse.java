package com.example.menulateral;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    //todo sirve para parsear el json
    //se va a traer la clave de la api results es lo que da la api pokemon
    @SerializedName("results")
    //para poder tratarla
    @Expose
    public List<PokemonList> results=null;
}
