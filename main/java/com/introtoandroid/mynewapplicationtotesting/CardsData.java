package com.introtoandroid.mynewapplicationtotesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

/**
 * Created by Asia on 2018-05-10.
 */

public class CardsData {
  public static final String DEBUG_TAG = "CardsData";

  private SQLiteDatabase db;
  private SQLiteOpenHelper cardDbHelper;

  private static final String[] COLUMNS = {
      CardsDBHelper.COLUMN_ID,
      CardsDBHelper.COLUMN_NAME,
      CardsDBHelper.COLUMN_COLOR_RESOURCE
  };

  public CardsData(Context context) {
    this.cardDbHelper = new CardsDBHelper(context);
  }

  public void open() {
    db = cardDbHelper.getWritableDatabase();
    Log.d(DEBUG_TAG, "cardDbHelper - otworzono");
  }

  public void close() {
    if (cardDbHelper != null) {
      cardDbHelper.close();
      Log.d(DEBUG_TAG, "cardDbHelper zamknięto");
    }
  }

  public ArrayList<Card> getAll() {
    ArrayList<Card> cards = new ArrayList<>();
    Cursor cursor = null;
    try {
      cursor = db.query(CardsDBHelper.TABLE_CARDS, COLUMNS, null, null, null, null, null);
      if (cursor.getCount() > 0) {
        while (cursor.moveToNext()) {
          Card card = new Card();
          card.setId(cursor.getLong(cursor.getColumnIndex(CardsDBHelper.COLUMN_ID)));
          card.setName(cursor.getString(cursor.getColumnIndex(CardsDBHelper.COLUMN_NAME)));
          card.setColorResource(cursor.getInt(cursor.getColumnIndex(CardsDBHelper.COLUMN_COLOR_RESOURCE)));
          cards.add(card);
        }
      }
      Log.d(DEBUG_TAG, "Sumaryczna liczba wierszy = " + cursor.getCount());
    } catch (Exception e){
      Log.d(DEBUG_TAG, "Zgłoszono wyjątek o wartości " + e);
    } finally{
      if (cursor != null) {
        cursor.close();
      }
    }
    return cards;
  }

  public Card create(Card card) {
    ContentValues values = new ContentValues();
    values.put(CardsDBHelper.COLUMN_NAME, card.getName());
    values.put(CardsDBHelper.COLUMN_COLOR_RESOURCE, card.getColorResource());
    long id = db.insert(CardsDBHelper.TABLE_CARDS, null, values);
    card.setId(id);
    Log.d(DEBUG_TAG, "Identyfikator wstawionej karty to: " + String.valueOf(card.getId()));
    return card;
  }

  public void update(long position, String name) {
    String whereClause = CardsDBHelper.COLUMN_ID + "=" + position;
    Log.d(DEBUG_TAG, "Zaktualizowano kartę na pozycji " + String.valueOf(position));
    ContentValues values = new ContentValues();
    values.put(CardsDBHelper.COLUMN_NAME, name);
    db.update(CardsDBHelper.TABLE_CARDS, values, whereClause, null);
  }

  public void delete(long cardId) {
    String whereClause = CardsDBHelper.COLUMN_ID + "=" + cardId;
    Log.d(DEBUG_TAG, "Usunięto kartę na pozycji " + String.valueOf(cardId));
    db.delete(CardsDBHelper.TABLE_CARDS, whereClause, null);
  }
}
