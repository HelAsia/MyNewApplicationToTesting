package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

public class VeggieGardenWebViewFragment extends WebViewFragment {

  private static final String DEBUG_TAG = "VGWebViewFragment";

  public static VeggieGardenWebViewFragment newInstance(int index) {
    Log.v(DEBUG_TAG, "Creating a new instance: " + index);
    VeggieGardenWebViewFragment fragment = new VeggieGardenWebViewFragment();

    Bundle args = new Bundle();
    args.putInt("index", index);
    fragment.setArguments(args);
    return fragment;
  }

  public int getShownIndex() {
    int index = -1;
    Bundle args = getArguments();
    if (args != null) {
      index = args.getInt("index", -1);
    }
    if (index == -1) {
      Log.e(DEBUG_TAG, "Lack of this index in the table");
    }
    return index;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onActivityCreated(): " + getShownIndex());
    super.onActivityCreated(savedInstanceState);

    // Wczytujemy stronę używając adresu URL po utworzeniu kontrolki
    // WebView w metodzie onCreateView().
    String[] veggieUrls;
    veggieUrls = getResources().getStringArray(
        R.array.veggieurls_array);
    int veggieUrlIndex = getShownIndex();

    WebView webview = getWebView();
    webview.setPadding(0, 0, 0, 0);
    webview.getSettings().setLoadWithOverviewMode(true);
    webview.getSettings().setUseWideViewPort(true);

    if (veggieUrlIndex != -1) {
      String veggieUrl = veggieUrls[veggieUrlIndex];
      webview.loadUrl(veggieUrl);
    } else {
      webview.loadUrl("http://andys-veggie-garden.appspot.com/cherrytomatoes");
    }
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onCreate() ");
    super.onCreate(savedInstanceState);
    Log.d(DEBUG_TAG, "OnCreate(): " + getShownIndex());
  }

  @Override
  public void onAttach(Activity activity) {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onAttach()");
    super.onAttach(activity);
  }

  @Override
  public void onStart() {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onStart(): " + getShownIndex());
    super.onStart();
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onResume():" +  getShownIndex());
  }

  @Override
  public void onDetach() {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onDetach()");
    super.onDetach();
  }

  @Override
  public void onPause() {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onPause(): " + getShownIndex());
    super.onPause();
  }

  @Override
  public void onStop() {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onStop(): " + getShownIndex());
    super.onStop();
  }

  @Override
  public void onDestroy() {
    Log.d(DEBUG_TAG, "ZDARZENIE CYKLU ŻYCIA FRAGMENTU: onDestroy()");
    super.onDestroy();
  }
}
