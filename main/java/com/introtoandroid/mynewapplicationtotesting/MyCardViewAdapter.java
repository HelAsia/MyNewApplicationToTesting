package com.introtoandroid.mynewapplicationtotesting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by Asia on 2018-05-05.
 */

public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder> {
  private static final String DEBUG_TAG = "MyCardViewAdapter";

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

  public void addCard(String animal, Bitmap photo) {
    MyOneCard card = new MyOneCard();
    card.setAnimal(animal);
    card.setPhotoResource(photo);
    card.setId(getItemCount());
    cardsList.add(card);
    ((MyCardViewActivity) context).doSmoothScroll(getItemCount());
    notifyItemInserted(getItemCount());
  }

  public void updateCard(String animal, int list_position) {
    cardsList.get(list_position).setAnimal(animal);
    Log.d(DEBUG_TAG, "list_position ma wartość " + list_position);
    notifyItemChanged(list_position);
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  public void deleteCard(View view, int list_position) {
    animateCircularDelete(view, list_position);
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

      itemView.setOnClickListener(new View.OnClickListener(){

        @RequiresApi(api = VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v) {
          Pair<View, String> p1 = Pair.create((View) photo, MyCardViewActivity.TRANSITION_INITIAL);
          Pair<View, String> p2 = Pair.create((View) animal, MyCardViewActivity.TRANSITION_ANIMAL);
          Pair<View, String> p3 = Pair.create((View) deleteButton, MyCardViewActivity.TRANSITION_DELETE_BUTTON);

          ActivityOptionsCompat options;
          Activity act = (AppCompatActivity) context;
          options = ActivityOptionsCompat.makeSceneTransitionAnimation(act, p1, p2, p3);

          int requestCode = getAdapterPosition();
          String animal = cardsList.get(requestCode).getAnimal();
          /*Bitmap photo = cardsList.get(requestCode).getPhotoResource();*/
          Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.kawa);
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
          byte[] photo = baos.toByteArray();

          Log.d(DEBUG_TAG, "MyCardViewAdapter: obsługa kliknięcia elementu na pozycji w adapterze " + requestCode);

          Intent transitionIntent = new Intent(context, TransitionEditActivity.class);
          transitionIntent.putExtra(MyCardViewActivity.EXTRA_ANIMAL, animal);
          transitionIntent.putExtra(MyCardViewActivity.EXTRA_PHOTO, photo);
          transitionIntent.putExtra(MyCardViewActivity.EXTRA_UPDATE, false);
          transitionIntent.putExtra(MyCardViewActivity.EXTRA_DELETE, false);
          ((AppCompatActivity) context).startActivityForResult(transitionIntent, requestCode, options.toBundle());
        }
      });
    }
  }
}
