// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class PopAddAmountBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final AppCompatButton btAddNow;

  @NonNull
  public final ImageView btClose;

  @NonNull
  public final EditText edCardNumber;

  @NonNull
  public final LinearLayout rly;

  @NonNull
  public final TextView txtCardNumber;

  @NonNull
  public final AppCompatTextView txtTitle;

  private PopAddAmountBinding(@NonNull CardView rootView, @NonNull AppCompatButton btAddNow,
      @NonNull ImageView btClose, @NonNull EditText edCardNumber, @NonNull LinearLayout rly,
      @NonNull TextView txtCardNumber, @NonNull AppCompatTextView txtTitle) {
    this.rootView = rootView;
    this.btAddNow = btAddNow;
    this.btClose = btClose;
    this.edCardNumber = edCardNumber;
    this.rly = rly;
    this.txtCardNumber = txtCardNumber;
    this.txtTitle = txtTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static PopAddAmountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopAddAmountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pop_add_amount, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopAddAmountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_add_now;
      AppCompatButton btAddNow = rootView.findViewById(id);
      if (btAddNow == null) {
        break missingId;
      }

      id = R.id.bt_close;
      ImageView btClose = rootView.findViewById(id);
      if (btClose == null) {
        break missingId;
      }

      id = R.id.ed_card_number;
      EditText edCardNumber = rootView.findViewById(id);
      if (edCardNumber == null) {
        break missingId;
      }

      id = R.id.rly;
      LinearLayout rly = rootView.findViewById(id);
      if (rly == null) {
        break missingId;
      }

      id = R.id.txt_card_number;
      TextView txtCardNumber = rootView.findViewById(id);
      if (txtCardNumber == null) {
        break missingId;
      }

      id = R.id.txt_title;
      AppCompatTextView txtTitle = rootView.findViewById(id);
      if (txtTitle == null) {
        break missingId;
      }

      return new PopAddAmountBinding((CardView) rootView, btAddNow, btClose, edCardNumber, rly,
          txtCardNumber, txtTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
