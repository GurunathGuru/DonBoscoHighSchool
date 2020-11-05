package com.integro.dbhs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.github.demono.AutoScrollViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.integro.dbhs.adapters.CoverPhotosAdapter;
import com.integro.dbhs.adapters.SlideAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.firebase.MyFirebaseMessagingService;
import com.integro.dbhs.model.CoverPhotos;
import com.integro.dbhs.model.CoverPhotosList;
import com.integro.dbhs.model.PrincipalMessage;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.integro.dbhs.firebase.MyFirebaseMessagingService.NEWS_KEY;
import static com.integro.dbhs.firebase.MyFirebaseMessagingService.NOTIFICATION_KEY;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getApplicationContext());
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SlideAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.news2);
        tabLayout.getTabAt(2).setIcon(R.drawable.notifications);
        //tabLayout.getTabAt(3).setIcon(R.drawable.call123);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorCream), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite), PorterDuff.Mode.SRC_IN);
            }
        });


        FirebaseMessaging.getInstance().subscribeToTopic("dbhs").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i(TAG, "onSuccess: Subscribed to topic");
            }
        });

        boolean isFCMIntent = getIntent().getBooleanExtra(MyFirebaseMessagingService.TAG, false);
        if (isFCMIntent) {
            String type = getIntent().getExtras().getString("type");

            switch (type) {
                case NEWS_KEY:
                    viewPager.setCurrentItem(1);
                    break;
                case NOTIFICATION_KEY:
                    viewPager.setCurrentItem(2);
                    break;
            }
        }
    }

    public void getE_Learning(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://e-learning.dbhspanjim.com/");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getUpcomingEvents(View view) {
        Intent intent = new Intent(getApplicationContext(), UpcomingEventsActivity.class);
        startActivity(intent);
    }

    public void getPrincipalMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), PrincipalMessageActivity.class);
        startActivity(intent);
    }

    public void getAnnouncements(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.com/announcement.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getYearPlanner(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.com/year_planner.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getRhapsody(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.dbhspanjim.edu.in/pdf/complied.pdf"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getKindergarten(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/kgsection/kgsection.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getAlumni(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.com/alumni.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void aboutUs(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/about.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void faculty(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/faculty.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void photos(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/gallery.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void videos(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/videos.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void address(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.edu.in/contact.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getSupportUs(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("URL", "http://www.dbhspanjim.com/support.php");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

