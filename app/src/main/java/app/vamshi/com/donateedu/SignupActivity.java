package app.vamshi.com.donateedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {


     String email,password;
    EditText email1,password1;
    Button submit;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email1=findViewById(R.id.email1);
        password1=findViewById(R.id.password1);
        submit=findViewById(R.id.button);

         url="http://192.168.43.181/push.php";
        Log.d("url",url);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=email1.getText().toString().trim();

                password=password1.getText().toString();
                registeruser(email,password,url);

            }
        });



    }

    private void registeruser(final String email, final String password,String url) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                   Log.d("response",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","occured");

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<>();
                map.put("email",email);
                map.put("password",password);
                return map;

            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
