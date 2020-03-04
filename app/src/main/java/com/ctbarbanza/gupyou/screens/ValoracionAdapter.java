package com.ctbarbanza.gupyou.screens;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.models.Valoracion;

import java.util.ArrayList;
import java.util.List;

import listeners.ValoracionAdapterListener;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class ValoracionAdapter extends RecyclerView.Adapter<ValoracionAdapter.ValoracionHolder> {

    private final ValoracionAdapterListener valoracionListener;
    private List<Valoracion> valoraciones=new ArrayList<Valoracion>();

    public ValoracionAdapter(List<Valoracion> valoraciones, ValoracionAdapterListener listener) {
        this.valoraciones = valoraciones;
        this.valoracionListener = listener;
    }

    @Override
    public ValoracionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_valoracion, parent, false);
        return new ValoracionHolder(view);
    }

    @Override
    public void onBindViewHolder(final ValoracionHolder holder, int position) {
        final Valoracion item = valoraciones.get(position);
    //De alguna manera mostrar la valoracion
        String texto = "";

        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valoracionListener!=null){
                    valoracionListener.click(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return valoraciones.size();
    }

    public class ValoracionHolder extends RecyclerView.ViewHolder {
        public TextView txt;
        public ImageView icon;
        public LinearLayout lin;

        void initView(View v){
            txt=v.findViewById(R.id.valoracion_item_txt);
            icon=v.findViewById(R.id.valoracion_item_ico);
            lin=v.findViewById(R.id.valoracion_item_lin);
        }

        public ValoracionHolder(View v) {
            super(v);
            initView(v);
        }
    }
}
