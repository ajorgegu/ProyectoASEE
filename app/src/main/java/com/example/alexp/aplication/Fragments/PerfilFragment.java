package com.example.alexp.aplication.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexp.aplication.Objects.Usuario;
import com.example.alexp.aplication.ObjectsDAO.UsuarioDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.UsuarioRepository;

@SuppressLint("ValidFragment")
public class PerfilFragment extends Fragment {

    private View v;
    private Button guardar;
    private EditText nombre,ape,peso,edad;
    private UsuarioRepository urep;

    @SuppressLint("ValidFragment")
    public PerfilFragment(Application app){
        this.urep=new UsuarioRepository(app);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=  inflater.inflate(R.layout.perfil,container,false);
        this.nombre= v.findViewById(R.id.nUser);
        this.ape =  v.findViewById(R.id.apeUser);
        this.peso =  v.findViewById(R.id.pUser);
        this.edad=  v.findViewById(R.id.eUser);
        Usuario u = urep.getUser();
        if(u!=null) {
            nombre.setText(u.getNombre());
            ape.setText(u.getApellidos());
            peso.setText(String.valueOf(u.getPeso()));
            edad.setText(String.valueOf(u.getEdad()));
        }
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        guardar= (Button) v.findViewById(R.id.guardarCambios);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nombre.getText().toString();
                String surname=ape.getText().toString();
                Float weight=Float.parseFloat(peso.getText().toString());
                int age=Integer.parseInt(edad.getText().toString());
                Log.d("Usuario: ",name+" "+surname+" "+weight+" "+age);
                Usuario u = new Usuario(name,surname,weight,age);
                Usuario aux = urep.getUser();
                if(aux!=null) urep.updateUser(u);
                else {
                   urep.insertUser(u);
                }
            }
        });
    }
}
