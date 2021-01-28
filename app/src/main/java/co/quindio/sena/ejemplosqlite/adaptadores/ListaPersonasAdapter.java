package co.quindio.sena.ejemplosqlite.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.quindio.sena.ejemplosqlite.R;
import co.quindio.sena.ejemplosqlite.entidades.Usuario;

/**
 * Created by CHENAO on 8/07/2017.
 */

public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder>
        implements View.OnClickListener{

    ArrayList<Usuario> listaUsuario;
    private View.OnClickListener listener;

    public ListaPersonasAdapter(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personas,null,false);
       view.setOnClickListener(this);

        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        holder.documento.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre());
        holder.size.setText(listaUsuario.get(position).getSize());
        holder.cantidad.setText(listaUsuario.get(position).getCantidad());
        holder.extra.setText(listaUsuario.get(position).getExtra());
        holder.comentarios.setText(listaUsuario.get(position).getComentarios());
        holder.total.setText(listaUsuario.get(position).getTotal());


    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView documento,nombre, total,size,cantidad,extra,comentarios;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            documento = (TextView) itemView.findViewById(R.id.textId);
            size= (TextView) itemView.findViewById(R.id.textSize);
            cantidad= (TextView) itemView.findViewById(R.id.textCantidad);
            extra= (TextView) itemView.findViewById(R.id.textExtra);
            comentarios= (TextView) itemView.findViewById(R.id.textComentarios);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            total = (TextView) itemView.findViewById(R.id.textTotal);
        }
    }
}
