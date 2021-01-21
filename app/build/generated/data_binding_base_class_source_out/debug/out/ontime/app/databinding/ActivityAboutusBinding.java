// Generated by data binding compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import ontime.app.R;

public abstract class ActivityAboutusBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout back;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final LinearLayout rly;

  @NonNull
  public final TextView txtAboutUs;

  @NonNull
  public final TextView txtTitle;

  protected ActivityAboutusBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout back, ImageView ivLogo, LinearLayout rly, TextView txtAboutUs,
      TextView txtTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.back = back;
    this.ivLogo = ivLogo;
    this.rly = rly;
    this.txtAboutUs = txtAboutUs;
    this.txtTitle = txtTitle;
  }

  @NonNull
  public static ActivityAboutusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_aboutus, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAboutusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAboutusBinding>inflateInternal(inflater, R.layout.activity_aboutus, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAboutusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_aboutus, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAboutusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAboutusBinding>inflateInternal(inflater, R.layout.activity_aboutus, null, false, component);
  }

  public static ActivityAboutusBinding bind(@NonNull View view) {
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
  public static ActivityAboutusBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAboutusBinding)bind(component, view, R.layout.activity_aboutus);
  }
}