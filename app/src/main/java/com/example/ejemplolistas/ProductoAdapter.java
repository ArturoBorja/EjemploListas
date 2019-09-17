package com.example.ejemplolistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class ProductoAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Producto> datos;

    public ProductoAdapter(Context context, int layout, List<Producto> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(layout,null);
        TextView nombre=v.findViewById(R.id.nombre);
        nombre.setText(datos.get(i).getNombre());
        TextView presio=v.findViewById(R.id.precio);
        presio.setText(datos.get(i).getPrecio().toString());
        ImageView imagen=v.findViewById(R.id.imagen);
        Glide.with(context).load(datos.get(i).imagen).into(imagen);

        return v;
    }
}
