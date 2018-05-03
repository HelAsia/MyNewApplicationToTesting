package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v4.util.Pair;
import android.view.View;
import java.util.ArrayList;

public class SampleMaterialActivity extends AppCompatActivity {
  private static final String DEBUG_TAG = "AppCompatActivity";

  public static final String EXTRA_UPDATE = "update";
  public static final String EXTRA_DELETE = "delete";
  public static final String EXTRA_NAME = "name";
  public static final String EXTRA_COLOR = "color";
  public static final String EXTRA_INITIAL = "initial";

  public static final String TRANSITION_FAB = "fab_transition";
  public static final String TRANSITION_INITIAL = "initial_transition";
  public static final String TRANSITION_NAME = "name_transition";
  public static final String TRANSITION_DELETE_BUTTON = "delete_button_transition";

  private RecyclerView recyclerView;
  private SampleMaterialAdapter adapter;
  private ArrayList<Card> cardsList = new ArrayList<>();
  private int[] colors;
  private String[] names;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample_material);

    names = getResources().getStringArray(R.array.names_array);
    colors = getResources().getIntArray(R.array.initial_colors);

    initCards();

    if (adapter == null) {
      adapter = new SampleMaterialAdapter(this, cardsList);
    }
    recyclerView = ( RecyclerView ) findViewById(R.id.rectaler_view);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    FloatingActionButton fab = ( FloatingActionButton ) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Pair<View,String> pair = Pair.create(v.findViewById(R.id.fab), TRANSITION_FAB);

        ActivityOptionsCompat options;
        Activity act = SampleMaterialActivity.this;
        options = ActivityOptionsCompat.makeSceneTransitionAnimation(act, pair);

        Intent transitionIntent = new Intent(act, TransitionAddActivity.class);
        act.startActivityForResult(transitionIntent, adapter.getItemCount(), options.toBundle());
      }
    });
  }

  @Override
  protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    Log.d(DEBUG_TAG, "requestCode has value " + requestCode);

    if (requestCode == adapter.getItemCount()) {
      if (requestCode == RESULT_OK) {
        String name = data.getStringExtra(EXTRA_NAME);
        int color = data.getIntExtra(EXTRA_COLOR, 0);
        adapter.addCard(name, color);
      }
    }else {
      if (requestCode == RESULT_OK) {
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(requestCode);
        if (data.getExtras().getBoolean(EXTRA_DELETE, false)) {
          adapter.deleteCard(viewHolder.itemView, requestCode);
        }else if (data.getExtras().getBoolean(EXTRA_UPDATE)) {
          String name = data.getStringExtra(EXTRA_NAME);
          viewHolder.itemView.setVisibility(View.INVISIBLE);
          adapter.updateCard(name, requestCode);
        }
      }
    }
  }

  public void doSmoothScroll(int position) {
    recyclerView.smoothScrollToPosition(position);
  }

  private void initCards() {
    for (int i = 0; i < 50; i++) {
      Card card = new Card();
      card.setId((long) i);
      card.setName(names[i]);
      card.setColorResource(colors[i]);
      Log.d(DEBUG_TAG, "ID karty " + card.getId() + ", imię: " + card.getName() + ", kolor: " + card.getColorResource());
      cardsList.add(card);
    }
  }
}
