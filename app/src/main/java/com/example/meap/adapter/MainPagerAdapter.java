package com.example.meap.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.meap.ui.AdminFragment;
import com.example.meap.ui.ChatFragment;
import com.example.meap.ui.EventsFragment;
import com.example.meap.ui.LoginFragment;
import com.example.meap.ui.MembersFragment;
import com.example.meap.ui.PastEventsFragment;
import com.example.meap.ui.PlannerFragment;
import com.example.meap.ui.ProfileFragment;
import com.example.meap.ui.PublicFragment;

public class MainPagerAdapter extends FragmentStateAdapter {

    private static final String[] TAB_TITLES = new String[]{
            "Login", "Chats", "Public", "Events", "Past", "Members", "Profile", "Planner", "Admin"
    };

    public MainPagerAdapter(@NonNull AppCompatActivity activity) {
        super(activity);
    }

    public static String getPageTitle(int position) {
        if (position < 0 || position >= TAB_TITLES.length) {
            return "Tab";
        }
        return TAB_TITLES[position];
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LoginFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new PublicFragment();
            case 3:
                return new EventsFragment();
            case 4:
                return new PastEventsFragment();
            case 5:
                return new MembersFragment();
            case 6:
                return new ProfileFragment();
            case 7:
                return new PlannerFragment();
            case 8:
                return new AdminFragment();
            default:
                throw new IllegalArgumentException("Unknown page position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return TAB_TITLES.length;
    }
}
