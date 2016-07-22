package co.com.jonny.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.jonny.petagram.restApi.ConstantesApi;
import co.com.jonny.petagram.restApi.ContactoResponse;
import co.com.jonny.petagram.restApi.EndpointsApi;
import co.com.jonny.petagram.restApi.deserializador.MascotaDeserializador;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jonny on 21/07/2016.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construirGsonMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }
}
