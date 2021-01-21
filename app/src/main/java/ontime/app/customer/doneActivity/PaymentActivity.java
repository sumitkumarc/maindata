package ontime.app.customer.doneActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import ontime.app.R;
import ontime.app.customer.Adapter.RvCreditCardListAdapter;
import ontime.app.databinding.ActivityPaymentBinding;
import ontime.app.model.usermain.ExampleUser;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.sqllight.CardDetails;
import ontime.app.sqllight.DBManager;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;

import java.util.ArrayList;

public class PaymentActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner {
    public static ActivityPaymentBinding binding;
    public static DBManager dbManager;
    public static RvCreditCardListAdapter mAdapter;
    public static ArrayList<CardDetails> cardDetails;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DBManager(this);
        dbManager.open();
        if (Common.MERCHANT_TYPE == 1) {
            Common.setSystemBarColor(this, R.color.colorAccent);
//            Common.setSystemBarLight(this);
            binding.llMainTop.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            binding.ivBack.setColorFilter(getResources().getColor(R.color.colorAccent));

        } else {
            Common.setSystemBarColor(this, R.color.super_mart);
//            Common.setSystemBarLight(this);
            binding.ivBack.setColorFilter(getResources().getColor(R.color.super_mart));
            binding.llMainTop.setBackgroundColor(getResources().getColor(R.color.super_mart));
        }
        Cursor cursor = dbManager.fetch();
        LinearLayoutManager mLayoutManager1as = new LinearLayoutManager(getContext());
        mLayoutManager1as.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvList.setLayoutManager(mLayoutManager1as);

        showlistdata(PaymentActivity.this);
        GetApiCallToWallets();

    }
    private void showDialog() {
        dialog = new ProgressDialog(PaymentActivity.this);
        dialog.setMessage(getResources().getString(R.string.Please_wait));
        dialog.setCancelable(false);
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    public static void showlistdata(Context context) {
        cardDetails = dbManager.listContacts();
        if (cardDetails.size() > 0) {
            binding.rvList.setVisibility(View.VISIBLE);
            mAdapter = new RvCreditCardListAdapter(context, cardDetails);
            binding.rvList.setItemAnimator(new DefaultItemAnimator());
            binding.rvList.setAdapter(mAdapter);
        } else {
            binding.rvList.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment);
    }

    @Override
    protected void setListener() {
        super.setListener();
        binding.back.setOnClickListener(this);
        binding.addNewCard.setOnClickListener(this);
        binding.llAddPamnet.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.add_new_card:
                showAddtoCartItem();
                break;
            case R.id.ll_add_pamnet:
                    if(isConnected()){
                        showAddAmount();

                    }


                break;

        }
    }

    private void ApiCallToAddPayment(String amount) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("amount", amount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_WALLET_BALANCE;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_WALLET_BALANCE, this);
    }
    private void GetApiCallToWallets() {
        String url = AppConstant.GET_WALLET;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(false);
        apIcall.execute(url, APIcall.OPERATION_WALLET, this);
    }
    @Override
    public void onStartLoading(int operationCode) {
        if (operationCode == APIcall.OPERATION_WALLET_BALANCE) {
            showDialog();
        }
        if (operationCode == APIcall.OPERATION_WALLET) {
            showDialog();
        }
    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        try {
            if (operationCode == APIcall.OPERATION_WALLET_BALANCE) {
                hideDialog();
                Gson gson = new Gson();
                ExampleUser exampleUser = gson.fromJson(response, ExampleUser.class);
                if (exampleUser.getStatus() == 200) {
                    GetApiCallToWallets();
                    Toast.makeText(getContext(), "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            if(operationCode ==APIcall.OPERATION_WALLET){
                hideDialog();
                Gson gson = new Gson();
                ExampleUser exampleUser = gson.fromJson(response, ExampleUser.class);
                if (exampleUser.getStatus() == 200) {
                    Float main = Float.valueOf(exampleUser.getResponceData().getBalance());
                    binding.txtWallet.setText("SR " + Common.isStrempty(exampleUser.getResponceData().getBalance()));
                    Toast.makeText(getContext(), "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void showAddAmount() {
        final Dialog dialogm = new Dialog(this);
        dialogm.setCancelable(true);
        dialogm.setContentView(R.layout.pop_add_amount);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogm.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialogm.getWindow().setAttributes(lp);
        dialogm.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogm.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        ImageView bt_close = dialogm.findViewById(R.id.bt_close);
        final EditText ed_card_number = dialogm.findViewById(R.id.ed_card_number);
        AppCompatButton bt_add_now = dialogm.findViewById(R.id.bt_add_now);
        TextView txt_title = dialogm.findViewById(R.id.txt_title);
        if (Common.MERCHANT_TYPE == 1) {
            txt_title.setTextColor(getResources().getColor(R.color.colorAccent));
            bt_close.setColorFilter(getResources().getColor(R.color.colorAccent));
            bt_add_now.setBackground(getResources().getDrawable(R.drawable.btn_goldenrect));

        } else {
            txt_title.setTextColor(getResources().getColor(R.color.super_mart));
            bt_close.setColorFilter(getResources().getColor(R.color.super_mart));
            bt_add_now.setBackground(getResources().getDrawable(R.drawable.btn_goldenrectorange));
        }
        bt_add_now.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if (!Common.edvalidateName(ed_card_number.getText().toString(), ed_card_number, getResources().getString(R.string.v_enter_card_no))) {
                    return;
                }
                ApiCallToAddPayment(ed_card_number.getText().toString());
                dialogm.dismiss();
            }
        });
        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogm.dismiss();
            }
        });
        dialogm.show();
    }
    public void showAddtoCartItem() {
        final Dialog dialogm = new Dialog(this);
        dialogm.setCancelable(true);
        dialogm.setContentView(R.layout.pop_add_card);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogm.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialogm.getWindow().setAttributes(lp);
        dialogm.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogm.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        ImageView bt_close = dialogm.findViewById(R.id.bt_close);
        final EditText ed_card_number = dialogm.findViewById(R.id.ed_card_number);
        final EditText ed_expiry_date = dialogm.findViewById(R.id.ed_expiry_date);
        final EditText ed_name_on_card = dialogm.findViewById(R.id.ed_name_on_card);
        AppCompatButton bt_add_now = dialogm.findViewById(R.id.bt_add_now);
        TextView txt_title = dialogm.findViewById(R.id.txt_title);
        if (Common.MERCHANT_TYPE == 1) {
            txt_title.setTextColor(getResources().getColor(R.color.colorAccent));
            bt_close.setColorFilter(getResources().getColor(R.color.colorAccent));
            bt_add_now.setBackground(getResources().getDrawable(R.drawable.btn_goldenrect));

        } else {
            txt_title.setTextColor(getResources().getColor(R.color.super_mart));
            bt_close.setColorFilter(getResources().getColor(R.color.super_mart));
            bt_add_now.setBackground(getResources().getDrawable(R.drawable.btn_goldenrectorange));
        }
        bt_add_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Common.edvalidateName(ed_card_number.getText().toString(), ed_card_number, getResources().getString(R.string.v_enter_card_no)) |
                        !Common.edvalidateName(ed_expiry_date.getText().toString(), ed_expiry_date, getResources().getString(R.string.v_enter_card_date)) |
                        !Common.edvalidateName(ed_name_on_card.getText().toString(), ed_name_on_card, getResources().getString(R.string.v_enter_card_hoder))) {
                    return;
                }
                dbManager.insert(ed_name_on_card.getText().toString(), ed_card_number.getText().toString(), ed_expiry_date.getText().toString());
                dialogm.dismiss();
                showlistdata(PaymentActivity.this);
            }
        });
        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogm.dismiss();
            }
        });
        dialogm.show();
    }

}