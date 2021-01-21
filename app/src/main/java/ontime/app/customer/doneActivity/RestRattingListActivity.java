package ontime.app.customer.doneActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import ontime.app.R;
import ontime.app.databinding.ActivityRestRattingListBinding;
import ontime.app.okhttp.APIcall;
import ontime.app.utils.BaseActivity;

public class RestRattingListActivity extends BaseActivity implements View.OnClickListener, APIcall.ApiCallListner {
ActivityRestRattingListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_ratting_list);
    }

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rest_ratting_list);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStartLoading(int operationCode) {

    }

    @Override
    public void onProgress(int operationCode, int progress) {

    }

    @Override
    public void onSuccess(int operationCode, String response, Object customData) {

    }

    @Override
    public void onFail(int operationCode, String response) {

    }
}