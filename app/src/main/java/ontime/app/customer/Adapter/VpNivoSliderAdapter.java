package ontime.app.customer.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import ontime.app.R;
import ontime.app.model.advertisements.AdvertisementDatum;

import java.util.List;

public class VpNivoSliderAdapter extends PagerAdapter {
    Context mContext;
    List<AdvertisementDatum> mnivoSliderLists;


    public VpNivoSliderAdapter(Context context, List<AdvertisementDatum> advertisementData) {
        this.mContext = context;
        this.mnivoSliderLists = advertisementData;
    }

    @Override
    public int getCount() {
        return mnivoSliderLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mview = inflater.inflate(R.layout.item_nivo_slider, null);
        ImageView iv_slider = mview.findViewById(R.id.iv_advertisements);
        Glide.with(mContext).load(mnivoSliderLists.get(position).getImage()).placeholder(R.mipmap.ic_launcher).into(iv_slider);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(mview, 0);
        return mview;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

}
