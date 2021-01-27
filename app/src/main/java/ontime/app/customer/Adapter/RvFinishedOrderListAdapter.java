package ontime.app.customer.Adapter;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import ontime.app.R;
import ontime.app.databinding.RowItemorderFinisedBinding;
import ontime.app.databinding.RowNotificationItemBinding;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.restaurant.ui.Activity.RiderOrderDetails;
import ontime.app.restaurant.ui.Activity.WelcomeActivity;
import ontime.app.utils.BaseAdapter;
import ontime.app.utils.Common;

import java.util.List;

public class RvFinishedOrderListAdapter extends BaseAdapter<RvFinishedOrderListAdapter.MyViewHolder> implements APIcall.ApiCallListner {
    Context mContext;
    List<OrderFinished> mOrderFinisheds;
    ProgressDialog dialog;

    public RvFinishedOrderListAdapter(Context context, List<OrderFinished> objFinished) {
        mContext = context;
        mOrderFinisheds = objFinished;
    }

    @Override
    public int getItemCount() {
        return mOrderFinisheds.size();
    }

    private void showDialog() {
        dialog = new ProgressDialog(mContext);
        dialog.setMessage(mContext.getResources().getString(R.string.Please_wait));
        dialog.setCancelable(false);
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    protected MyViewHolder onCreateView(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_itemorder_finised, viewGroup, false);
        return new MyViewHolder(itemView, RowItemorderFinisedBinding.bind(itemView));
    }

    @Override
    protected void bindRViewHolder(MyViewHolder holder, int position) {
        if (Common.MERCHANT_TYPE == 1) {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.btReOrder.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.btn_golden));
        } else {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.btReOrder.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.btn_goldenrectorange));
        }
        holder.binding.txtTitle.setText(Common.isStrempty(mOrderFinisheds.get(position).getRestaurant().getName()));
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mOrderFinisheds.get(position).getOrderNumber()));
        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(mOrderFinisheds.get(position).getCreatedAt()));
        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(mOrderFinisheds.get(position).getCreatedAt()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
        Glide.with(mContext).load(mOrderFinisheds.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);

        if ((mOrderFinisheds.get(position).getDeliveryStatus() == 0)) {
            holder.binding.txtOrderStatus.setText("Status : " + "New");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 1)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Processing");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 2)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 3)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 4)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 99)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
        }

        if ((mOrderFinisheds.get(position).getPaymentType().equals("1"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Wallet");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("2"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Card");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("3"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Apple Pay");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("99"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Unknown");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("4"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Cod");
        }
        try {
            if (Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus()).equals("success")) {
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                holder.binding.txtOrderPaymentStatus.setText("Paid" + " : SR " + Common.isStrempty(mOrderFinisheds.get(position).getTotalPrice()));

            } else {
                holder.binding.txtOrderPaymentStatus.setText("Pending" + " : SR " + Common.isStrempty(mOrderFinisheds.get(position).getTotalPrice()));
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } catch (Exception e) {
            holder.binding.txtOrderPaymentStatus.setVisibility(View.GONE);
        }

        holder.binding.btReOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()) {
                    String rating = String.valueOf(holder.binding.rbRateReview.getRating());
                    if (rating == null) {
                        Toast.makeText(mContext, "retting add", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (holder.binding.edReviewMsg.getText().toString().equals("")) {
                        Toast.makeText(mContext, "Enter review msg.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    APICallUserOrderReview(mOrderFinisheds.get(position).getId(),holder.binding.edReviewMsg.getText().toString(),rating);
                }
            }
        });
    }

    @Override
    protected int getListCounter() {
        return mOrderFinisheds.size();
    }

    public void APICallUserOrderReview( int order_id, String msg, String rating) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("rate", rating);
            jsonObject.put("review", msg);
            jsonObject.put("merchant_id", Common.MERCHANT_TYPE);
            jsonObject.put("rate_type", 2);
            jsonObject.put("order_id", order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_RATE;
        APIcall apIcall = new APIcall(mContext);
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_RATE_US, this);
    }

    @Override
    public void onStartLoading(int operationCode) {
        if(operationCode == APIcall.OPERATION_USER_RATE_US){
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
                    Toast.makeText(mContext, "" + root.getString("message"), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            hideDialog();
        }

    }

    @Override
    public void onFail(int operationCode, String response) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RowItemorderFinisedBinding binding;

        MyViewHolder(View itemView, RowItemorderFinisedBinding itemBinding) {
            super(itemView);
            binding = itemBinding;

        }
    }
}
