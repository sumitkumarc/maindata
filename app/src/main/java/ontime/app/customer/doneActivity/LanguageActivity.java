package ontime.app.customer.doneActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import ontime.app.R;
import ontime.app.databinding.ActivityLanguageBinding;
import ontime.app.utils.BaseActivity;
import ontime.app.utils.Common;
import ontime.app.utils.LanguageManager;

import java.util.Locale;

public class LanguageActivity extends BaseActivity implements View.OnClickListener {

    ActivityLanguageBinding binding;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = getResources().getConfiguration().locale;
        }
        if (Common.MERCHANT_TYPE == 1) {
            Common.setSystemBarColor(this, R.color.colorAccent);
            Common.setSystemBarLight(this);
            binding.txtArbic.setTextColor(getResources().getColor(R.color.colorAccent));

            if (locale.getLanguage().equals(LanguageManager.LANGUAGE_KEY_ARABIC)) {
                binding.txtArbic.setTextColor(getResources().getColor(R.color.super_mart));
                binding.txtEnglish.setTextColor(getResources().getColor(R.color.black));
            } else {
                binding.txtArbic.setTextColor(getResources().getColor(R.color.black));
                binding.txtEnglish.setTextColor(getResources().getColor(R.color.super_mart));
            }

        } else {
            Common.setSystemBarColor(this, R.color.super_mart);
            Common.setSystemBarLight(this);
            binding.txtArbic.setTextColor(getResources().getColor(R.color.super_mart));
            binding.txtEnglish.setTextColor(getResources().getColor(R.color.super_mart));

            if (locale.getLanguage().equals(LanguageManager.LANGUAGE_KEY_ARABIC)) {
                binding.txtArbic.setTextColor(getResources().getColor(R.color.super_mart));
                binding.txtEnglish.setTextColor(getResources().getColor(R.color.black));
            } else {
                binding.txtArbic.setTextColor(getResources().getColor(R.color.black));
                binding.txtEnglish.setTextColor(getResources().getColor(R.color.super_mart));
            }
        }


    }

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language);
    }

    @Override
    protected void setListener() {
        super.setListener();
        binding.back.setOnClickListener(this);
        binding.txtArbic.setOnClickListener(this);
        binding.txtEnglish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.txt_arbic:
                LanguageManager.setNewLocale(this, LanguageManager.LANGUAGE_KEY_ARABIC);
                onBackPressed();
                finish();
                break;
            case R.id.txt_english:
                LanguageManager.setNewLocale(this, LanguageManager.LANGUAGE_KEY_ENGLISH);
                onBackPressed();
                finish();
                break;

        }
    }

}