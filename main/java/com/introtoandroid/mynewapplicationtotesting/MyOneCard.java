package com.introtoandroid.mynewapplicationtotesting;

import android.graphics.Bitmap;

/**
 * Created by Asia on 2018-05-05.
 */

public class MyOneCard {
  private long id;
  private String animal;
  private Bitmap photoResource;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAnimal() {
    return animal;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }

  public Bitmap getPhotoResource() {
    return photoResource;
  }

  public void setPhotoResource(Bitmap photoResource) {
    this.photoResource = photoResource;
  }

}
