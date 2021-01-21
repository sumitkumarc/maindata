// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class CRowRestaurantItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final ImageView ivRestImg;

  @NonNull
  public final LinearLayout lllist;

  @NonNull
  public final RatingBar rbStar;

  @NonNull
  public final TextView txtAddress;

  @NonNull
  public final TextView txtName;

  private CRowRestaurantItemBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull ImageView ivRestImg, @NonNull LinearLayout lllist, @NonNull RatingBar rbStar,
      @NonNull TextView txtAddress, @NonNull TextView txtName) {
    this.rootView = rootView;
    this.ivRestImg = ivRestImg;
    this.lllist = lllist;
    this.rbStar = rbStar;
    this.txtAddress = txtAddress;
    this.txtName = txtName;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static CRowRestaurantItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CRowRestaurantItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.c_row_restaurant_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CRowRestaurantItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_rest_img;
      ImageView ivRestImg = rootView.findViewById(id);
      if (ivRestImg == null) {
        break missingId;
      }

      id = R.id.lllist;
      LinearLayout lllist = rootView.findViewById(id);
      if (lllist == null) {
        break missingId;
      }

      id = R.id.rb_star;
      RatingBar rbStar = rootView.findViewById(id);
      if (rbStar == null) {
        break missingId;
      }

      id = R.id.txt_address;
      TextView txtAddress = rootView.findViewById(id);
      if (txtAddress == null) {
        break missingId;
      }

      id = R.id.txt_name;
      TextView txtName = rootView.findViewById(id);
      if (txtName == null) {
        break missingId;
      }

      return new CRowRestaurantItemBinding((LinearLayoutCompat) rootView, ivRestImg, lllist, rbStar,
          txtAddress, txtName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
