package ontime.app.customer.doneActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
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
    private ProgressDialog dialog;
    int REST_ID = 0;
    int ORDER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MyOrdersListActivity.dialogm.dismiss();
        str = getIntent().getStringExtra("YES");

        if (str.equals("yes")) {

            setContentView(R.layout.order_receivepopup);
            REST_ID =getIntent().getIntExtra("REST_ID",0);
            ORDER_ID =getIntent().getIntExtra("ORDER_ID",0);
        } else {
            setContentView(R.layout.error_msg_dialog);
        }

        if (str.equals("yes")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    openratedialog();
                }
            }, 2000);
        }
    }

    private void openratedialog() {
        customdialog = new Dialog(this);
        customdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customdialog.setCancelable(false);
        customdialog.setContentView(R.layout.rate_app);
        TextView txt_submit = (TextView) customdialog.findViewById(R.id.txt_submit);
        RatingBar rb_rate_review = (RatingBar) customdialog.findViewById(R.id.rb_rate_review);
        RatingBar rb_rate_review1 = (RatingBar) customdialog.findViewById(R.id.rb_rate_review_1);
        EditText ed_review_msg = (EditText) customdialog.findViewById(R.id.ed_review_msg);
        txt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StrRateReview = String.valueOf(rb_rate_review.getRating());
                String StrRateReview1 = String.valueOf(rb_rate_review1.getRating());
                GetAPICallRateuser(StrRateReview,StrRateReview1,ed_review_msg.getText().toString());
            }
        });
        WindowManager.LayoutParams layoutParams = customdialog.getWindow().getAttributes();
        customdialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        customdialog.getWindow().setAttributes(layoutParams);
        customdialog.show();
    }

    private void GetAPICallRateuser(String strRateReview, String strRateReview1, String msg) {
        Common.hideKeyboard(this);
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("rate", strRateReview);
            jsonObject.put("review", msg);
            jsonObject.put("merchant_id", Common.MERCHANT_TYPE);
            jsonObject.put("rate_type", REST_ID);
            jsonObject.put("order_id", ORDER_ID);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_RATE;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_RATE_US, Dialog_Activity.this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onClick(View v) {

    }

    private void showDialog() {
        dialog = new ProgressDialog(Dialog_Activity.this);
        dialog.setMessage(getResources().getString(R.string.Please_wait));
        dialog.setCancelable(false);
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }


    @Override
    public void onStartLoading(int operationCode) {
        if (operationCode == APIcall.OPERATION_USER_RATE_US) {
            showDialog();
        }
    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        if (operationCode == APIcall.OPERATION_USER_RATE_US) {
            hideDialog();
            try {
                hideDialog();
                JSONObject root = null;
                try {
                    root = new JSONObject(response);
                    Toast.makeText(Dialog_Activity.this, "" + root.getString("message"), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                customdialog.dismiss();
                Intent intent = new Intent(Dialog_Activity.this, UserDashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
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
