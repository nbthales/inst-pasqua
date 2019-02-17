/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inst.controller;

/**
 *
 * @author nbthales
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection con;

    static String usuario = "root";
    static String senha = "";
    static String url = "jdbc:mysql://localhost:3306/inst";

    public Conexao() {
    }

    //-----------------------------------------------------------
    public void conectar() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK!!!");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão OK!!!");
        } catch (ClassNotFoundException exc) {
            System.out.println("Erro no driver " + exc.getMessage());
        } catch (SQLException exc) {
            System.out.println("Erro de conexao =" + exc.getMessage());
        }
    }

    //-----------------------------------------
    public void Fechar_Conexao() {
        try {
            con.close();
            System.out.println("Fechando conexão....");
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
