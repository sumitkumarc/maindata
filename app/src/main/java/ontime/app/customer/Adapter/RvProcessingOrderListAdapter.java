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

import ontime.app.R;
import ontime.app.customer.doneActivity.MyOrdersListActivity;
import ontime.app.customer.doneActivity.RequestPendingActivity;
import ontime.app.databinding.RRowNeworderItemBinding;
import ontime.app.databinding.RowItemorderProssingBinding;
import ontime.app.databinding.RowNotificationItemBinding;
import ontime.app.model.usermain.ExampleUser;
import ontime.app.model.usermain.OrderProccessing;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.restaurant.adapte.RvNewOrderAdapter;
import ontime.app.restaurant.model.readerOrder.ReaderExample;
import ontime.app.utils.BaseAdapter;
import ontime.app.utils.Common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvProcessingOrderListAdapter extends BaseAdapter<RvProcessingOrderListAdapter.MyViewHolder> implements APIcall.ApiCallListner {
    Context mContext;
    ArrayList<OrderProccessing> mProccessings;
    ProgressDialog dialog;
    int POSTION = 0;
    Date c_cancle_date;
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public RvProcessingOrderListAdapter(Context context, ArrayList<OrderProccessing> objProcessing) {
        mContext = context;
        mProccessings = objProcessing;
    }

    @Override
    protected MyViewHolder onCreateView(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.row_itemorder_prossing, viewGroup, false);
        return new MyViewHolder(itemView, RowItemorderProssingBinding.bind(itemView));
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    protected void bindRViewHolder(MyViewHolder holder, final int position) {
        if (Common.MERCHANT_TYPE == 1) {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
        }

        holder.binding.txtTitle.setText(Common.isStrempty(mProccessings.get(position).getRestaurant().getName()));
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mProccessings.get(position).getOrderNumber()));
        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(mProccessings.get(position).getCreatedAt()));
        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(mProccessings.get(position).getCreatedAt()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
        Glide.with(mContext).load(mProccessings.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);

        if ((mProccessings.get(position).getDeliveryStatus() == 0)) {
            holder.binding.txtOrderStatus.setText("Status : " + "New");
        } else if ((mProccessings.get(position).getDeliveryStatus() == 1)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Processing");
        } else if ((mProccessings.get(position).getDeliveryStatus() == 2)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
        } else if ((mProccessings.get(position).getDeliveryStatus() == 3)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
        } else if ((mProccessings.get(position).getDeliveryStatus() == 4)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
        } else if ((mProccessings.get(position).getDeliveryStatus() == 99)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
        }

        if ((mProccessings.get(position).getPaymentType().equals("1"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Wallet");
        } else if ((mProccessings.get(position).getPaymentType().equals("2"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Card");
        } else if ((mProccessings.get(position).getPaymentType().equals("3"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Apple Pay");
        } else if ((mProccessings.get(position).getPaymentType().equals("99"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Unknown");
        } else if ((mProccessings.get(position).getPaymentType().equals("4"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Cod");
        }
        try {
            if (Common.isStrempty(mProccessings.get(position).getPaymentStatus()).equals("success")) {
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                holder.binding.txtOrderPaymentStatus.setText("Paid" + " : SR " + Common.isStrempty(mProccessings.get(position).getTotalPrice()));

            } else {
                holder.binding.txtOrderPaymentStatus.setText("Pending" + " : SR " + Common.isStrempty(mProccessings.get(position).getTotalPrice()));
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } catch (Exception e) {
            holder.binding.txtOrderPaymentStatus.setVisibility(View.GONE);
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);


//        holder.binding.txtTitle.setText(Common.isStrempty(mProccessings.get(position).getRestaurant().getName()));
//        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mProccessings.get(position).getOrderNumber()));
//        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(mProccessings.get(position).getCreatedAt()));
//        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(mProccessings.get(position).getCreatedAt()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mProccessings.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mProccessings.get(position).getGrandTotal())));
//        Glide.with(mContext).load(mProccessings.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);
//
//        if ((mProccessings.get(position).getDeliveryStatus() == 0)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "New");
//        } else if ((mProccessings.get(position).getDeliveryStatus() == 1)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "processing");
//        } else if ((mProccessings.get(position).getDeliveryStatus() == 2)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
//        } else if ((mProccessings.get(position).getDeliveryStatus() == 3)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
//        } else if ((mProccessings.get(position).getDeliveryStatus() == 4)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
//        }else if ((mProccessings.get(position).getDeliveryStatus() == 99)) {
//            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
//        }
//
//        if ((mProccessings.get(position).getPaymentType().equals("1"))) {
//            holder.binding.txtOrderStatus.setText("Payment type : " + "Wallet");
//        } else if ((mProccessings.get(position).getPaymentType().equals("2"))) {
//            holder.binding.txtOrderStatus.setText("Payment type : " + "Card");
//        } else if ((mProccessings.get(position).getPaymentType().equals("3"))) {
//            holder.binding.txtOrderStatus.setText("Payment type : " + "Apple Pay");
//        } else if ((mProccessings.get(position).getPaymentType().equals("99"))) {
//            holder.binding.txtOrderStatus.setText("Payment type : " + "Unknown");
//        } else if ((mProccessings.get(position).getPaymentType().equals("4"))) {
//            holder.binding.txtOrderStatus.setText("Payment type : " + "Cash On Delivery");
//        }
        holder.binding.btCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date_cancels = null;
                try {
                    date_cancels = timeFormat.parse(mProccessings.get(position).getCreatedAt());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                cal.setTime(date_cancels);
                cal.add(Calendar.MINUTE, 2);
                timeFormat.format(cal.getTime());
                c_cancle_date = cal.getTime();
                Date current_dateas = new Date();
                if (!current_dateas.after(c_cancle_date)) {
                    POSTION = position;
                    APICallUserCancleOrder(mProccessings.get(position).getId());
                } else {
                    Toast.makeText(mContext, "Time out for order cancel", Toast.LENGTH_SHORT).show();

                }


            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mProccessings.get(position).getCountdownTime() != null) {
                    Common.ORDERPROCCESSING_ORDER = mProccessings.get(position);
                    mContext.startActivity(new Intent(mContext, RequestPendingActivity.class));
                } else {
                    Toast.makeText(mContext, "Order Not accepted", Toast.LENGTH_SHORT).show();
                }
//                APICallUserCancleOrder(mProccessings.get(position).getId());
            }
        });

    }

    @Override
    protected int getListCounter() {
        return mProccessings.size();

    }

    public void removeAt(int position) {
        mProccessings.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mProccessings.size());
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

    public void APICallUserCancleOrder(int order_id) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("order_id", order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(APIcall.JSON, jsonObject + "");
        String url = AppConstant.GET_USER_CANCEL_ORDER;
        APIcall apIcall = new APIcall(mContext);
        apIcall.isPost(true);
        apIcall.setBody(body);
        apIcall.execute(url, APIcall.OPERATION_USER_CANCEL_ORDER, this);
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
                JSONObject json_data = new JSONObject(response);
                if (json_data.getInt("status") == 200) {
                    Toast.makeText(mContext, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                    removeAt(POSTION);
                    if (mProccessings.size() > 0) {
                        mProccessings.remove(POSTION);
                        notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(mContext, json_data.getString("message"), Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            hideDialog();
        }
    }

    @Override
    public void onFail(int operationCode, String response) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RowItemorderProssingBinding binding;

        MyViewHolder(View itemView, RowItemorderProssingBinding itemBinding) {
            super(itemView);
            binding = itemBinding;

        }
    }
}
