package ontime.app.customer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;


import ontime.app.R;
import ontime.app.customer.Adapter.RvFinishedOrderListAdapter;
import ontime.app.customer.doneActivity.MyOrdersListActivity;
import ontime.app.databinding.TabOrderProcessingBinding;
import ontime.app.okhttp.AppConstant;
import ontime.app.utils.Common;

public class TabOrderFinished extends BaseFragment {
    RvFinishedOrderListAdapter mAdapter;
    TabOrderProcessingBinding binding;

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
        if (isVisibleToUser&& isResumed()) {
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
        if(MyOrdersListActivity.objProcessing.size() != 0 && MyOrdersListActivity.objProcessing != null ){
            binding.rvDetails.setVisibility(View.VISIBLE);
            binding.txtNoData.setVisibility(View.GONE);
            mAdapter = new RvFinishedOrderListAdapter(getContext(), MyOrdersListActivity.objFinished);
            binding.rvDetails.setItemAnimator(new DefaultItemAnimator());
            binding.rvDetails.setAdapter(mAdapter);
        }else {
            binding.rvDetails.setVisibility(View.GONE);
            binding.txtNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initView(View view) {
        binding = TabOrderProcessingBinding.bind(view);
    }
}
