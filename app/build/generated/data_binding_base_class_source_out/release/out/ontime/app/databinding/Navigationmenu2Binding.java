// Generated by view binder compiler. Do not edit!
package ontime.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ontime.app.R;

public final class Navigationmenu2Binding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final ImageView AuthorAvatar;

  @NonNull
  public final TextView AuthorDisplayName;

  @NonNull
  public final TextView AuthorUserName;

  @NonNull
  public final LinearLayout back;

  @NonNull
  public final ImageView close;

  @NonNull
  public final LinearLayout llabout;

  @NonNull
  public final LinearLayout llangages;

  @NonNull
  public final LinearLayout llcart;

  @NonNull
  public final LinearLayout llcontact;

  @NonNull
  public final LinearLayout llhome;

  @NonNull
  public final LinearLayout llmyorder;

  @NonNull
  public final LinearLayout llnotifi;

  @NonNull
  public final LinearLayout llpaymet;

  @NonNull
  public final LinearLayout llprofile;

  @NonNull
  public final RelativeLayout rly;

  @NonNull
  public final LinearLayout svLeftHeader;

  private Navigationmenu2Binding(@NonNull LinearLayoutCompat rootView,
      @NonNull ImageView AuthorAvatar, @NonNull TextView AuthorDisplayName,
      @NonNull TextView AuthorUserName, @NonNull LinearLayout back, @NonNull ImageView close,
      @NonNull LinearLayout llabout, @NonNull LinearLayout llangages, @NonNull LinearLayout llcart,
      @NonNull LinearLayout llcontact, @NonNull LinearLayout llhome,
      @NonNull LinearLayout llmyorder, @NonNull LinearLayout llnotifi,
      @NonNull LinearLayout llpaymet, @NonNull LinearLayout llprofile, @NonNull RelativeLayout rly,
      @NonNull LinearLayout svLeftHeader) {
    this.rootView = rootView;
    this.AuthorAvatar = AuthorAvatar;
    this.AuthorDisplayName = AuthorDisplayName;
    this.AuthorUserName = AuthorUserName;
    this.back = back;
    this.close = close;
    this.llabout = llabout;
    this.llangages = llangages;
    this.llcart = llcart;
    this.llcontact = llcontact;
    this.llhome = llhome;
    this.llmyorder = llmyorder;
    this.llnotifi = llnotifi;
    this.llpaymet = llpaymet;
    this.llprofile = llprofile;
    this.rly = rly;
    this.svLeftHeader = svLeftHeader;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static Navigationmenu2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Navigationmenu2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.navigationmenu2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Navigationmenu2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Author_Avatar;
      ImageView AuthorAvatar = rootView.findViewById(id);
      if (AuthorAvatar == null) {
        break missingId;
      }

      id = R.id.Author_DisplayName;
      TextView AuthorDisplayName = rootView.findViewById(id);
      if (AuthorDisplayName == null) {
        break missingId;
      }

      id = R.id.Author_UserName;
      TextView AuthorUserName = rootView.findViewById(id);
      if (AuthorUserName == null) {
        break missingId;
      }

      id = R.id.back;
      LinearLayout back = rootView.findViewById(id);
      if (back == null) {
        break missingId;
      }

      id = R.id.close;
      ImageView close = rootView.findViewById(id);
      if (close == null) {
        break missingId;
      }

      id = R.id.llabout;
      LinearLayout llabout = rootView.findViewById(id);
      if (llabout == null) {
        break missingId;
      }

      id = R.id.llangages;
      LinearLayout llangages = rootView.findViewById(id);
      if (llangages == null) {
        break missingId;
      }

      id = R.id.llcart;
      LinearLayout llcart = rootView.findViewById(id);
      if (llcart == null) {
        break missingId;
      }

      id = R.id.llcontact;
      LinearLayout llcontact = rootView.findViewById(id);
      if (llcontact == null) {
        break missingId;
      }

      id = R.id.llhome;
      LinearLayout llhome = rootView.findViewById(id);
      if (llhome == null) {
        break missingId;
      }

      id = R.id.llmyorder;
      LinearLayout llmyorder = rootView.findViewById(id);
      if (llmyorder == null) {
        break missingId;
      }

      id = R.id.llnotifi;
      LinearLayout llnotifi = rootView.findViewById(id);
      if (llnotifi == null) {
        break missingId;
      }

      id = R.id.llpaymet;
      LinearLayout llpaymet = rootView.findViewById(id);
      if (llpaymet == null) {
        break missingId;
      }

      id = R.id.llprofile;
      LinearLayout llprofile = rootView.findViewById(id);
      if (llprofile == null) {
        break missingId;
      }

      id = R.id.rly;
      RelativeLayout rly = rootView.findViewById(id);
      if (rly == null) {
        break missingId;
      }

      id = R.id.sv_left_header;
      LinearLayout svLeftHeader = rootView.findViewById(id);
      if (svLeftHeader == null) {
        break missingId;
      }

      return new Navigationmenu2Binding((LinearLayoutCompat) rootView, AuthorAvatar,
          AuthorDisplayName, AuthorUserName, back, close, llabout, llangages, llcart, llcontact,
          llhome, llmyorder, llnotifi, llpaymet, llprofile, rly, svLeftHeader);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
