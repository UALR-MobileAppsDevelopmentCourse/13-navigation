package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import edu.ualr.navigation.databinding.ActivityMainBinding;

// TODO 05. We have to create the Fragment classes that we are going to use to instantiate from the activity
// FormFragment and PizzaOrderFragment
// TODO 06. Define the corresponding layout files

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
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

        // TODO 08. We can listen for events from the view pager using the OnPageChangeCallback interface
        // NOTE: It's not mandatory to override all the methods of the interface
        mBinding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            // TODO 09. Callback interface for responding to changing state of the selected page.
            /**
             * This method will be invoked when the current page is scrolled, either as part of a
             * programmatically initiated smooth scroll or a user initiated touch scroll.
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.d(TAG, String.format("Page %d has been scrolled. PositionOffsetPixels: %d", position, positionOffsetPixels));
            }

            // TODO 10. Method invoked when a new page becomes selected
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d(TAG, String.format("Page %d selected", position));
            }

            // TODO 11. Method invoked when the scroll state changes.
            /**
             *  1-> SCROLL_STATE_DRAGGING. Indicates that the pager is currently being dragged by the user.
             *  0-> SCROLL_STATE_IDLE. Indicates that the pager is in an idle, settled state.
             *      The current page is fully in view and no animation is in progress.
             *  2-> SCROLL_STATE_SETTLING. Indicates that the pager is in the process of settling to a final position
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                Log.d(TAG, String.format("New scroll state:  %d", state));
            }
        });
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
