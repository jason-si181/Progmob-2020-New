package ukdw.com.progmob_2020.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import ukdw.com.progmob_2020.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Menghilangkan Action Bar
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), PrefActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}