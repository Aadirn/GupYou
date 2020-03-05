package com.ctbarbanza.gupyou.screens;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.mockup.UserController;
import com.ctbarbanza.gupyou.models.Valoracion;

import java.util.ArrayList;

import listeners.ValoracionAdapterListener;


public class ValoracionFragment extends Fragment {

    private String uid;


    private static final String ARG_COLUMN_COUNT = "user_uid";

    private ValoracionAdapterListener valoracionListener;
    public ValoracionFragment() {
    }


    public static ValoracionFragment newInstance(String uid) {
        ValoracionFragment fragment = new ValoracionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COLUMN_COUNT, uid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            uid = getArguments().getString(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_valoracion_list, container, false);
        miInit(view);
        return view;
    }

    private void miInit(View v) {
    //Asumo aqui llamar al adapter pero no se hacer mucho más
        Context ctx = getContext();
        RecyclerView listaV=v.findViewById(R.id.frg_valoracion_list);

        RecyclerView.LayoutManager layManager=new LinearLayoutManager(ctx);
        listaV.setLayoutManager(layManager);

        ArrayList<Valoracion> valoraciones = (ArrayList<Valoracion>) UserController.init().getValoraciones(uid);
        Log.d("FRG","Valoreaciones:"+valoraciones.size());
        ValoracionAdapter vAdapter = new ValoracionAdapter(valoraciones, valoracionListener);

        listaV.setAdapter(vAdapter);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        valoracionListener = null;
    }
}
