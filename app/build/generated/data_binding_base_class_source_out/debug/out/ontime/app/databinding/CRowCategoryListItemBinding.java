// Generated by data binding compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import ontime.app.R;

public abstract class CRowCategoryListItemBinding extends ViewDataBinding {
  @NonNull
  public final CardView cdMainCard;

  @NonNull
  public final ImageView ivCatImag;

  @NonNull
  public final TextView txtCatName;

  protected CRowCategoryListItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cdMainCard, ImageView ivCatImag, TextView txtCatName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cdMainCard = cdMainCard;
    this.ivCatImag = ivCatImag;
    this.txtCatName = txtCatName;
  }

  @NonNull
  public static CRowCategoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.c_row_category_list_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CRowCategoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CRowCategoryListItemBinding>inflateInternal(inflater, R.layout.c_row_category_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static CRowCategoryListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.c_row_category_list_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CRowCategoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<CRowCategoryListItemBinding>inflateInternal(inflater, R.layout.c_row_category_list_item, null, false, component);
  }

  public static CRowCategoryListItemBinding bind(@NonNull View view) {
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
  public static CRowCategoryListItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (CRowCategoryListItemBinding)bind(component, view, R.layout.c_row_category_list_item);
  }
}