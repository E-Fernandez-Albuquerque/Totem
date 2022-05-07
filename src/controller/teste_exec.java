package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuarios;

public class teste_exec {

	public static void main(String[] args) throws SQLException {
		Usuarios usuario = new Usuarios();
		usuario.setId("FFFBBBCC");
		usuario.setName("Usuario Teste");
		UsuariosDAO.insertUser(usuario);
		String retorno = UsuariosDAO.searchUser(usuario);
		System.out.println(retorno);
	}
}
