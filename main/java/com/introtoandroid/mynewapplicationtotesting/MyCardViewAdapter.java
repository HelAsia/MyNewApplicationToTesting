package com.introtoandroid.mynewapplicationtotesting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Asia on 2018-05-05.
 */

public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder> {
  public Context context;
  public ArrayList<MyOneCard> cardsList;

  public MyCardViewAdapter(Context context, ArrayList<MyOneCard> cardsList) {
    this.context = context;
    this.cardsList = cardsList;
  }

  @Override
  public MyCardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
    View v = li.inflate(R.layout.my_cardview_one_card, viewGroup, false);
    return new MyCardViewAdapter.ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int position) {
    String animal = cardsList.get(position).getAnimal();
    Bitmap photo = cardsList.get(position).getPhotoResource();
    ImageView photoImageView = viewHolder.photo;
    TextView animalTextView = viewHolder.animal;
    photoImageView.setImageBitmap(photo);
    animalTextView.setText(animal);
  }

  @Override
  public int getItemCount() {
    if (cardsList.isEmpty()) {
      return 0;
    } else {
      return cardsList.size();
    }
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  public void animateCircularReveal(View view) {
    int centerX = 0;
    int centerY = 0;
    int startRadius = 0;
    int endRadius = Math.max(view.getWidth(), view.getHeight());
    Animator animation = ViewAnimationUtils
        .createCircularReveal(view, centerX, centerY, startRadius, endRadius);
    view.setVisibility(View.VISIBLE);
    animation.start();
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  public void animateCircularDelete(final View view, final int list_position) {
    int centerX = view.getWidth();
    int centerY = view.getHeight();
    int startRadius = view.getWidth();
    int endRadius = 0;
    Animator animation = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);

    animation.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);

        view.setVisibility(View.INVISIBLE);
        cardsList.remove(list_position);
        notifyItemRemoved(list_position);
      }
    });
    animation.start();
  }

  @Override
  public void onViewDetachedFromWindow(MyCardViewAdapter.ViewHolder viewHolder) {
    super.onViewDetachedFromWindow(viewHolder);
    viewHolder.itemView.clearAnimation();
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  @Override
  public void onViewAttachedToWindow(MyCardViewAdapter.ViewHolder viewHolder) {
    super.onViewAttachedToWindow(viewHolder);
    animateCircularReveal(viewHolder.itemView);
  }

  @Override
  public long getItemId(int position) {
    return cardsList.get(position).getId();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView photo;
    private TextView animal;
    private Button deleteButton;

    public ViewHolder(View v) {
      super(v);
      photo = ( ImageView ) v.findViewById(R.id.photo_initial);
      animal = ( TextView ) v.findViewById(R.id.animal);
      deleteButton = (Button) v.findViewById(R.id.delete_button);

      deleteButton.setOnClickListener(new View.OnClickListener() {

        @RequiresApi(api = VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
          animateCircularDelete(itemView, getAdapterPosition());
        }
      });
    }
  }
}
