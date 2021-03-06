package com.example.fragmentcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabFragmentActivity extends FragmentActivity implements SecondExampleFragment.RegisterResult{
    private static final String TAG = "TabFragment Activity";
    private ViewPager2 viewPager;
    private DemoFragmentPagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment);
        // initiating the tabhost
        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        DemoFragmentPagerAdapter
                adapter
                = new DemoFragmentPagerAdapter(this);

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout,viewPager,(tab, position) -> tab.setText("TAB " + (position + 1))
        ).attach();

    }

    @Override
    public void dataFromRegister(String mail, String password) {
        Log.d(TAG, "dataFromRegister: received in Activity " + mail + " , " + password);
        Toast.makeText(this, "Received data in Activity " + mail + " , " + password, Toast.LENGTH_SHORT).show();

    }
}