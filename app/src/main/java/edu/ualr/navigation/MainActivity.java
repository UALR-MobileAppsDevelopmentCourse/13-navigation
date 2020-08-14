package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

// TODO 05. We have to create the Fragment classes that we are going to use to instantiate from the activity
// FormFragment and PizzaOrderFragment
// TODO 06. Define the corresponding layout files

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 04. Create a new instance of the FragmentStateAdapter class created and plug it into the viewpager

        // TODO 08. We can listen for events from the view pager using the OnPageChangeCallback interface
        // NOTE: It's not mandatory to override all the methods of the interface

        // TODO 09. Callback interface for responding to changing state of the selected page.
        /**
         * This method will be invoked when the current page is scrolled, either as part of a
         * programmatically initiated smooth scroll or a user initiated touch scroll.
         */

        // TODO 10. Method invoked when a new page becomes selected
        // TODO 11. Method invoked when the scroll state changes.
        /**
         *  1-> SCROLL_STATE_DRAGGING. Indicates that the pager is currently being dragged by the user.
         *  0-> SCROLL_STATE_IDLE. Indicates that the pager is in an idle, settled state.
         *      The current page is fully in view and no animation is in progress.
         *  2-> SCROLL_STATE_SETTLING. Indicates that the pager is in the process of settling to a final position
         */
    }

    // TODO 03. Define a new FragmentStateAdapter class that will manage the visualization of the proper fragment
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        private static final int NUM_PAGES = 2;

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        // TODO 07. Override the createFragment method to instantiate the proper Fragment class based on the current position of the View pager
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return null;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
