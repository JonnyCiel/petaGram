package co.com.jonny.petagram;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActividad extends AppCompatActivity implements View.OnClickListener{

    Session mSession = null;
    ProgressDialog mProgressDialog;
    Context mContext = null;
    EditText Nombre, Email, Mensaje;
    String NombreMail, EmailMail, MensajeMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFavoritos);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Nombre = (EditText) findViewById(R.id.editText_Nombre);
        Email = (EditText) findViewById(R.id.editText_Email);
        Mensaje = (EditText) findViewById(R.id.editText_Mensaje);
        Button boton = (Button) findViewById(R.id.Boton_Enviar);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(Nombre.getText().toString().isEmpty()){
            Nombre.setError("No dejes campos en blanco");
        }else{
            NombreMail = Nombre.getText().toString();
        }

        if (Email.getText().toString().isEmpty()){
            Email.setError("No dejes campos en blanco");
        }else {
            EmailMail = Email.getText().toString();
        }

        if (Mensaje.getText().toString().isEmpty()){
            Mensaje.setError("No dejes campos en blanco");
        }else {
            MensajeMail = Mensaje.getText().toString();
        }

        if (Nombre.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Mensaje.getText().toString().isEmpty()){

        }else {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "465");

            mSession = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("pruebacourseramail@gmail.com", "cursolocovideo123");
                }
            });

            mProgressDialog = ProgressDialog.show(ContactoActividad.this, "Estado", "Enviando mensaje...", true);

            RecibirRespuesta respuesta = new RecibirRespuesta();
            respuesta.execute();
        }


    }

    class RecibirRespuesta extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try{

                Message message = new MimeMessage(mSession);
                message.setFrom(new InternetAddress("jonny.lozano666@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EmailMail));
                message.setSubject("Mensaje de Aplicación");
                message.setContent(MensajeMail, "text/html; charset=utf-8");

                Transport.send(message);
            }catch (MessagingException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
           mProgressDialog.dismiss();
            Nombre.setText("");
            Email.setText("");
            Mensaje.setText("");
            Snackbar.make(findViewById(android.R.id.content), "Mensaje enviado", Snackbar.LENGTH_SHORT).show();

        }
    }
}


