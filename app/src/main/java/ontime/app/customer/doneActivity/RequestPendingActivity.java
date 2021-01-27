package ontime.app.customer.doneActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import okhttp3.RequestBody;
import ontime.app.R;
import ontime.app.customer.Adapter.RvRestPenddingListAdapter;
import ontime.app.databinding.ActivityRequestpendingBinding;
import ontime.app.model.usermain.ExampleUser;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;

public class RequestPendingActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner {

    public static String timeLeftFormatted;
    ProgressDialog dialog;
    ActivityRequestpendingBinding binding;

    public Runnable runnable;
    public Handler handler = new Handler();
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    Date event_date;
    Date c_cancle_date;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_requestpending);
    }

    @Override
    protected void setListener() {
        super.setListener();
        binding.back.setOnClickListener(this);
        binding.btCancel.setOnClickListener(this);
        binding.btPayNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.bt_cancel:
                if (isConnected()) {
                    Date current_dateas = new Date();
                    if (!current_dateas.after(c_cancle_date)) {
                        APICallUserCancleOrder(Common.ORDERPROCCESSING_ORDER.getId());
                    } else {
                        Toast.makeText(this, "Time out for order cancel", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.bt_pay_now:
                if (isConnected()) {

                }
                break;
        }
    }

    public void APICallUserCancleOrder(int order_id) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("order_id", order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_CANCEL_ORDER;
        APIcall apIcall = new APIcall(this);
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_CANCEL_ORDER, this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayoutManager mLayoutManager1as = new LinearLayoutManager(getContext());
        mLayoutManager1as.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvList.setLayoutManager(mLayoutManager1as);

        RvRestPenddingListAdapter mMAdapter = new RvRestPenddingListAdapter(getContext(), Common.ORDERPROCCESSING_ORDER.getOrderDetail(), Common.ORDERPROCCESSING_ORDER);
        binding.rvList.setItemAnimator(new DefaultItemAnimator());
        binding.rvList.setAdapter(mMAdapter);

        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date ss = new Date();
        try {
//            mreaderProccessings.get(position).getCountdownTime()
            ss = dateFormat.parse(Common.ORDERPROCCESSING_ORDER.getCountdownTime());
            c.setTime(ss);
//            mreaderProccessings.get(position).getDeliveryTime()
            c.add(Calendar.SECOND, Integer.parseInt(String.valueOf(parseTimeStringToSeconds(Common.ORDERPROCCESSING_ORDER.getDeliveryTime()))));
            event_date = new Date();
            dateFormat.setTimeZone(TimeZone.getDefault());
            event_date = c.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GetCountDownStart();

        Calendar c_cancle = Calendar.getInstance();
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date_cancel = new Date();
        try {
//            mreaderProccessings.get(position).getCountdownTime()
            date_cancel = dateFormat.parse(Common.ORDERPROCCESSING_ORDER.getCreatedAt());
            c_cancle.setTime(date_cancel);
//            mreaderProccessings.get(position).getDeliveryTime()
            c_cancle.add(Calendar.SECOND, 120);
            c_cancle_date = new Date();
            dateFormat.setTimeZone(TimeZone.getDefault());
            c_cancle_date = c_cancle.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    public static long parseTime(String str) throws NumberFormatException {
        if (str == null)
            throw new NumberFormatException("parseTimeString null str");
        if (str.isEmpty())
            throw new NumberFormatException("parseTimeString empty str");

        int h = 0;
        int m, s;
        String units[] = str.split(":");
        assert (units.length == 2 || units.length == 3);
        switch (units.length) {
            case 2:
                // mm:ss
                m = Integer.parseInt(units[0]);
                s = Integer.parseInt(units[1]);
                break;

            case 3:
                // hh:mm:ss
                h = Integer.parseInt(units[0]);
                m = Integer.parseInt(units[1]);
                s = Integer.parseInt(units[2]);
                break;

            default:
                throw new NumberFormatException("parseTimeString failed:" + str);
        }
        if (m < 0 || m > 60 || s < 0 || s > 60 || h < 0)
            throw new NumberFormatException("parseTimeString range error:" + str);
        return h * 3600 + m * 60 + s;
    }

    public static long parseTimeStringToSeconds(String str) {
        try {
            return parseTime(str);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    private void GetCountDownStart() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    handler.postDelayed(this, 500);
                    Date current_dateas = new Date();
                    if (!current_dateas.after(event_date)) {
                        long diff = event_date.getTime() - current_dateas.getTime();
                        long Days = diff / (24 * 60 * 60 * 1000);
                        long Hours = diff / (60 * 60 * 1000) % 24;
                        long Minutes = diff / (60 * 1000) % 60;
                        long Seconds = diff / 1000 % 60;
                        //
                        timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", Hours, Minutes, Seconds);

                        char ch1 = timeLeftFormatted.charAt(0);
                        char ch2 = timeLeftFormatted.charAt(1);

                        char ch3 = timeLeftFormatted.charAt(3);
                        char ch4 = timeLeftFormatted.charAt(4);

                        char ch5 = timeLeftFormatted.charAt(6);
                        char ch6 = timeLeftFormatted.charAt(7);

                        if (binding.txtHfirst.getText().hashCode() != ch1) {
                            binding.txtHfirst.setText(Character.toString(ch1));
                        }
                        if (binding.txtHfsecond.getText().hashCode() != ch2) {
                            binding.txtHfsecond.setText(Character.toString(ch2));
                        }
                        if (binding.txtMfirst.getText().hashCode() != ch3) {
                            binding.txtMfirst.setText(Character.toString(ch3));
                        }
                        if (binding.txtMSecond.getText().hashCode() != ch4) {
                            binding.txtMSecond.setText(Character.toString(ch4));
                        }
                        if (binding.txtSFirst.getText().hashCode() != ch5) {
                            binding.txtSFirst.setText(Character.toString(ch5));
                        }
                        if (binding.txtSSecond.getText().hashCode() != ch6) {
                            binding.txtSSecond.setText(Character.toString(ch6));
                        }
                    } else {

                        handler.removeCallbacks(runnable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void showDialog() {
        dialog = new ProgressDialog(RequestPendingActivity.this);
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
        if (operationCode == APIcall.OPERATION_USER_CANCEL_ORDER) {
            showDialog();
        }
    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        try {
            if (operationCode == APIcall.OPERATION_USER_CANCEL_ORDER) {
                hideDialog();
                Gson gson = new Gson();
                ExampleUser exampleUser = gson.fromJson(response, ExampleUser.class);
                if (exampleUser.getStatus() == 200) {
                    Toast.makeText(RequestPendingActivity.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RequestPendingActivity.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            hideDialog();
        } catch (Exception e) {
            hideDialog();
        }
    }

    @Override
    public void onFail(int operationCode, String response) {

    }
}