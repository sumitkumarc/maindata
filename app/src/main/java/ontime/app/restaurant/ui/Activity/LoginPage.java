package ontime.app.restaurant.ui.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import ontime.app.R;

public class LoginPage extends AppCompatActivity {
    AppCompatButton login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login_btn = findViewById(R.id.login_btn);
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottan_to_up);
        login_btn.startAnimation(bottomUp);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Intent i = new Intent(LoginPage.this, RiderOrderDetails.class);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginPage.this);
                    startActivity(i,transitionActivityOptions.toBundle());
                    finish();
                }
            }
        });

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


}