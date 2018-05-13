package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        context = getApplicationContext();

        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = ( DrawerLayout ) findViewById(R.id.drawer_layout);

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
        NavigationView navigationView = ( NavigationView ) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                      menuItem.setChecked(true);
                      mDrawerLayout.closeDrawers();
                      int id = menuItem.getItemId();

                      if (id == R.id.nav_animation_activity){
                          Intent intent = new Intent(context, AnimationActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_equation_activity) {
                          Intent intent = new Intent(context, EquationActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_fragments_activity) {
                          Intent intent = new Intent(context, FragmentActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_fragment_swipe_activity) {
                          Intent intent = new Intent(context, SwipeActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_fragment_toolbsr_activity) {
                          Intent intent = new Intent(context, ExampleActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_buttons_activity) {
                          Intent intent = new Intent(context, ButtonsActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_collection_activity) {
                          Intent intent = new Intent(context, CollectionActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_dynamic_fragment_activity) {
                          Intent intent = new Intent(context, DynamicFragmActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_pager_activity) {
                          Intent intent = new Intent(context, PagerActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_listview_activity) {
                          Intent intent = new Intent(context, MyChooseActivity.class);
                          startActivity(intent);
                      }else if (id == R.id.nav_menu_example_activity) {
                        Intent intent = new Intent(context, MenuExampleActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_default_activity) {
                        Intent intent = new Intent(context, DefaultActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_material_design_activity) {
                        Intent intent = new Intent(context, SampleMaterialActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_my_card_view_activity) {
                        Intent intent = new Intent(context, MyCardViewActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_simple_preferences_activity) {
                        Intent intent = new Intent(context, SimplePreferencesActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_simple_user_preferences_activity) {
                        Intent intent = new Intent(context, SimpleUserPrefsActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_simple_header_preferences_activity) {
                        Intent intent = new Intent(context, UserPrefsHeadersActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_simple_files_activity) {
                        Intent intent = new Intent(context, SimpleFilesActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_advanced_files_activity) {
                        Intent intent = new Intent(context,
                            FileStreamOfConsciousnessActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_content_providers_activity) {
                        Intent intent = new Intent(context, SimpleContentProviderActivity.class);
                        startActivity(intent);
                      }else if (id == R.id.nav_content_providers_image_activity) {
                        Intent intent = new Intent(context, SimpleImageContentProviderActivity.class);
                        startActivity(intent);
                      }

                      return false;
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
