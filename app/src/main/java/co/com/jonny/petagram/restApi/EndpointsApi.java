package co.com.jonny.petagram.restApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jonny on 21/07/2016.
 */
public interface EndpointsApi {

    @GET(ConstantesApi.URL_GET_RECENT_USER_MEDIA)
    Call<ContactoResponse> getRecentMedia();
}
