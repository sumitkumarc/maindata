package ontime.app.customer.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ontime.app.R;
import ontime.app.customer.doneActivity.UserDashboardActivity;
import ontime.app.restaurant.ui.Activity.WelcomeActivity;

public class SentRequestSuper extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentrequest2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(SentRequestSuper.this, UserDashboardActivity.class);
                startActivity(i2);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_left );
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Intent i2 = new Intent(SentRequestSuper.this, WelcomeActivity.class);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SentRequestSuper.this);
                    startActivity(i2, transitionActivityOptions.toBundle());
                }
            }
        });


        // rest_btn = findViewById(R.id.rest_btn);
        //showDialog();
    }

}