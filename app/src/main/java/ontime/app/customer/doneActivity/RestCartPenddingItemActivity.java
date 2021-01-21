package ontime.app.customer.doneActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import ontime.app.R;
import ontime.app.customer.Adapter.RvRestaurantCartPenddingListAdapter;
import ontime.app.databinding.ActivityCartBinding;
import ontime.app.model.usermain.UserCartItem;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.rv_interface;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;

public class RestCartPenddingItemActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner, rv_interface {

    ActivityCartBinding binding;
    private ProgressDialog dialog;
    RvRestaurantCartPenddingListAdapter mAdapter;
    rv_interface anInterface;
    int position = 0;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        anInterface = RestCartPenddingItemActivity.this;
        setUpUI();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setUpUI() {
        binding.payButtonId.setVisibility(View.VISIBLE);
        if (Common.MERCHANT_TYPE == 1) {
            Common.setSystemBarColor(this, R.color.colorAccent);
            Common.setSystemBarLight(this);
            binding.txtTitle.setTextColor(getResources().getColor(R.color.colorAccent));
            binding.payButtonId.setBackground(getResources().getDrawable(R.drawable.r_btn_design));

        } else {
            Common.setSystemBarColor(this, R.color.super_mart);
            Common.setSystemBarLight(this);
            binding.txtTitle.setTextColor(getResources().getColor(R.color.super_mart));
            binding.payButtonId.setBackground(getResources().getDrawable(R.drawable.super_btn_design));
        }
        LinearLayoutManager mLayoutManager1as = new LinearLayoutManager(getContext());
        mLayoutManager1as.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvList.setLayoutManager(mLayoutManager1as);
        binding.txtCount.setText("");
        GetAPICallRestaurantCartList();
    }

    private void GetAPICallRestaurantCartList() {
        if (Common.newCartItem.size() != 0) {
            binding.rvList.setVisibility(View.VISIBLE);
            binding.tvNodata.setVisibility(View.GONE);
            binding.txtCount.setText("(" + String.valueOf(Common.newCartItem.size()) + ")");
            mAdapter = new RvRestaurantCartPenddingListAdapter(getContext(), Common.newCartItem, true);
            binding.rvList.setItemAnimator(new DefaultItemAnimator());
            binding.rvList.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);
        } else {
            binding.rvList.setVisibility(View.GONE);
            binding.tvNodata.setVisibility(View.VISIBLE);
        }

    }

    private void GetAPICallRestCartListItemDelete(int pos) {
        Common.hideKeyboard(getActivity());
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cart_item_id", pos);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_RESTAURANT_DELETE_CART;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_RESTAURANT_DELETE_CART, this);
    }

    protected void setListener() {
        super.setListener();
        binding.back.setOnClickListener(this);
        binding.payButtonId.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.payButtonId:
                startActivity(new Intent(this, OrderSummaryActivity.class));
                break;
            default:
                break;
        }
    }

    private void showDialog() {
        dialog = new ProgressDialog(RestCartPenddingItemActivity.this);
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
//        if (operationCode == APIcall.OPERATION_RESTAURANT_MY_CART) {
//            showDialog();
//        }
        if (operationCode == APIcall.OPERATION_RESTAURANT_DELETE_CART) {
            showDialog();
        }
        if (operationCode == APIcall.OPERATION_MENU_ITEM_UPDATE_DETAIL) {
            showDialog();
        }

    }

    @Override
    public void OnItemClick(Integer id, int item_id) {
        position = id;
        GetAPICallRestCartListItemDelete(item_id);
    }

    @Override
    public void OnUpDateItemClick(UserCartItem item_id) {
        GetAPICallRestaurantItemUPDATEAddtoCart(item_id);
    }

    private void GetAPICallRestaurantItemUPDATEAddtoCart(UserCartItem item_id) {
        Common.hideKeyboard(getActivity());
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cart_item_id", item_id.getId());
            jsonObject.put("addition_id", item_id.getAdditionId().getId());
            jsonObject.put("size_id", item_id.getSizeId().getId());
            jsonObject.put("removal_id", item_id.getRemovalId().getId());
            jsonObject.put("quantity", item_id.getQuantity());
            jsonObject.put("unit_price", item_id.getUnitPrice());
            jsonObject.put("total_price", item_id.getTotalPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_RESTAURANT_MENU_ITEM_UPDATE_DETAIL;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_MENU_ITEM_UPDATE_DETAIL, this);
    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        try {
            if (operationCode == APIcall.OPERATION_RESTAURANT_DELETE_CART) {
                hideDialog();
                try {
                    JSONObject json_data = new JSONObject(response);
                    if (json_data.getInt("status") == 200) {
                        Toast.makeText(this, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                        mAdapter.notifyDataSetChanged();
                        Common.newCartItem.remove(position);
                        mAdapter.notifyItemRemoved(position);
                    } else {
                        Toast.makeText(this, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (operationCode == APIcall.OPERATION_MENU_ITEM_UPDATE_DETAIL) {
                hideDialog();
                JSONObject json_data = new JSONObject(response);
                if (json_data.getInt("status") == 200) {
                    Toast.makeText(this, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                    GetAPICallRestaurantCartList();
                } else {
                    Toast.makeText(this, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {

        }


    }

    @Override
    public void onFail(int operationCode, String response) {

    }

}