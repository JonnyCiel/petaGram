package co.com.jonny.petagram.restApi;

/**
 * Created by Jonny on 21/07/2016.
 */
public final class ConstantesApi {
    public final static String ROOT_URL = "https://api.instagram.com/v1/";
    public final static String ACCESSTOKEN = "3565007226.049ced8.394ac7bf8cd84af78a87a412481fd9c7";
    public final static String KEY_ACESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_USER_MEDIA = "users/self/media/recent/";
    public static final String URL_GET_RECENT_USER_MEDIA = KEY_GET_RECENT_USER_MEDIA + KEY_ACESS_TOKEN + ACCESSTOKEN;

}
