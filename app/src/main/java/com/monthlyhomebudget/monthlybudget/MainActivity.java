package com.monthlyhomebudget.monthlybudget;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    TextView toolbartitle;
    FragmentManager fragmentManager = getSupportFragmentManager();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbartitle = findViewById(R.id.toolbartitle);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView nvDrawer = findViewById(R.id.nav_view);
        setupDrawerContent(nvDrawer);


        ActionBarDrawerToggle t = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        t.setDrawerIndicatorEnabled(true);
        t.syncState();
        drawer.addDrawerListener(t);

//        MyDbHandler db = new MyDbHandler(MainActivity.this);
//        Contact op = new Contact();
//        op.setDate("1/4/2021");
//        op.setDescription("abc");
//        op.setAmount("5000");
//        op.setCatagory("food");
//        op.setEndofdaybalance("1000");
//
//        db.addContact(op);






        Home home = new Home();
        toolbartitle.setText("Home");
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,home).commit();
    }

    private void setupDrawerContent(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(
                menuItem -> {
                    selectDrawerItem(menuItem);
                    return true;
                });
    }

    @SuppressLint("NonConstantResourceId")
    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_about:
                gotoabout();
                break;

            case R.id.nav_checkmonthlyexpance:
                checkalldata();
                break;


            default:
                gotohome();
                break;

        }
        menuItem.setChecked(true);
        drawer.closeDrawer(GravityCompat.START, true);
    }

    @SuppressLint("SetTextI18n")
    private void checkalldata() {
        Alldata articals = new Alldata();
        toolbartitle.setText("Detailed Report");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, articals).addToBackStack(null).commit();

    }

    @SuppressLint("SetTextI18n")
    private void gotoabout() {
        About about = new About();
        toolbartitle.setText("About");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, about).addToBackStack(null).commit();

    }

    @SuppressLint("SetTextI18n")
    private void gotohome() {
        toolbartitle.setText("Home");
        Home home = new Home();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, home).commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void nav_toggle_clicked(View view) {
        drawer.openDrawer(GravityCompat.START, true);
    }

    public void viewMore(View view) {
        Alldata alldata = new Alldata();
        toolbartitle.setText("Detailed Report");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, alldata).commit();
    }
}