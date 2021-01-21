// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class RActivityLoginBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final AppCompatButton loginBtn;

  @NonNull
  public final FrameLayout realitve;

  @NonNull
  public final AppCompatTextView txt;

  private RActivityLoginBinding(@NonNull FrameLayout rootView, @NonNull ImageView ivBack,
      @NonNull AppCompatButton loginBtn, @NonNull FrameLayout realitve,
      @NonNull AppCompatTextView txt) {
    this.rootView = rootView;
    this.ivBack = ivBack;
    this.loginBtn = loginBtn;
    this.realitve = realitve;
    this.txt = txt;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.r_activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_back;
      ImageView ivBack = rootView.findViewById(id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.login_btn;
      AppCompatButton loginBtn = rootView.findViewById(id);
      if (loginBtn == null) {
        break missingId;
      }

      FrameLayout realitve = (FrameLayout) rootView;

      id = R.id.txt;
      AppCompatTextView txt = rootView.findViewById(id);
      if (txt == null) {
        break missingId;
      }

      return new RActivityLoginBinding((FrameLayout) rootView, ivBack, loginBtn, realitve, txt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
