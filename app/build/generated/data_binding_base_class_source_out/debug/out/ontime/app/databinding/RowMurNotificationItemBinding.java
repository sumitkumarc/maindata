// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class RowMurNotificationItemBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView txtDetails;

  @NonNull
  public final TextView txtTitle;

  private RowMurNotificationItemBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView txtDetails, @NonNull TextView txtTitle) {
    this.rootView = rootView;
    this.txtDetails = txtDetails;
    this.txtTitle = txtTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RowMurNotificationItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowMurNotificationItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_mur_notification_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowMurNotificationItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.txt_details;
      TextView txtDetails = rootView.findViewById(id);
      if (txtDetails == null) {
        break missingId;
      }

      id = R.id.txt_title;
      TextView txtTitle = rootView.findViewById(id);
      if (txtTitle == null) {
        break missingId;
      }

      return new RowMurNotificationItemBinding((RelativeLayout) rootView, txtDetails, txtTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
