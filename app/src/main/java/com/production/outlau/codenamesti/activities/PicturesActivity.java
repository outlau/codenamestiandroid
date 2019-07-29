package com.production.outlau.codenamesti.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.ImageCardAdapter;
import com.production.outlau.codenamesti.helpers.VolleyHelper;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;
import com.production.outlau.codenamesti.models.ImageCard;

import org.json.JSONArray;

import java.util.ArrayList;

public class PicturesActivity extends Fragment {

    private RecyclerView recyclerView;
    private ImageCardAdapter imageCardAdapter;
    private ArrayList<ImageCard> imageCardList;

    ProgressBar loadingIcon;
    TextView errorMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_pictures, parent, false);
        loadingIcon = v.findViewById(R.id.loading_icon);
        errorMsg = v.findViewById(R.id.error_message);

        recyclerView = v.findViewById(R.id.recycler_view);

        imageCardList = new ArrayList<>();
        imageCardAdapter = new ImageCardAdapter(getContext(), imageCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(1, 1, true, getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(imageCardAdapter);

        prepareCards();

//        try {
//            Glide.with(this).load(R.drawable.backdrop_gradient).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return v;
    }


    private void prepareCards() {
        final VolleyHelper volleyHelper;
        volleyHelper = new VolleyHelper(getContext());
        volleyHelper.getString("pictures", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String imgFile = jsonArray.getString(i);
                        imageCardList.add(new ImageCard(volleyHelper.url+"pictures/"+imgFile));
                    }

                } catch (Exception e) {
                    System.out.println("My App" + "Could not parse malformed JSON: \"" + result + "\"");
                    System.out.println(e);
                }
            }
            @Override
            public void onError(String error){
                //TODO
                errorMsg.setText(error);
                errorMsg.setVisibility(View.VISIBLE);
            }
            @Override
            public void onResponse(){
                loadingIcon.setVisibility(View.GONE);
            }
        });
        imageCardAdapter.notifyDataSetChanged();
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
}
