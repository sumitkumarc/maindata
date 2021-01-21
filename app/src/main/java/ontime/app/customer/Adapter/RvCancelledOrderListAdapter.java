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
        } else {
            holder.binding.txtTitle.setTextColor(mContext.getResources().getColor(R.color.super_mart));
            holder.binding.txtTime.setTextColor(mContext.getResources().getColor(R.color.super_mart));
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
        holder.binding.txtOrderId.setText("Oder No : " + Common.isStrempty(mCancelledList.get(position).getOrderNumber()));
        holder.binding.txtOrderPaymentStatus.setText(Common.isStrempty(mCancelledList.get(position).getPaymentStatus() + " : SR "+Common.isStrempty(mCancelledList.get(position).getGrandTotal())));
        holder.binding.txtOrderPamnetType.setText("Payment type : " + Common.isStrempty(mCancelledList.get(position).getPaymentType()));
        Glide.with(mContext).load(mCancelledList.get(position).getRestaurant().getImage()).centerCrop().placeholder(R.drawable.ic_action_user).into(holder.binding.ivRestProfileImg);
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
