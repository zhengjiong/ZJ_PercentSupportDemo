package com.zj.example.zj_perentsupportlib;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * create by zhengjiong
 * Date: 2015-07-02
 * Time: 08:14
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @ViewById(R.id.drawerlayout)
    DrawerLayout mDrawerLayout;

    @ViewById(R.id.placeholder)
    FrameLayout mFrameLayout;

    @ViewById(R.id.navigationview)
    NavigationView mNavigationView;

    @AfterViews
    public void afterView(){
        initToolbar();
        initDrawerLayout();
        initNavigation();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeholder, DemoFragment.newInstance(R.layout.demo1_layout), "0")
                .commit();
    }

    private void initNavigation() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        selectItem(DemoFragment.newInstance(R.layout.demo1_layout));
                        break;
                    case R.id.item2:
                        selectItem(DemoFragment.newInstance(R.layout.demo2_layout));
                        break;
                    case R.id.item3:
                        selectItem(DemoFragment.newInstance(R.layout.demo3_layout));
                        break;
                    case R.id.item4:
                        selectItem(DemoFragment.newInstance(R.layout.demo4_layout));
                        break;
                    case R.id.item5:
                        selectItem(DemoFragment.newInstance(R.layout.demo5_layout));
                        break;
                    default:
                        return false;
                }
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void initDrawerLayout() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void initToolbar() {
        mToolbar.setTitle("PerentSupportDemo");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void selectItem(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeholder, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
