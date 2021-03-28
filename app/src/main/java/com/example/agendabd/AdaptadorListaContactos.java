package com.example.agendabd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListaContactos extends  RecyclerView.Adapter<AdaptadorListaContactos.ContactoViewHolder> {
    private ArrayList<Contacto> contactos;
    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        private TextView lblNombre;
        private TextView lblTelefono;
        public ContactoViewHolder(View view) {
            super(view);
            lblNombre = view.findViewById(R.id.lbl_name);
            lblTelefono = view.findViewById(R.id.lbl_telefono);
        }
    }
    public AdaptadorListaContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_lista, parent, false);
        return new ContactoViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.lblNombre.setText(contactos.get(position).getNombre());
        holder.lblTelefono.setText(contactos.get(position).getTelefono());
    }
    @Override
    public int getItemCount() {
        return contactos.size();
    }
}