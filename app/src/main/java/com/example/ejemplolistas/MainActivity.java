package com.example.ejemplolistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    List<Producto> datos;
    EditText ext_nombre;
    EditText ext_precio;
    EditText ext_imagen;
    Button btn_agregar;
    ProductoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        btn_agregar=findViewById(R.id.btn_agregar);
        ext_nombre=findViewById(R.id.ext_nombre);
        ext_precio=findViewById(R.id.ext_precio);
        ext_imagen=findViewById(R.id.ext_imagen);
        datos=new ArrayList<>();

        adapter = new ProductoAdapter(this,R.layout.item_producto,datos);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,""+i,Toast.LENGTH_SHORT).show();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                MostrarMenu(view,i);
                return true;
            }
        });
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.add(
                  new Producto(
                          ext_nombre.getText().toString(),
                          Double.parseDouble(ext_precio.getText().toString()),
                          ext_imagen.getText().toString()
                  )
                );
                adapter.notifyDataSetChanged();
            }
        });
    }
    void MostrarMenu( View v, final int i){
        PopupMenu menu = new PopupMenu(this,v);

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_editar:
                        break;
                    case R.id.menu_eliminar:
                        datos.remove(i);
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
        menu.inflate(R.menu.menu_producto);
        menu.show();
    }

}
