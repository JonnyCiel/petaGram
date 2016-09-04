package co.com.jonny.petagram.servicios;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Jonny on 01/08/2016.
 */
public class ServiceIdToken extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        Log.e(ServiceIdToken.class.getSimpleName(), FirebaseInstanceId.getInstance().getToken());
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarToken(token);
    }

    private void enviarToken(String token){

        Log.e(ServiceIdToken.class.getSimpleName(), token);
    }
}
