package com.production.outlau.codenamesti;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.production.outlau.codenamesti.activities.CountdownActivity;
import com.production.outlau.codenamesti.activities.MapsActivity;
import com.production.outlau.codenamesti.activities.MessagingActivity;
import com.production.outlau.codenamesti.activities.PicturesActivity;
import com.production.outlau.codenamesti.activities.SoundsActivity;
import com.production.outlau.codenamesti.controllers.MainCardAdapter;
import com.production.outlau.codenamesti.models.MainCard;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // CMD to run emulator
    //Emulator -avd Nexus_5X_API_24 -partition-size 512 -feature WindowsHypervisorPlatform

    private RecyclerView recyclerView;
    private MainCardAdapter adapter;
    private List<MainCard> mainCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mainCardList = new ArrayList<>();
        adapter = new MainCardAdapter(this, mainCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareCards();

        try {
            Glide.with(this).load(R.drawable.background_gradient).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareCards() {
        int[] icons = new int[]{
                R.drawable.icon_music_note,
                R.drawable.icon_message,
                R.drawable.icon_image,
                R.drawable.icon_map,
                R.drawable.icon_timer,
        };

//        String[] colors = new String[]{"red", "orange", "yellow", "green", "lightblue", "blue"};

        int[] colors = new int[]{R.color.red,R.color.pink,R.color.orange,R.color.yellow,R.color.green,R.color.lightblue,R.color.blue,R.color.darkblue};

        mainCardList.add(new MainCard("Sounds", icons[0], colors[0], SoundsActivity.class));

        mainCardList.add(new MainCard("Messages", icons[1], colors[1], MessagingActivity.class));

        mainCardList.add(new MainCard("Images", icons[2], colors[2], PicturesActivity.class));

        mainCardList.add(new MainCard("Maps", icons[3], colors[3], MapsActivity.class));

        mainCardList.add(new MainCard("Countdown", icons[4], colors[4], CountdownActivity.class));

        mainCardList.add(new MainCard("Messages", icons[1], colors[3], MessagingActivity.class));
        mainCardList.add(new MainCard("Messages", icons[1], colors[4], MessagingActivity.class));
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    
    public void GoToPictures(View v){
        Intent intent = new Intent(this, PicturesActivity.class);
        startActivity(intent);
    }


    public void GoToSounds(View v){
        Intent intent = new Intent(this, SoundsActivity.class);
        startActivity(intent);
    }

    public void GoToMessaging(View v){
        Intent intent = new Intent(this, MessagingActivity.class);
        startActivity(intent);
    }
}
