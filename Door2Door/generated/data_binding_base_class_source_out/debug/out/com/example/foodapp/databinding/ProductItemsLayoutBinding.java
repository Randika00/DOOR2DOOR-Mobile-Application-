// Generated by view binder compiler. Do not edit!
package com.example.foodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.foodapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProductItemsLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView productDescription;

  @NonNull
  public final ImageView productImage;

  @NonNull
  public final TextView productName;

  @NonNull
  public final TextView productPrice;

  private ProductItemsLayoutBinding(@NonNull CardView rootView,
      @NonNull TextView productDescription, @NonNull ImageView productImage,
      @NonNull TextView productName, @NonNull TextView productPrice) {
    this.rootView = rootView;
    this.productDescription = productDescription;
    this.productImage = productImage;
    this.productName = productName;
    this.productPrice = productPrice;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ProductItemsLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProductItemsLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.product_items_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProductItemsLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.product_description;
      TextView productDescription = rootView.findViewById(id);
      if (productDescription == null) {
        break missingId;
      }

      id = R.id.product_image;
      ImageView productImage = rootView.findViewById(id);
      if (productImage == null) {
        break missingId;
      }

      id = R.id.product_name;
      TextView productName = rootView.findViewById(id);
      if (productName == null) {
        break missingId;
      }

      id = R.id.product_price;
      TextView productPrice = rootView.findViewById(id);
      if (productPrice == null) {
        break missingId;
      }

      return new ProductItemsLayoutBinding((CardView) rootView, productDescription, productImage,
          productName, productPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
