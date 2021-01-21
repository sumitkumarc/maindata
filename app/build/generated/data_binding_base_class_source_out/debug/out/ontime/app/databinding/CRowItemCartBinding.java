// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class CRowItemCartBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final CircleImageView ivRestProfileImg;

  @NonNull
  public final LinearLayout llDeleteItem;

  @NonNull
  public final LinearLayout lllist;

  @NonNull
  public final TextView txtAddress;

  @NonNull
  public final TextView txtName;

  private CRowItemCartBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull CircleImageView ivRestProfileImg, @NonNull LinearLayout llDeleteItem,
      @NonNull LinearLayout lllist, @NonNull TextView txtAddress, @NonNull TextView txtName) {
    this.rootView = rootView;
    this.ivRestProfileImg = ivRestProfileImg;
    this.llDeleteItem = llDeleteItem;
    this.lllist = lllist;
    this.txtAddress = txtAddress;
    this.txtName = txtName;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static CRowItemCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CRowItemCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.c_row_item_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CRowItemCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_rest_profile_img;
      CircleImageView ivRestProfileImg = rootView.findViewById(id);
      if (ivRestProfileImg == null) {
        break missingId;
      }

      id = R.id.ll_delete_item;
      LinearLayout llDeleteItem = rootView.findViewById(id);
      if (llDeleteItem == null) {
        break missingId;
      }

      id = R.id.lllist;
      LinearLayout lllist = rootView.findViewById(id);
      if (lllist == null) {
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

      return new CRowItemCartBinding((LinearLayoutCompat) rootView, ivRestProfileImg, llDeleteItem,
          lllist, txtAddress, txtName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}