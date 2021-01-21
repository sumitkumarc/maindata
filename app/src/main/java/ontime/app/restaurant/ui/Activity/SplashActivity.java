package ontime.app.restaurant.ui.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import ontime.app.R;
import ontime.app.customer.doneActivity.UserDashboardActivity;
import ontime.app.model.usermain.Userdate;
import ontime.app.utils.SessionManager;

public class SplashActivity extends AppCompatActivity {

    ImageView img;
    Userdate userData;
    TextView txt;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sessionManager = new SessionManager(SplashActivity.this);
        userData = sessionManager.getUserDetails();
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    RiderOrderDetails
//                    Intent i = new Intent(SplashActivity.this, RiderOrderDetails.class);
//                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this);
//                    startActivity(i,transitionActivityOptions.toBundle());
//                    finish();
                    if (sessionManager.getBooleanData(SessionManager.LOGIN)){
                        if(userData.getUserType().equals("user")){
                            Intent i = new Intent(SplashActivity.this, UserDashboardActivity.class);
                            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this);
                            startActivity(i,transitionActivityOptions.toBundle());
                            finish();
                        }else {
                            Intent i = new Intent(SplashActivity.this, RiderOrderDetails.class);
                            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this);
                            startActivity(i,transitionActivityOptions.toBundle());
                            finish();
                        }
                    }else {
                        Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this);
                        startActivity(i,transitionActivityOptions.toBundle());
                        finish();
                    }

                }
                finish();
            }
        },2000);
    }
}