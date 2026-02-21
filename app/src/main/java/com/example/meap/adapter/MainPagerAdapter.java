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
import com.example.meap.ui.PlannerFragment;
import com.example.meap.ui.ProfileFragment;
import com.example.meap.ui.PublicFragment;

public class MainPagerAdapter extends FragmentStateAdapter {

    public MainPagerAdapter(@NonNull AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new LoginFragment();
            case 1: return new ChatFragment();
            case 2: return new PublicFragment();
            case 3: return new EventsFragment();
            case 4: return new MembersFragment();
            case 5: return new ProfileFragment();
            case 6: return new PlannerFragment();
            default: return new AdminFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
