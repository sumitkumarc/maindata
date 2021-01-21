package ontime.app.customer.doneActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import ontime.app.R;
import ontime.app.customer.Adapter.Pager_tab;
import ontime.app.customer.Fragment.TabOrderCancelled;
import ontime.app.customer.Fragment.TabOrderFinished;
import ontime.app.customer.Fragment.TabOrderProcessing;
import ontime.app.databinding.ActivityMyordersBinding;
import ontime.app.model.usermain.ExampleUser;
import ontime.app.model.usermain.OrderCancelled;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.model.usermain.OrderProccessing;
import ontime.app.model.userorder.UserOrderList;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;

public class MyOrdersListActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner {
    ActivityMyordersBinding binding;
    private ProgressDialog dialog;
    public static List<OrderProccessing> objProcessing = new ArrayList<>();
    public static List<OrderFinished> objFinished = new ArrayList<>();
    public static List<OrderCancelled> objCancelled = new ArrayList<>();
    Pager_tab adapter;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_myorders);
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
        if (Common.MERCHANT_TYPE == 1) {
            Common.setSystemBarColor(this, R.color.colorAccent);
//            Common.setSystemBarLight(this);
            binding.ivBack.setColorFilter(getResources().getColor(R.color.colorAccent));
        } else {
            Common.setSystemBarColor(this, R.color.super_mart);
//            Common.setSystemBarLight(this);
            binding.ivBack.setColorFilter(getResources().getColor(R.color.super_mart));
        }

        GetAPICallOrderList();


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
    }

    @Override
    public void onFail(int operationCode, String response) {

    }
}