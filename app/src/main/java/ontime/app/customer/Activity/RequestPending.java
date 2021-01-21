package ontime.app.customer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import ontime.app.R;
import ontime.app.customer.doneActivity.AboutusActivity;
import ontime.app.customer.doneActivity.ContactusActivity;
import ontime.app.customer.doneActivity.LanguageActivity;
import ontime.app.customer.doneActivity.MyOrdersListActivity;
import ontime.app.customer.doneActivity.NotificationActivity;
import ontime.app.customer.doneActivity.PaymentActivity;
import ontime.app.customer.doneActivity.RestCartItemActivity;
import ontime.app.customer.doneActivity.UserProfileActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class RequestPending extends AppCompatActivity {
    DrawerLayout mDrawer;
    NavigationView navigationView;
    Animation bottomUp;
    long mStartTimeInMillis;
    public static CountDownTimer mCountDownTimer;
    long mTimeLeftInMillis;
    long mEndTime;
    boolean mTimerRunning;
    public static String timeLeftFormatted;

    TextView txt_hfirst;
    TextView txt_hfsecond;
    TextView txt_mfirst;
    TextView txt_mSecond;
    TextView txt_sFirst;
    TextView txt_sSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestpending);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RequestPending.this, RestCartItemActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
         txt_hfirst = findViewById(R.id.txt_hfirst);
         txt_hfsecond= findViewById(R.id.txt_hfsecond);
         txt_mfirst= findViewById(R.id.txt_mfirst);
         txt_mSecond= findViewById(R.id.txt_mSecond);
         txt_sFirst= findViewById(R.id.txt_sFirst);
         txt_sSecond= findViewById(R.id.txt_sSecond);

        mTimeLeftInMillis = 0;
        mTimeLeftInMillis = Long.parseLong("3660000");
        startTimer();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.nav_view);
        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openDrawer(Gravity.RIGHT);
            }
        });
        navigationView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.closeDrawers();
            }
        });

        navigationView.findViewById(R.id.llprofile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, UserProfileActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llcart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, RestCartItemActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llmyorder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, MyOrdersListActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llpaymet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, PaymentActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llnotifi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, NotificationActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llcontact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, ContactusActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llabout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, AboutusActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        navigationView.findViewById(R.id.llangages).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestPending.this, LanguageActivity.class));
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
    }
    private void startTimer() {
        bottomUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;

            }
        }.start();
        mTimerRunning = true;
    }
    private void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);

        char ch1 = timeLeftFormatted.charAt(0);
        char ch2 = timeLeftFormatted.charAt(1);

        char ch3 = timeLeftFormatted.charAt(3);
        char ch4 = timeLeftFormatted.charAt(4);

        char ch5 = timeLeftFormatted.charAt(6);
        char ch6 = timeLeftFormatted.charAt(7);

        if (txt_hfirst.getText().hashCode() != ch1) {
            txt_hfirst.setText(Character.toString(ch1));
            txt_hfirst.startAnimation(bottomUp);
        }
        if (txt_hfsecond.getText().hashCode() != ch2) {
            txt_hfsecond.setText(Character.toString(ch2));
            txt_hfsecond.startAnimation(bottomUp);
        }
        if (txt_mfirst.getText().hashCode() != ch3) {
            txt_mfirst.setText(Character.toString(ch3));
            txt_mfirst.startAnimation(bottomUp);
        }
        if (txt_mSecond.getText().hashCode() != ch4) {
            txt_mSecond.setText(Character.toString(ch4));
            txt_mSecond.startAnimation(bottomUp);
        }
        if (txt_sFirst.getText().hashCode() != ch5) {
            txt_sFirst.setText(Character.toString(ch5));
            txt_sFirst.startAnimation(bottomUp);
        }
        if (txt_sSecond.getText().hashCode() != ch6) {
            txt_sSecond.setText(Character.toString(ch6));
            txt_sSecond.startAnimation(bottomUp);
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            timeLeftFormatted = "";
            txt_hfsecond.setText("");
            txt_hfirst.setText("");
            txt_mfirst.setText("");
            txt_mSecond.setText("");
            txt_sFirst.setText("");
            txt_sSecond.setText("");
        }
    }

}