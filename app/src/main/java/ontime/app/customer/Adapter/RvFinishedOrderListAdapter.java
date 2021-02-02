package ontime.app.customer.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
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
import ontime.app.model.usermain.UserReview;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.restaurant.ui.Activity.RiderOrderDetails;
import ontime.app.restaurant.ui.Activity.WelcomeActivity;
import ontime.app.utils.BaseAdapter;
import ontime.app.utils.Common;

import java.util.List;

public class RvFinishedOrderListAdapter extends BaseAdapter<RvFinishedOrderListAdapter.MyViewHolder> {
    Context mContext;
    List<OrderFinished> mOrderFinisheds;

    UserReview mUserReview;
    OrderFinished orderFinished;
    String ORDER_REVIEW = "";
    String ORDER_RATE = "";
    MyViewHolder holderNew;
    OnClick onClick;

    int pos;

    public RvFinishedOrderListAdapter(Context context, List<OrderFinished> objFinished) {
        mContext = context;
        mOrderFinisheds = objFinished;
    }

    @Override
    public int getItemCount() {
        return mOrderFinisheds.size();
    }


    @Override
    protected MyViewHolder onCreateView(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_itemorder_finised, viewGroup, false);
        return new MyViewHolder(itemView, RowItemorderFinisedBinding.bind(itemView));
    }

    public interface OnClick {
        void OnItemClick(RowItemorderFinisedBinding binding, View view, int position);
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;

    }

    @Override
    protected void bindRViewHolder(MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        orderFinished = (OrderFinished) mOrderFinisheds.get(position);
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
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(orderFinished.getOrderNumber()));
        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(orderFinished.getCreatedAt()));
        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(orderFinished.getCreatedAt()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
        Glide.with(mContext).load(orderFinished.getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);

        if ((orderFinished.getDeliveryStatus() == 0)) {
            holder.binding.txtOrderStatus.setText("Status : " + "New");
        } else if ((orderFinished.getDeliveryStatus() == 1)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Processing");
        } else if ((orderFinished.getDeliveryStatus() == 2)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
        } else if ((orderFinished.getDeliveryStatus() == 3)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
        } else if ((orderFinished.getDeliveryStatus() == 4)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
        } else if ((orderFinished.getDeliveryStatus() == 99)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
        }

        if ((orderFinished.getPaymentType().equals("1"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Wallet");
        } else if ((orderFinished.getPaymentType().equals("2"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Card");
        } else if ((orderFinished.getPaymentType().equals("3"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Apple Pay");
        } else if ((orderFinished.getPaymentType().equals("99"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Unknown");
        } else if ((orderFinished.getPaymentType().equals("4"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Cod");
        }
        try {
            if (Common.isStrempty(orderFinished.getPaymentStatus()).equals("success")) {
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                holder.binding.txtOrderPaymentStatus.setText("Paid" + " : SR " + Common.isStrempty(orderFinished.getTotalPrice()));

            } else {
                holder.binding.txtOrderPaymentStatus.setText("Pending" + " : SR " + Common.isStrempty(orderFinished.getTotalPrice()));
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } catch (Exception e) {
            holder.binding.txtOrderPaymentStatus.setVisibility(View.GONE);
        }
        if (orderFinished.getReview() == null) {
            holder.binding.btReOrder.setVisibility(View.VISIBLE);
            holder.binding.edReviewMsg.setEnabled(true);
            holder.binding.rbRateReview.setIsIndicator(false);
        } else {
            holder.binding.btReOrder.setVisibility(View.GONE);
            holder.binding.edReviewMsg.setText(orderFinished.getReview().getReview());
            holder.binding.edReviewMsg.setEnabled(false);
            holder.binding.edReviewMsg.setInputType(InputType.TYPE_NULL);
            holder.binding.rbRateReview.setIsIndicator(true);
            holder.binding.rbRateReview.setRating((float) Float.parseFloat(orderFinished.getReview().getRate()));
            if (!orderFinished.getReview().getAsReview()) {
                holder.binding.btReOrder.setVisibility(View.GONE);
            }
        }


        holder.binding.btReOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick != null) {
                    onClick.OnItemClick(holder.binding, v, position);
                }
            }
        });
    }

    @Override
    protected int getListCounter() {
        return mOrderFinisheds.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RowItemorderFinisedBinding binding;

        MyViewHolder(View itemView, RowItemorderFinisedBinding itemBinding) {
            super(itemView);
            binding = itemBinding;

        }
    }
}
