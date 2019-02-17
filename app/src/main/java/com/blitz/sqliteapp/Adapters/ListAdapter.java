package com.blitz.sqliteapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blitz.sqliteapp.R;
import com.blitz.sqliteapp.model.ListaData;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context context;
    public List<ListaData> list;

    public ListAdapter(Context context, List<ListaData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nombre.setText(list.get(i).getNombre());
        viewHolder.personas.setText("Personas "+ String.valueOf(list.get(i).getPersonas()));
        viewHolder.descripcion.setText(list.get(i).getDescripcion());
        viewHolder.caracteristicas.setText(list.get(i).getCaracteristicas());

        if(list.get(i).getFavoritos() == 1){
            viewHolder.star.setImageResource(R.drawable.twotone_star_black_24);
        }else{
            viewHolder.star.setImageResource(R.drawable.twotone_star_border_black_24);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        ImageView star;
        TextView nombre, personas, descripcion, caracteristicas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            nombre = (TextView) itemView.findViewById(R.id.name);
            personas = (TextView) itemView.findViewById(R.id.personas);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            caracteristicas = (TextView) itemView.findViewById(R.id.caracteristicas);
            star = (ImageView) itemView.findViewById(R.id.star);
        }
    }
}
