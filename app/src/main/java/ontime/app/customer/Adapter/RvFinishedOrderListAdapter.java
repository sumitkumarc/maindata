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
import ontime.app.databinding.RowItemorderFinisedBinding;
import ontime.app.databinding.RowNotificationItemBinding;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.utils.Common;

import java.util.List;

public class RvFinishedOrderListAdapter extends RecyclerView.Adapter<RvFinishedOrderListAdapter.MyViewHolder> {
    Context mContext;
    List<OrderFinished> mOrderFinisheds;

    public RvFinishedOrderListAdapter(Context context, List<OrderFinished> objFinished) {
        mContext = context;
        mOrderFinisheds = objFinished;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itemorder_finised, parent, false);
        return new MyViewHolder(itemView, RowItemorderFinisedBinding.bind(itemView));
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
         if (Common.MERCHANT_TYPE == 1) {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
        }
        holder.binding.txtTitle.setText(Common.isStrempty(mOrderFinisheds.get(position).getRestaurant().getName()));
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mOrderFinisheds.get(position).getOrderNumber()));
        holder.binding.txtTime.setText("Oder time : " + Common.parseDateToddMMyyyy(mOrderFinisheds.get(position).getCreatedAt()));
        holder.binding.txtDeliverTime.setText("Deliver time : " + Common.parseDateToddMMyyyy(mOrderFinisheds.get(position).getCreatedAt()));
        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
        Glide.with(mContext).load(mOrderFinisheds.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);

        if ((mOrderFinisheds.get(position).getDeliveryStatus() == 0)) {
            holder.binding.txtOrderStatus.setText("Status : " + "New");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 1)) {
            holder.binding.txtOrderStatus.setText("Status : " + "processing");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 2)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled By User");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 3)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Cancelled");
        } else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 4)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Completed");
        }else if ((mOrderFinisheds.get(position).getDeliveryStatus() == 99)) {
            holder.binding.txtOrderStatus.setText("Status : " + "Unknown");
        }

        if ((mOrderFinisheds.get(position).getPaymentType().equals("1"))) {
            holder.binding.txtOrderStatus.setText("Payment type : " + "Wallet");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("2"))) {
            holder.binding.txtOrderStatus.setText("Payment type : " + "Card");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("3"))) {
            holder.binding.txtOrderStatus.setText("Payment type : " + "Apple Pay");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("99"))) {
            holder.binding.txtOrderStatus.setText("Payment type : " + "Unknown");
        } else if ((mOrderFinisheds.get(position).getPaymentType().equals("4"))) {
            holder.binding.txtOrderStatus.setText("Payment type : " + "Cash On Delivery");
        }
//        if (Common.MERCHANT_TYPE == 1) {
//            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
//            holder.binding.btReOrder.setBackground(mContext.getResources().getDrawable(R.drawable.btn_golden));
//        } else {
//            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//            holder.binding.btReOrder.setBackground(mContext.getResources().getDrawable(R.drawable.btn_red));
//            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
//        }
//        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mOrderFinisheds.get(position).getOrderNumber()));
//        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mOrderFinisheds.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mOrderFinisheds.get(position).getGrandTotal())));
//        holder.binding.txtOrderPamnetType.setText("Payment type : " + Common.isStrempty(mOrderFinisheds.get(position).getPaymentType()));
//        Glide.with(mContext).load(mOrderFinisheds.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);
    }

    @Override
    public int getItemCount() {
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
