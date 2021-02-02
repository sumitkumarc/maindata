package ontime.app.customer.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import ontime.app.R;
import ontime.app.customer.Adapter.RvFinishedOrderListAdapter;
import ontime.app.customer.doneActivity.MyOrdersListActivity;
import ontime.app.databinding.RowItemorderFinisedBinding;
import ontime.app.databinding.TabOrderProcessingBinding;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.model.usermain.UserReview;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.utils.Common;

public class TabOrderFinished extends BaseFragment implements APIcall.ApiCallListner {
    RvFinishedOrderListAdapter mAdapter;
    TabOrderProcessingBinding binding;
    ProgressDialog dialog;
    String ORDER_REVIEW;
    String ORDER_RATE;
    int pos;
    public ArrayList<OrderFinished> objFinished = new ArrayList<>();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tab_order_processing, viewGroup, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isConnected()) {
            // inclineWeight();
        } else {
            Common.displayToastMessageShort(getContext(), AppConstant.CONNECTION_ERROR_MSG, false);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) {
            if (isConnected()) {
                inclineWeight();
            } else {
                Common.displayToastMessageShort(getContext(), AppConstant.CONNECTION_ERROR_MSG, false);
            }
        }
    }

    private void inclineWeight() {
        LinearLayoutManager mLayoutManager1as = new LinearLayoutManager(getContext());
        mLayoutManager1as.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvDetails.setLayoutManager(mLayoutManager1as);

        if (MyOrdersListActivity.objFinished.size() != 0 && MyOrdersListActivity.objFinished != null) {
            objFinished.clear();
            objFinished.addAll(MyOrdersListActivity.objFinished);
            binding.rvDetails.setVisibility(View.VISIBLE);
            binding.txtNoData.setVisibility(View.GONE);
            mAdapter = new RvFinishedOrderListAdapter(getContext(), MyOrdersListActivity.objFinished);
            binding.rvDetails.setItemAnimator(new DefaultItemAnimator());
            binding.rvDetails.setAdapter(mAdapter);
        } else {
            binding.rvDetails.setVisibility(View.GONE);
            binding.txtNoData.setVisibility(View.VISIBLE);
        }
        mAdapter.setOnClick(new RvFinishedOrderListAdapter.OnClick() {
            @Override
            public void OnItemClick(RowItemorderFinisedBinding binding, View view, int position) {
                pos = position;
                if (isConnected()) {
                    ORDER_REVIEW = binding.edReviewMsg.getText().toString();
                    ORDER_RATE = String.valueOf(binding.rbRateReview.getRating());
                    if (binding.edReviewMsg.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Enter your review message.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    APICallUserOrderReview(position, objFinished.get(position).getId(), binding.edReviewMsg.getText().toString(), binding.rbRateReview.getRating(), objFinished.get(position).getRestaurantId());

                }
            }


        });
    }

    @Override
    protected void initView(View view) {
        binding = TabOrderProcessingBinding.bind(view);
    }

    public void APICallUserOrderReview(int position, Integer order_id, String msg, Float rating, Integer restaurantId) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("rate", rating);
            jsonObject.put("review", msg);
            jsonObject.put("merchant_id", restaurantId);
            jsonObject.put("rate_type", 2);
            jsonObject.put("order_id", order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_RATE;
        APIcall apIcall = new APIcall(getActivity());
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_RATE_US, this);
    }

    private void showDialog() {
        dialog = new ProgressDialog(getActivity());
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
        try {
            if (operationCode == APIcall.OPERATION_USER_RATE_US) {
                hideDialog();
                JSONObject root = null;
                try {
                    root = new JSONObject(response);
                    Toast.makeText(getActivity(), "" + root.getString("message"), Toast.LENGTH_SHORT).show();
                    OrderFinished orderFinished = objFinished.get(pos);
                    UserReview userReview = new UserReview();
                    userReview.setAsReview(false);
                    userReview.setReview(ORDER_REVIEW);
                    userReview.setRate(ORDER_RATE);
                    orderFinished.setReview(userReview);
                    mAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            hideDialog();
        }

    }

    @Override
    public void onFail(int operationCode, String response) {

    }
}
