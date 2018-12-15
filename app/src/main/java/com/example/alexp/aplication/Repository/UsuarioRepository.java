package com.example.alexp.aplication.Repository;

import android.app.Application;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Usuario;
import com.example.alexp.aplication.ObjectsDAO.UsuarioDAO;

public class UsuarioRepository {

    private static UsuarioDAO dao;

    public UsuarioRepository(Application app) { dao = AppDataBase.getInstance(app).usuarioDAO();}

    public Usuario getUser(){return getUserPrivate();}
    public void insertUser(Usuario u){insertUserPrivate(u);}
    public void updateUser(Usuario u){updateUserPrivate(u);}

    private Usuario getUserPrivate(){return dao.getUsuario();}
    private void  insertUserPrivate(Usuario u){dao.insertUsuario(u);}
    private void updateUserPrivate(Usuario u){dao.updateUsuario(u);}
}
