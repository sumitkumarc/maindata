package ontime.app.customer.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import ontime.app.R;
import ontime.app.databinding.RowItemorderCancelledBinding;
import ontime.app.databinding.RowItemorderProssingBinding;
import ontime.app.databinding.RowNotificationItemBinding;
import ontime.app.model.usermain.OrderCancelled;
import ontime.app.utils.Common;

import java.util.List;

public class RvCancelledOrderListAdapter extends RecyclerView.Adapter<RvCancelledOrderListAdapter.MyViewHolder> {
    Context mContext;
    List<OrderCancelled> mCancelledList;
    public RvCancelledOrderListAdapter(Context context, List<OrderCancelled> objCancelled) {
        mContext = context;
        mCancelledList = objCancelled;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itemorder_prossing, parent, false);
        return new MyViewHolder(itemView, RowItemorderProssingBinding.bind(itemView));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if (Common.MERCHANT_TYPE == 1) {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.btCancelled.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.btn_golden));
        } else {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.btCancelled.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.btn_goldenrectorange));
        }
//        if (Common.MERCHANT_TYPE == 1) {
//            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//            holder.binding.txtAmount.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//            holder.binding.txtStatus.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//            holder.binding.btCancelled.setBackground(mContext.getResources().getDrawable(R.drawable.btn_golden));
//            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//        } else {
//            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//            holder.binding.txtAmount.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//            holder.binding.btCancelled.setBackground(mContext.getResources().getDrawable(R.drawable.btn_red));
//            holder.binding.txtStatus.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//        }
//        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mCancelledList.get(position).getOrderNumber()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mCancelledList.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mCancelledList.get(position).getGrandTotal())));
//        holder.binding.txtOrderPamnetType.setText("Payment type : " + Common.isStrempty(mCancelledList.get(position).getPaymentType()));

        holder.binding.txtTitle.setText(Common.isStrempty(mCancelledList.get(position).getRestaurant().getName()));
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mCancelledList.get(position).getOrderNumber()));
        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(mCancelledList.get(position).getCreatedAt()));
        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(mCancelledList.get(position).getCreatedAt()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
        Glide.with(mContext).load(mCancelledList.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);

        if ((mCancelledList.get(position).getDeliveryStatus() == 0)) {
            holder.binding.txtOrderStatus.setText("Status : " + "New");
        } else if ((mCancelledList.get(position).getDeliveryStatus() == 1)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Processing");
        } else if ((mCancelledList.get(position).getDeliveryStatus() == 2)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
        } else if ((mCancelledList.get(position).getDeliveryStatus() == 3)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
        } else if ((mCancelledList.get(position).getDeliveryStatus() == 4)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
        }else if ((mCancelledList.get(position).getDeliveryStatus() == 99)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
        }

        if ((mCancelledList.get(position).getPaymentType().equals("1"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Wallet");
        } else if ((mCancelledList.get(position).getPaymentType().equals("2"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Card");
        } else if ((mCancelledList.get(position).getPaymentType().equals("3"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Apple Pay");
        } else if ((mCancelledList.get(position).getPaymentType().equals("99"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Unknown");
        } else if ((mCancelledList.get(position).getPaymentType().equals("4"))) {
            holder.binding.txtOrderPamentType.setText(mContext.getResources().getString(R.string.P_type) + " : " + "Cod");
        }
        try {
            if (Common.isStrempty(mCancelledList.get(position).getPaymentStatus()).equals("success")) {
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                holder.binding.txtOrderPaymentStatus.setText("Paid" + " : SR " + Common.isStrempty(mCancelledList.get(position).getTotalPrice()));

            } else {
                holder.binding.txtOrderPaymentStatus.setText("Pending" + " : SR " + Common.isStrempty(mCancelledList.get(position).getTotalPrice()));
                holder.binding.txtOrderPaymentStatus.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } catch (Exception e) {
            holder.binding.txtOrderPaymentStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mCancelledList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RowItemorderProssingBinding binding;

        MyViewHolder(View itemView, RowItemorderProssingBinding itemBinding) {
            super(itemView);
            binding = itemBinding;

        }
    }
}
