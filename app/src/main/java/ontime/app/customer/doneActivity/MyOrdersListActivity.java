package ontime.app.customer.doneActivity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import ontime.app.R;
import ontime.app.customer.Adapter.Pager_tab;
import ontime.app.customer.Fragment.TabOrderCancelled;
import ontime.app.customer.Fragment.TabOrderFinished;
import ontime.app.customer.Fragment.TabOrderProcessing;
import ontime.app.databinding.ActivityMyordersBinding;
import ontime.app.model.restaurantlist.RestaurantExample;
import ontime.app.model.usermain.OrderCancelled;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.model.usermain.OrderProccessing;
import ontime.app.model.usermain.Restaurant;
import ontime.app.model.userorder.UserOrderList;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.restaurant.ui.Activity.RiderOrderDetails;
import ontime.app.restaurant.ui.Activity.SplashActivity;
import ontime.app.restaurant.ui.Activity.WelcomeActivity;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import ontime.app.utils.SessionManager;

public class MyOrdersListActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner {
    ActivityMyordersBinding binding;
    private ProgressDialog dialog;
    public static ArrayList<OrderProccessing> objProcessing = new ArrayList<>();
    public static List<OrderFinished> objFinished = new ArrayList<>();
    public static List<OrderCancelled> objCancelled = new ArrayList<>();
    Pager_tab adapter;
    public static Dialog dialogm;
    boolean temp;
    int REST_ID = 0;
    int ORDER_ID = 0;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_myorders);

    }

    private void showcustomedialog(int order_id, Restaurant restaurant) {
        dialogm = new Dialog(this);
        dialogm.setCancelable(true);
        dialogm.setContentView(R.layout.orderrequest_activity);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogm.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialogm.getWindow().setAttributes(lp);
        dialogm.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogm.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView yesbtn = (TextView) dialogm.findViewById(R.id.yes);
        ImageView iv_rest_img = (ImageView) dialogm.findViewById(R.id.iv_rest_img);
        Glide.with(this).load(restaurant.getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(iv_rest_img);
        TextView nobtn = (TextView) dialogm.findViewById(R.id.no);
        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()) {
                    temp = true;
                    REST_ID = restaurant.getId();
                    ORDER_ID = order_id;
                    GetAPICallOrderrequestuser("Order received", order_id);
                }
            }
        });

        nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()) {
                    temp = false;
                    REST_ID = restaurant.getId();
                    GetAPICallOrderrequestuser("Order not received", order_id);
                }
            }
        });
        dialogm.show();
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter("ACTION_REFRESH_USER.intent.MAIN");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                GetAPICallOrderList();

            }
        };
        registerReceiver(broadcastReceiver, intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegister();
    }


    public void unRegister() {
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showDialog() {
        dialog = new ProgressDialog(MyOrdersListActivity.this);
        dialog.setMessage(getResources().getString(R.string.Please_wait));
        dialog.setCancelable(false);
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        register();
        if (Common.MERCHANT_TYPE == 1) {
            Common.setSystemBarColor(this, R.color.colorAccent);
//            Common.setSystemBarLight(this);
            binding.ivBack.setColorFilter(getResources().getColor(R.color.colorAccent));
        } else {
            Common.setSystemBarColor(this, R.color.super_mart);
//            Common.setSystemBarLight(this);
            binding.ivBack.setColorFilter(getResources().getColor(R.color.super_mart));
        }

        try {
            Bundle b = getIntent().getExtras();
            if (b != null) {
                int order_id = Integer.parseInt(b.getString("order_id"));
                int noty_type = Integer.parseInt(b.getString("noty_type"));
                if (noty_type == 5) {
                    GetAPICallOrderDetails(order_id);
                }
            }
        } catch (Exception e) {
            // cat_id = getIntent().getIntExtra("CatId", 1);
        }

        GetAPICallOrderList();


    }

    private void GetAPICallOrderDetails(int order_id) {
        Common.hideKeyboard(getActivity());
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("order_id", order_id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_ORDERDETAIL;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_ORDERDETAIL, this);
    }

    private void GetAPICallOrderList() {
        Common.hideKeyboard(getActivity());
        JSONObject jsonObject = new JSONObject();
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_ORDER_LIST;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_ORDER_LIST, this);
    }

    private void GetAPICallOrderrequestuser(String order_received, int order_id) {
        Common.hideKeyboard(getActivity());
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("message", order_received);
            jsonObject.put("order_id", order_id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_MSG;
        APIcall apIcall = new APIcall(this);
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_MSG, this);
    }

    @Override
    protected void setListener() {
        super.setListener();
        binding.back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }


    @Override
    public void onStartLoading(int operationCode) {
        if (operationCode == APIcall.OPERATION_ORDER_LIST) {
            showDialog();
        }
        if (operationCode == APIcall.OPERATION_USER_MSG) {
            showDialog();
        }
//        if (operationCode == APIcall.OPERATION_USER_ORDERDETAIL) {
//            showDialog();
//        }

    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        if (operationCode == APIcall.OPERATION_ORDER_LIST) {
            hideDialog();
            try {
                hideDialog();
                Gson gson = new Gson();
                UserOrderList exampleUser = gson.fromJson(response, UserOrderList.class);
                if (exampleUser.getStatus() == 200) {
                    objProcessing = exampleUser.getResponceData().getProccessing();
                    objCancelled = exampleUser.getResponceData().getOCancelled();
                    objFinished = exampleUser.getResponceData().getFinished();
                    adapter = new Pager_tab(getSupportFragmentManager());
                    adapter.addFrag(new TabOrderProcessing(), "Processing");
                    adapter.addFrag(new TabOrderFinished(), "Finished");
                    adapter.addFrag(new TabOrderCancelled(), "Cancelled");
                    binding.pager.setAdapter(adapter);
                    binding.tabLayout.setupWithViewPager(binding.pager);
                    binding.pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageSelected(int position) {

                        }

                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                            // Code goes here
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {
                            // Code goes here
                        }
                    });

                } else {
                    Toast.makeText(MyOrdersListActivity.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.d("SUMITPATEL", "MAINRL" + e.getMessage());
            }
        }
        if (operationCode == APIcall.OPERATION_USER_ORDERDETAIL) {
            hideDialog();
            try {
                Gson gson = new Gson();
                RestaurantExample exampleUser = gson.fromJson(response, RestaurantExample.class);
                if (exampleUser.getStatus() == 200) {
                    showcustomedialog(exampleUser.getResponceData().get(0).getRestaurant().getId(), exampleUser.getResponceData().get(0).getRestaurant());
                }
            } catch (Exception e) {

            }
        }

        if (operationCode == APIcall.OPERATION_USER_MSG) {
            hideDialog();
            try {
                Gson gson = new Gson();
                UserOrderList exampleUser = gson.fromJson(response, UserOrderList.class);
                if (exampleUser.getStatus() == 400) {

                    if (temp) {
                        Intent intent = new Intent(MyOrdersListActivity.this, Dialog_Activity.class);
                        intent.putExtra("YES", "yes");
                        intent.putExtra("REST_ID", REST_ID);
                        intent.putExtra("ORDER_ID", ORDER_ID);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MyOrdersListActivity.this, Dialog_Activity.class);
                        intent.putExtra("YES", "no");
                        startActivity(intent);
//                        dialogm.dismiss();
                    }

//                    opendismisdialog();
//                    Toast.makeText(MyOrdersListActivity.this, "yes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyOrdersListActivity.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.d("SUMITPATEL", "MAINRL" + e.getMessage());
            }
        }
    }

    @Override
    public void onFail(int operationCode, String response) {

    }
}