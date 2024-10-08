// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.foodapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RecyclerView recyclerMenu;

  private ContentHomeBinding(@NonNull RelativeLayout rootView, @NonNull RecyclerView recyclerMenu) {
    this.rootView = rootView;
    this.recyclerMenu = recyclerMenu;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycler_menu;
      RecyclerView recyclerMenu = rootView.findViewById(id);
      if (recyclerMenu == null) {
        break missingId;
      }

      return new ContentHomeBinding((RelativeLayout) rootView, recyclerMenu);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
