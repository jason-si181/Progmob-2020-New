package ukdw.com.progmob_2020.Pertemuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.Network.UtilsApi;
import ukdw.com.progmob_2020.R;

public class PrefActivity extends AppCompatActivity {
    String isLogin="";
    EditText nimnik;
    EditText password;
    Button login;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        nimnik = (EditText)findViewById(R.id.edNim);
        password = (EditText)findViewById(R.id.edPass);
        login = (Button)findViewById(R.id.btnPref3);
        SharedPreferences pref = PrefActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myNim = nimnik.getText().toString();
                String myPassword = password.getText().toString();
//                try {
                if (myNim.isEmpty()) {
                    nimnik.setError("Email Empty");
                    return;
                }
                if (myPassword.isEmpty()) {
                    password.setError("Password Empty");
                    return;
                }
                doLogin(nimnik, password);
            }
        });

        isLogin = pref.getString("isLogin", "0");
        if (isLogin.equals("0")) {
            editor.putString("isLogin", "1");
            Intent intent = new Intent(PrefActivity.this, MainPageActivity.class);
            startActivity(intent);
            finish();
        } else {
            editor.putString("isLogin", "0");
        }
        editor.commit();
    }

    private void doLogin(final EditText myNimnik, EditText myPassword) {
        login.setEnabled(false);
        String authorization = "Basic " + UtilsApi.base64Encode(nimnik, password);
        RetrofitClientInstance.ServiceClient
                .buildServiceClient()
                .login(authorization)
                .enqueue(new Callback<AuthorizationResponse>() {
                    @Override
                    public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {
                        if (response.isSuccessful()) {
                            AuthorizationResponse auth = response.body();
                            UserPreferences.setUserId(PrefActivity.this, auth.getLoggedInUser().getId());
                            UserPreferences.hasLogin(PrefActivity.this);
                            startActivity(new Intent(PrefActivity.this, MainPageActivity.class));
                            finish();

                        } else {
                            Toast.makeText(PrefActivity.this, "Password Salah " + nimnik, Toast.LENGTH_SHORT).show();
                            Log.d("onResponse", "onResponse: " + response.message());
                            login.setEnabled(true);
                        }
                    }
                    @Override
                    public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                        Toast.makeText(PrefActivity.this, "Something Wrong!", Toast.LENGTH_SHORT).show();
                        Log.d("onFailure", "onFailure: " + t.getMessage());
                        login.setEnabled(true);
                    }
                });
    }
}