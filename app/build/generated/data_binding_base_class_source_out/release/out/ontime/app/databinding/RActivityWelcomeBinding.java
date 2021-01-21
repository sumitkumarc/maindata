// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class RActivityWelcomeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AppCompatButton btCreateAccount;

  @NonNull
  public final AppCompatImageView img;

  @NonNull
  public final AppCompatButton loginBtn;

  @NonNull
  public final LinearLayout transitionsContainer;

  @NonNull
  public final AppCompatTextView txt;

  private RActivityWelcomeBinding(@NonNull FrameLayout rootView,
      @NonNull AppCompatButton btCreateAccount, @NonNull AppCompatImageView img,
      @NonNull AppCompatButton loginBtn, @NonNull LinearLayout transitionsContainer,
      @NonNull AppCompatTextView txt) {
    this.rootView = rootView;
    this.btCreateAccount = btCreateAccount;
    this.img = img;
    this.loginBtn = loginBtn;
    this.transitionsContainer = transitionsContainer;
    this.txt = txt;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.r_activity_welcome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RActivityWelcomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_create_account;
      AppCompatButton btCreateAccount = rootView.findViewById(id);
      if (btCreateAccount == null) {
        break missingId;
      }

      id = R.id.img;
      AppCompatImageView img = rootView.findViewById(id);
      if (img == null) {
        break missingId;
      }

      id = R.id.login_btn;
      AppCompatButton loginBtn = rootView.findViewById(id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.transitions_container;
      LinearLayout transitionsContainer = rootView.findViewById(id);
      if (transitionsContainer == null) {
        break missingId;
      }

      id = R.id.txt;
      AppCompatTextView txt = rootView.findViewById(id);
      if (txt == null) {
        break missingId;
      }

      return new RActivityWelcomeBinding((FrameLayout) rootView, btCreateAccount, img, loginBtn,
          transitionsContainer, txt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
