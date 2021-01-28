package co.quindio.sena.ejemplosqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.quindio.sena.ejemplosqlite.adaptadores.ListaPersonasAdapter;
import co.quindio.sena.ejemplosqlite.entidades.Usuario;
import co.quindio.sena.ejemplosqlite.utilidades.Utilidades;

public class ListaPersonasRecycler extends AppCompatActivity {

    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerViewUsuarios;
    TextView id;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas_recycler);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        id= (TextView) findViewById(R.id.IdEliminar);
        listaUsuario=new ArrayList<>();

        recyclerViewUsuarios= (RecyclerView) findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        ListaPersonasAdapter adapter=new ListaPersonasAdapter(listaUsuario);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Seleccion: "+listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId(),Toast.LENGTH_SHORT).show();
                 String idReal = listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId().toString();
                 id.setText(idReal);
               // id.setText();

                //id.setText((CharSequence) listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId();
                // id.setText(listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId());
      mostrardialogo(v);



            }
        });
        recyclerViewUsuarios.setAdapter(adapter);

    }

    private void mostrardialogo(final View v) {
        new AlertDialog.Builder(this)
                .setTitle("Los Arcos Inc")
                .setMessage("Desea eliminar platillo?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db=conn.getWritableDatabase();
                        String[] parametros={id.getText().toString()};

                        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
                        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
                        id.setText("");
                        //limpiar();
                        db.close();
                        finish();
                        startActivity(getIntent());
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
       // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setSize(cursor.getString(3));
            usuario.setCantidad(cursor.getString(4));
            usuario.setExtra(cursor.getString(5));
            usuario.setComentarios(cursor.getString(6));
            usuario.setTotal(cursor.getString(2));

            listaUsuario.add(usuario);
        }
    }
         /*
    public void eliminarr(View t) {

        AlertDialog.Builder builder = new AlertDialog.Builder(CarritoActivity.this);

        builder.setIcon(R.mipmap.ic_launcher).
                setTitle("Eliminar").
                setMessage("Esta seguro de eliminar este articulo").
                setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CarritoActivity.this, "si", Toast.LENGTH_LONG).show();
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(CarritoActivity.this, position, Toast.LENGTH_LONG).show();
                                iname.remove(position);
                                padapter2.notifyDataSetChanged();
                            }
                        });


                    }
                }).
                setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

   */

    /*private void llenarListaUsuarios() {
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
        listaUsuario.add(new Usuario(1,"Cristian","548526"));
    }

}*/

    }

