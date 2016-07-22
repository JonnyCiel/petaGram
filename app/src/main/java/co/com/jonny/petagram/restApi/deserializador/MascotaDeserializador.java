package co.com.jonny.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.com.jonny.petagram.modelos.MascotaJson;
import co.com.jonny.petagram.restApi.ContactoResponse;
import co.com.jonny.petagram.restApi.JsonKeys;

/**
 * Created by Jonny on 21/07/2016.
 */
public class MascotaDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse response = gson.fromJson(json, ContactoResponse.class);
        JsonArray allData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        response.setMascotas(deserializarMascotaJson(allData));

        return response;
    }

    private ArrayList<MascotaJson> deserializarMascotaJson(JsonArray allData){
        ArrayList<MascotaJson> contactos = new ArrayList<>();
        for (int i = 0; i < allData.size() ; i++) {
            JsonObject AllObjects = allData.get(i).getAsJsonObject();
            JsonObject userJson = AllObjects.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String fullName = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson = AllObjects.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject imageResolution = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String imageURL = imageResolution.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = AllObjects.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            MascotaJson actual = new MascotaJson();
            actual.setIdInsta(id);
            actual.setNombre(fullName);
            actual.setUrlImagen(imageURL);
            actual.setRaiting(likes);
            contactos.add(actual);
        }
        return contactos;
    }
}
