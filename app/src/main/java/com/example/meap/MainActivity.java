package com.example.meap;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.meap.adapter.MainPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setSubtitle(getConnectionLabel());
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_voice_call) {
                UiUtils.toast(this, "Voice call option selected");
                return true;
            } else if (item.getItemId() == R.id.action_video_call) {
                UiUtils.toast(this, "Video call option selected");
                return true;
            }
            return false;
        });

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(MainPagerAdapter.getPageTitle(position)))
                .attach();
    }

    private String getConnectionLabel() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return "Using mobile data / Wi-Fi";
        NetworkCapabilities caps = cm.getNetworkCapabilities(cm.getActiveNetwork());
        if (caps == null) return "Offline";
        if (caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) return "Using Mobile Data";
        if (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) return "Using Wi-Fi";
        return "Connected";
    }
}
