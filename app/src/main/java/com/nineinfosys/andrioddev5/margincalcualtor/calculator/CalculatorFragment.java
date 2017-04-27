package com.nineinfosys.andrioddev5.margincalcualtor.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.andrioddev5.margincalcualtor.MarginCalcualtor.CurrencyExchange.CurrencyExchangeMain;
import com.nineinfosys.andrioddev5.margincalcualtor.MarginCalcualtor.profitMargin.ProfitMarginMain;
import com.nineinfosys.andrioddev5.margincalcualtor.MarginCalcualtor.stocktrading.StockTradingCalculator;
import com.nineinfosys.andrioddev5.margincalcualtor.R;

/**
 * Created by Supriya on 27-04-2017.
 */

public class CalculatorFragment extends Fragment {

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_layout, null);

        mPagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new CurrencyExchangeMain(),
                    new ProfitMarginMain(),
                    new StockTradingCalculator(),
            };
            private final String[] mFragmentNames = new String[] {
                    getString(R.string.heading_currency),
                    getString(R.string.heading_profit),
                    getString(R.string.heading_stock)
            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager)v.findViewById(R.id.container1);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(mViewPager);

        return v;
    }
}
