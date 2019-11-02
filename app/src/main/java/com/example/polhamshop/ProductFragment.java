package com.example.polhamshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ProductFragment extends Fragment {
    public ProductFragment()
    {
    }

    private GridView gv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_product, null);

        int[] img = {R.drawable.ic_button_plus, R.drawable.polham_logo, R.drawable.fab_add};

        gv = view.findViewById(R.id.gridview);
        GridAdapter gridAdapter = new GridAdapter(getContext(), img);
        gv.setAdapter(gridAdapter);


        return view;
    }
}
