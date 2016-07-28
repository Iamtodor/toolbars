package com.todor.toolbars.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.todor.tooblars.R;
import com.todor.toolbars.fragment.ViewPagerFragment;
import com.todor.toolbars.adapter.ViewPagerAdapter;

import butterknife.BindView;

public class ToolbarWithTabLayoutActivity extends BaseActivity {

    @BindView(R.id.viewpager) protected ViewPager viewPager;
    @BindView(R.id.tabs) protected TabLayout tabLayout;
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @Override
    public int getContentViewId() {
        return R.layout.toolbar_with_tablayout_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupToolbar(toolbar);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ViewPagerFragment(), "Category 1");
        adapter.addFragment(new ViewPagerFragment(), "Category 2");
        adapter.addFragment(new ViewPagerFragment(), "Category 3");
        viewPager.setAdapter(adapter);
    }
}
