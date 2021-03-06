// Generated by data binding compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;
import ontime.app.R;

public abstract class ActivityRestRattingListBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivBackArrow;

  @NonNull
  public final CircleImageView ivRestProfileImg;

  @NonNull
  public final LinearLayout llBack;

  @NonNull
  public final RelativeLayout llBar;

  @NonNull
  public final RatingBar rbRatingbar;

  @NonNull
  public final RecyclerView rvFilterList;

  @NonNull
  public final TextView txtCount;

  @NonNull
  public final TextView txtNoItem;

  @NonNull
  public final TextView txtResBarnchname;

  @NonNull
  public final TextView txtResName;

  @NonNull
  public final TextView txtTitle;

  protected ActivityRestRattingListBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView ivBackArrow, CircleImageView ivRestProfileImg,
      LinearLayout llBack, RelativeLayout llBar, RatingBar rbRatingbar, RecyclerView rvFilterList,
      TextView txtCount, TextView txtNoItem, TextView txtResBarnchname, TextView txtResName,
      TextView txtTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivBackArrow = ivBackArrow;
    this.ivRestProfileImg = ivRestProfileImg;
    this.llBack = llBack;
    this.llBar = llBar;
    this.rbRatingbar = rbRatingbar;
    this.rvFilterList = rvFilterList;
    this.txtCount = txtCount;
    this.txtNoItem = txtNoItem;
    this.txtResBarnchname = txtResBarnchname;
    this.txtResName = txtResName;
    this.txtTitle = txtTitle;
  }

  @NonNull
  public static ActivityRestRattingListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_rest_ratting_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRestRattingListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRestRattingListBinding>inflateInternal(inflater, R.layout.activity_rest_ratting_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRestRattingListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_rest_ratting_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRestRattingListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRestRattingListBinding>inflateInternal(inflater, R.layout.activity_rest_ratting_list, null, false, component);
  }

  public static ActivityRestRattingListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityRestRattingListBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityRestRattingListBinding)bind(component, view, R.layout.activity_rest_ratting_list);
  }
}
