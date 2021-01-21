package ontime.app.restaurant.ui.Activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import ontime.app.databinding.RActivityRiderorderdetailsBinding;
import ontime.app.okhttp.APIcall;
import ontime.app.okhttp.AppConstant;
import ontime.app.restaurant.adapte.DItemadapter;
import ontime.app.R;
import ontime.app.restaurant.model.readerOrder.ReaderData;
import ontime.app.restaurant.model.readerOrder.ReaderExample;
import ontime.app.restaurant.ui.fragment.CancelledFragment;
import ontime.app.restaurant.ui.fragment.CompletedFragment;
import ontime.app.restaurant.ui.fragment.NewOrderFragment;
import ontime.app.restaurant.ui.fragment.ProcessingFragment;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;
import ontime.app.utils.SessionManager;
import com.google.gson.Gson;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

public class RiderOrderDetails extends BaseActivity implements DiscreteScrollView.ScrollStateChangeListener<DItemadapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<DItemadapter.ViewHolder>, APIcall.ApiCallListner {
    String[] strings = new String[]{"New order","Processing","Cancelled","Completed"};
    List<Integer> intTotal = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    SessionManager sessionManager;
    private ProgressDialog dialog;
    public static RActivityRiderorderdetailsBinding binding;
    public static ReaderData mreaderData;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.r_activity_riderorderdetails);
    }
    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GetAPICallRiderOrderDetails();
        sessionManager = new SessionManager(RiderOrderDetails.this);

        binding.txtSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutUser();
                Intent intent = new Intent(RiderOrderDetails.this, WelcomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        binding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RiderOrderDetails.this, MurchanNotification.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onCurrentItemChanged(@Nullable DItemadapter.ViewHolder holder, int position) {
        if (holder != null) {
            callFragment(position);
        }
    }

    @Override
    public void onScrollStart(@NonNull DItemadapter.ViewHolder holder, int position) {
    }

    @Override
    public void onScroll(
            float currentPosition,
            int currentIndex, int newIndex,
            @Nullable DItemadapter.ViewHolder currentHolder,
            @Nullable DItemadapter.ViewHolder newCurrent) {
        RecyclerView.Adapter<?> adapter = binding.picker.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (currentHolder != null && newCurrent != null) {
            float position = Math.abs(currentPosition);
            currentHolder.setOverlayColor(getApplicationContext().getResources().getDrawable(R.drawable.r_light_circle));
            newCurrent.setOverlayColor(getApplicationContext().getResources().getDrawable(R.drawable.r_circle));
        }
    }

    @Override
    public void onScrollEnd(@NonNull DItemadapter.ViewHolder holder, int position) {

    }


    public void callFragment(int position) {
        try {
            switch (position) {
                case 0:
                    NewOrderFragment newOrderFragment = new NewOrderFragment();
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_frame, newOrderFragment).commit();
                    break;
                case 1:
                    ProcessingFragment processingFragment = new ProcessingFragment();
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_frame, processingFragment).commit();
                    break;
                case 2:
                    CancelledFragment cancelledFragment = new CancelledFragment();
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_frame, cancelledFragment).commit();
                    break;
                case 3:
                    CompletedFragment completedFragment = new CompletedFragment();
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.fragment_frame, completedFragment).commit();
                    break;
            }

        } catch (Exception e) {

        }

    }

    private void showDialog() {
        dialog = new ProgressDialog(RiderOrderDetails.this);
        dialog.setMessage(getResources().getString(R.string.Please_wait));
        dialog.setCancelable(false);
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    private void GetAPICallRiderOrderDetails() {
        Common.hideKeyboard(getActivity());
        String url = AppConstant.GET_READER_ORDERDETAIL;
        APIcall apIcall = new APIcall(getApplicationContext());
        apIcall.isPost(false);
        apIcall.execute(url, APIcall.OPERATION_READER_ORDERLIST, this);
    }

    @Override
    public void onStartLoading(int operationCode) {
        if (operationCode == APIcall.OPERATION_READER_ORDERLIST) {
            showDialog();
        }

    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {
        try {
            if (operationCode == APIcall.OPERATION_READER_ORDERLIST) {
                hideDialog();
                Gson gson = new Gson();
                ReaderExample exampleUser = gson.fromJson(response, ReaderExample.class);
                if (exampleUser.getResponceData() != null) {
                    mreaderData = exampleUser.getResponceData();
                    intTotal.clear();
                    intTotal.add(mreaderData.getOrders().getNewOrder().size());
                    intTotal.add(mreaderData.getOrders().getProccessing().size());
                    intTotal.add(mreaderData.getOrders().getCancel().size());
                    intTotal.add(mreaderData.getOrders().getCompleted().size());
                    binding.picker.setSlideOnFling(true);
                    binding.picker.setAdapter(new DItemadapter(this, strings,intTotal));
                    binding.picker.addOnItemChangedListener(this);
                    binding.picker.addScrollStateChangeListener(this);
                    binding.picker.scrollToPosition(0);
                    binding.picker.setItemTransitionTimeMillis(549);
                    binding.picker.setItemTransformer(new ScaleTransformer.Builder()
                            .setMinScale(0.8f)
                            .build());
                } else {
                    Toast.makeText(RiderOrderDetails.this, "" + exampleUser.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            hideDialog();
        } catch (Exception e) {

        }

    }

    @Override
    public void onFail(int operationCode, String response) {

    }

}