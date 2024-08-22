// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.foodapp.R;
import com.rey.material.widget.CheckBox;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdminLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView forgetPasswordLink;

  @NonNull
  public final LinearLayout linearLayout1;

  @NonNull
  public final ImageView loginApplogo;

  @NonNull
  public final Button loginBtn;

  @NonNull
  public final EditText loginPasswordInput;

  @NonNull
  public final EditText loginPhoneNumberInput;

  @NonNull
  public final CheckBox rememberMeChkb;

  private AdminLoginBinding(@NonNull RelativeLayout rootView, @NonNull TextView forgetPasswordLink,
      @NonNull LinearLayout linearLayout1, @NonNull ImageView loginApplogo,
      @NonNull Button loginBtn, @NonNull EditText loginPasswordInput,
      @NonNull EditText loginPhoneNumberInput, @NonNull CheckBox rememberMeChkb) {
    this.rootView = rootView;
    this.forgetPasswordLink = forgetPasswordLink;
    this.linearLayout1 = linearLayout1;
    this.loginApplogo = loginApplogo;
    this.loginBtn = loginBtn;
    this.loginPasswordInput = loginPasswordInput;
    this.loginPhoneNumberInput = loginPhoneNumberInput;
    this.rememberMeChkb = rememberMeChkb;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdminLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdminLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.admin_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdminLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.forget_password_link;
      TextView forgetPasswordLink = rootView.findViewById(id);
      if (forgetPasswordLink == null) {
        break missingId;
      }

      id = R.id.linear_layout_1;
      LinearLayout linearLayout1 = rootView.findViewById(id);
      if (linearLayout1 == null) {
        break missingId;
      }

      id = R.id.login_applogo;
      ImageView loginApplogo = rootView.findViewById(id);
      if (loginApplogo == null) {
        break missingId;
      }

      id = R.id.login_btn;
      Button loginBtn = rootView.findViewById(id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.login_password_input;
      EditText loginPasswordInput = rootView.findViewById(id);
      if (loginPasswordInput == null) {
        break missingId;
      }

      id = R.id.login_phone_number_input;
      EditText loginPhoneNumberInput = rootView.findViewById(id);
      if (loginPhoneNumberInput == null) {
        break missingId;
      }

      id = R.id.remember_me_chkb;
      CheckBox rememberMeChkb = rootView.findViewById(id);
      if (rememberMeChkb == null) {
        break missingId;
      }

      return new AdminLoginBinding((RelativeLayout) rootView, forgetPasswordLink, linearLayout1,
          loginApplogo, loginBtn, loginPasswordInput, loginPhoneNumberInput, rememberMeChkb);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
