// Generated by view binder compiler. Do not edit!
package com.example.paises.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.paises.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PaisListViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardViewItem;

  @NonNull
  public final ImageButton closeBtn;

  @NonNull
  public final ImageView continentView;

  @NonNull
  public final TextView txtContiente;

  @NonNull
  public final TextView txtPais;

  private PaisListViewBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardViewItem,
      @NonNull ImageButton closeBtn, @NonNull ImageView continentView,
      @NonNull TextView txtContiente, @NonNull TextView txtPais) {
    this.rootView = rootView;
    this.cardViewItem = cardViewItem;
    this.closeBtn = closeBtn;
    this.continentView = continentView;
    this.txtContiente = txtContiente;
    this.txtPais = txtPais;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PaisListViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PaisListViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pais_list_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PaisListViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardViewItem;
      CardView cardViewItem = ViewBindings.findChildViewById(rootView, id);
      if (cardViewItem == null) {
        break missingId;
      }

      id = R.id.closeBtn;
      ImageButton closeBtn = ViewBindings.findChildViewById(rootView, id);
      if (closeBtn == null) {
        break missingId;
      }

      id = R.id.continentView;
      ImageView continentView = ViewBindings.findChildViewById(rootView, id);
      if (continentView == null) {
        break missingId;
      }

      id = R.id.txtContiente;
      TextView txtContiente = ViewBindings.findChildViewById(rootView, id);
      if (txtContiente == null) {
        break missingId;
      }

      id = R.id.txtPais;
      TextView txtPais = ViewBindings.findChildViewById(rootView, id);
      if (txtPais == null) {
        break missingId;
      }

      return new PaisListViewBinding((ConstraintLayout) rootView, cardViewItem, closeBtn,
          continentView, txtContiente, txtPais);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}