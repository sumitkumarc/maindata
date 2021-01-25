package ontime.app.customer.doneActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import ontime.app.R;
import ontime.app.model.userorder.UserOrderList;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.utils.Common;

public class Dialog_Activity extends AppCompatActivity implements View.OnClickListener, APIcall.ApiCallListner {
    String str;
    private Dialog customdialog;
    FrameLayout layoutfram;
    TextView submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MyOrdersListActivity.dialogm.dismiss();
        str = getIntent().getStringExtra("YES");
        if(str.equals("yes"))
        {
            setContentView(R.layout.order_receivepopup);
//            layoutfram=(FrameLayout)findViewById(R.id.layoutfram);
        }else
        {
            setContentView(R.layout.error_msg_dialog);
        }

        if(str.equals("yes"))
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    setContentView(R.layout.rate_app);
                    openratedialog();
                }
            },2000);
        }
    }
    private void openratedialog() {
        customdialog= new Dialog(this,android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        customdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customdialog.setCancelable(false);
        customdialog.setContentView(R.layout.rate_app);
        TextView submitbtn = (TextView) customdialog.findViewById(R.id.submit);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetAPICallRateuser();
            }
        });

        customdialog.show();
    }

    private void GetAPICallRateuser() {
        Common.hideKeyboard(this);
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("rate", 5);
            jsonObject.put("review", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
            jsonObject.put("merchant_id", 3);
            jsonObject.put("rate_type", 2);
            jsonObject.put("order_id", 2);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_RATE;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_RATE_LIST, Dialog_Activity.this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStartLoading(int operationCode) {

    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        if (operationCode == APIcall.OPERATION_USER_RATE_LIST) {
//            hideDialog();
            try {
                Gson gson = new Gson();
                UserOrderList exampleUser = gson.fromJson(response, UserOrderList.class);
                if (exampleUser.getStatus() == 200) {
                    this.finish();
//                    opendismisdialog();
//                    Toast.makeText(MyOrdersListActivity.this, "yes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Dialog_Activity.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.d("SUMITPATEL", "MAINRL" + e.getMessage());
            }
        }
    }

    @Override
    public void onFail(int operationCode, String response) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
