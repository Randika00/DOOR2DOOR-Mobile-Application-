// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.example.foodapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdddataBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final Button addBack;

  @NonNull
  public final EditText addDiscription;

  @NonNull
  public final EditText addName;

  @NonNull
  public final EditText addPrice;

  @NonNull
  public final EditText addPurl;

  @NonNull
  public final Button addSubmit;

  private ActivityAdddataBinding(@NonNull LinearLayoutCompat rootView, @NonNull Button addBack,
      @NonNull EditText addDiscription, @NonNull EditText addName, @NonNull EditText addPrice,
      @NonNull EditText addPurl, @NonNull Button addSubmit) {
    this.rootView = rootView;
    this.addBack = addBack;
    this.addDiscription = addDiscription;
    this.addName = addName;
    this.addPrice = addPrice;
    this.addPurl = addPurl;
    this.addSubmit = addSubmit;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdddataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdddataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_adddata, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdddataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_back;
      Button addBack = rootView.findViewById(id);
      if (addBack == null) {
        break missingId;
      }

      id = R.id.add_discription;
      EditText addDiscription = rootView.findViewById(id);
      if (addDiscription == null) {
        break missingId;
      }

      id = R.id.add_name;
      EditText addName = rootView.findViewById(id);
      if (addName == null) {
        break missingId;
      }

      id = R.id.add_price;
      EditText addPrice = rootView.findViewById(id);
      if (addPrice == null) {
        break missingId;
      }

      id = R.id.add_purl;
      EditText addPurl = rootView.findViewById(id);
      if (addPurl == null) {
        break missingId;
      }

      id = R.id.add_submit;
      Button addSubmit = rootView.findViewById(id);
      if (addSubmit == null) {
        break missingId;
      }

      return new ActivityAdddataBinding((LinearLayoutCompat) rootView, addBack, addDiscription,
          addName, addPrice, addPurl, addSubmit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
