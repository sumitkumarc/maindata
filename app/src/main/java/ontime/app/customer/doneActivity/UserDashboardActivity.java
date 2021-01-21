package ontime.app.customer.doneActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import ontime.app.R;
import ontime.app.databinding.ActivityHomeBinding;
import ontime.app.model.usermain.Userdate;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;
import ontime.app.utils.SessionManager;

public class UserDashboardActivity extends BaseActivity implements View.OnClickListener {
    SessionManager sessionManager;
    Userdate userData;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(UserDashboardActivity.this);
        userData = sessionManager.getUserDetails();
        setUpUI();
    }

    private void setUpUI() {
        binding.AuthorUserName.setText(Common.isStrempty(userData.getFullName()));
        Glide.with(this).load(Common.isStrempty(userData.getImage())).centerCrop().placeholder(R.drawable.ic_action_user).into(binding.AuthorAvatar);
    }

    @Override
    protected void setListener() {
        super.setListener();
        binding.tvResturant.setOnClickListener(this);
        binding.tvSupermart.setOnClickListener(this);

        binding.close.setOnClickListener(this);
        binding.menu.setOnClickListener(this);
        binding.llhome.setOnClickListener(this);
        binding.llabout.setOnClickListener(this);
        binding.llangages.setOnClickListener(this);
        binding.llcart.setOnClickListener(this);
        binding.llmyorder.setOnClickListener(this);
        binding.llpaymet.setOnClickListener(this);
        binding.llprofile.setOnClickListener(this);
        binding.llcontact.setOnClickListener(this);
        binding.llnotifi.setOnClickListener(this);
        binding.llChangePws.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
    }

    @Override
    public void onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            this.binding.drawerLayout.closeDrawers();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(UserDashboardActivity.this);
            builder.setMessage("Are you sure you want to Exit ?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int id) {
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.llhome:
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.tv_resturant:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent i2 = new Intent(UserDashboardActivity.this, RestaurantlistActivity.class);
                    i2.putExtra("CAT_TYPE", 1);
                    Common.MERCHANT_TYPE = 1;
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(UserDashboardActivity.this);
                    startActivity(i2, transitionActivityOptions.toBundle());
                    binding.drawerLayout.closeDrawers();
                }
                break;

            case R.id.tv_supermart:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent i2 = new Intent(UserDashboardActivity.this, RestaurantlistActivity.class);
                    i2.putExtra("CAT_TYPE", 2);
                    Common.MERCHANT_TYPE = 2;
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(UserDashboardActivity.this);
                    startActivity(i2, transitionActivityOptions.toBundle());
                    binding.drawerLayout.closeDrawers();
                }
                break;
            case R.id.menu:
                binding.drawerLayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.close:
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.ll_change_pws:
                startActivity(new Intent(UserDashboardActivity.this, ChangePasswordActivity.class)); //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;

            case R.id.llprofile:
                startActivity(new Intent(UserDashboardActivity.this, UserProfileActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llcart:
                startActivity(new Intent(UserDashboardActivity.this, RestCartItemActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llmyorder:
                startActivity(new Intent(UserDashboardActivity.this, MyOrdersListActivity.class)); //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llpaymet:
                startActivity(new Intent(UserDashboardActivity.this, PaymentActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llnotifi:
                startActivity(new Intent(UserDashboardActivity.this, NotificationActivity.class)); //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llcontact:
                startActivity(new Intent(UserDashboardActivity.this, ContactusActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llabout:
                startActivity(new Intent(UserDashboardActivity.this, AboutusActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            case R.id.llangages:
                startActivity(new Intent(UserDashboardActivity.this, LanguageActivity.class));  //done
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                binding.drawerLayout.closeDrawers();
                break;
            default:
                break;
        }
    }


}