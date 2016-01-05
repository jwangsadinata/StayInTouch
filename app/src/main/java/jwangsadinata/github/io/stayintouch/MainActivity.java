package jwangsadinata.github.io.stayintouch;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import jwangsadinata.github.io.stayintouch.adapter.PeopleViewPagerAdapter;
import jwangsadinata.github.io.stayintouch.dialog.AboutDialog;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private CoordinatorLayout layoutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_list_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        layoutContent = (CoordinatorLayout) findViewById(
                R.id.layoutContent);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_item_search:
                                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_about:
                                showAboutDialog();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_help:
                                showSnackBarMessage(getString(R.string.txt_help));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_website:
                                openWebsite(getString(R.string.ait_website));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_moodle:
                                openWebsite(getString(R.string.ait_moodle));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_youtube:
                                openYoutube(getString(R.string.youtube_ait));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.navigation_item_facebook:
                                openFacebook(getString(R.string.facebook_ait));
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            default:
                                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                                return true;
                        }

                        return false;
                    }
                });

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(toSearch);
            }
        });

        PeopleViewPagerAdapter adapter = new PeopleViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_search:
                Intent toSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(toSearch);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
        AboutDialog dialog = new AboutDialog();
        dialog.show(getSupportFragmentManager(), AboutDialog.TAG);
    }

    private void showSnackBarMessage(String message) {
        Snackbar.make(layoutContent,
                message,
                Snackbar.LENGTH_LONG
        ).setAction(R.string.action_hide, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //...
            }
        }).show();
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void openYoutube(String url){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url));
            startActivity(intent);
        }catch (ActivityNotFoundException ex){
            Intent intent=new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v="+url));
            startActivity(intent);
        }
    }

    private void openFacebook(final String username) {
        try {
            Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + username));
            startActivity(followIntent);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + username));
                    startActivity(followIntent);
                }
            }, 1000 * 2);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + username)));
            String errorMessage = (e.getMessage() == null) ? "Message is empty" : e.getMessage();
            Log.e("FacebookAppNotFound", errorMessage);
        }
    }
}
