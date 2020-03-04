package com.ctbarbanza.gupyou.screens;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctbarbanza.gupyou.R;

import listeners.ValoracionAdapterListener;


public class ValoracionFragment extends Fragment {

    private String uid;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ValoracionAdapterListener valoracionListener;
    public ValoracionFragment(String uid) {
        this.uid=uid;
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public ValoracionFragment newInstance(int columnCount) {
        ValoracionFragment fragment = new ValoracionFragment(this.uid);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_valoracion_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new ValoracionAdapter(DummyContent.ITEMS, valoracionListener));
        }
        miInit(view);
        return view;
    }

    private void miInit(View view) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ValoracionAdapterListener) {
            valoracionListener = (ValoracionAdapterListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        valoracionListener = null;
    }
}
