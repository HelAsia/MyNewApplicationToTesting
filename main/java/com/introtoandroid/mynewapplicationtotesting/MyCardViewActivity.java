package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MyCardViewActivity extends AppCompatActivity {
  private static final String DEBUG_TAG = "MyCardViewActivity";

  private RecyclerView recyclerView;
  private MyCardViewAdapter adapter;
  private ArrayList<MyOneCard> cardsList = new ArrayList<>();
  private TypedArray photos;
  private String[] animals;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_card_view);

    animals = getResources().getStringArray(R.array.animals_array);
    photos = getResources().obtainTypedArray(R.array.photo_list);

    initCards();

    if (adapter == null) {
      adapter = new MyCardViewAdapter(this, cardsList);
    }
    recyclerView = ( RecyclerView ) findViewById(R.id.my_recycler_view);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    FloatingActionButton fab = ( FloatingActionButton ) findViewById(R.id.my_fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @RequiresApi(api = VERSION_CODES.JELLY_BEAN)
      @Override
      public void onClick(View v) {
        Toast.makeText(MyCardViewActivity.this,
            "You will add something to this list in the future. ", Toast.LENGTH_SHORT).show();
      }
    });
  }

  public void doSmoothScroll(int position) {
    recyclerView.smoothScrollToPosition(position);
  }

  private void initCards() {
    for (int i = 0; i < 9; i++) {
      MyOneCard card = new MyOneCard();
      card.setId((long) i);
      card.setAnimal(animals[i]);
      card.setPhotoResource(BitmapFactory.decodeResource(getResources(), photos.getResourceId(i, -1)));
      Log.d(DEBUG_TAG, "Card's ID " + card.getId() + ", animal: " + card.getAnimal() + ", photo: " + card.getPhotoResource());
      cardsList.add(card);
    }
  }
}
