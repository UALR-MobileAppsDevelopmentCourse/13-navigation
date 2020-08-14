package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import edu.ualr.navigation.databinding.ActivityMainBinding;

// TODO 05. We have to create the Fragment classes that we are going to use to instantiate from the activity
// FormFragment and PizzaOrderFragment
// TODO 06. Define the corresponding layout files

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private FragmentStateAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // TODO 04. Create a new instance of the FragmentStateAdapter class created and plug it into the viewpager
        pageAdapter = new ScreenSlidePagerAdapter(this);
        mBinding.pager.setAdapter(pageAdapter);
    }

    // TODO 03. Define a new FragmentStateAdapter class that will manage the visualization of the proper fragment
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        private static final int NUM_PAGES = 2;

        private static final int PIZZA_FRAGMENT_IDX = 0;
        private static final int CONTACT_FRAGMENT_IDX = 1;

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        // TODO 07. Override the createFragment method to instantiate the proper Fragment class based on the current position of the View pager
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case PIZZA_FRAGMENT_IDX:
                    return new PizzaOrderFragment();
                case CONTACT_FRAGMENT_IDX:
                    return new FormFragment();
                    default:
                        return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
