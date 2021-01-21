package ontime.app.customer.doneActivity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import ontime.app.R;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;

public class AddCardActivity extends BaseActivity implements View.OnClickListener {

//    ActivityAddcartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
    }

    @Override
    protected void initView() {
//        binding = DataBindingUtil.setContentView(this, R.layout.pop_add_card);
    }

    @Override
    protected void setListener() {
        super.setListener();
//        binding.back.setOnClickListener(this);
//        binding.btAddNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.back:
//                onBackPressed();
//                break;
//            case R.id.bt_add_now:
//                onBackPressed();
//                break;
//
//        }
    }

}