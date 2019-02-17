/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inst.controller;

import com.inst.model.Clientes_model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nbthales
 */
public class Clientes_CRUD {

    Conexao co = new Conexao();
    int flag = 0;

    public void salvar(Clientes_model cli) {
        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "INSERT INTO clientes(codcliente,nomecliente,cpfcnpjclientes,datacclientes) "
                    + "VALUES( ?,?,?,? )");

            stmt.setInt(1, cli.getCodcliente());
            stmt.setString(2, cli.getNomecliente());
            stmt.setString(3, cli.getCpfcnpjclientes());
            stmt.setDate(4, cli.getDatacclientes());

            stmt.execute();
            stmt.close();
            co.Fechar_Conexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Cadastro de Clientes", 0);
        }
    }

    public int listar() {

        int lista = 0;

        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "select max(codcliente) from clientes");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lista = rs.getInt(1);

            }
            stmt.close();
            co.Fechar_Conexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Alteração de Clientes", 0);
        }
        return lista;
    }

    public List listar_dados() {

        List<Clientes_model> lista = new ArrayList<Clientes_model>();

        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "SELECT * FROM clientes");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes_model t = new Clientes_model();
                t.setCodcliente(rs.getInt("codcliente"));
                t.setNomecliente(rs.getString("nomecliente"));
                lista.add(t);
            }
            stmt.close();
            co.Fechar_Conexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..." + e.getMessage(), "Alteração de Clientes", 0);
        }
        return lista;
    }

    public List listar2() {

        List<Clientes_model> lista = new ArrayList<Clientes_model>();

        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "SELECT * FROM clientes ORDER BY codcliente desc");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes_model c = new Clientes_model();

                c.setCodcliente(rs.getInt("codcliente"));
                c.setNomecliente(rs.getString("nomecliente"));
                c.setCpfcnpjclientes(rs.getString("cpfcnpjclientes"));
                c.setDatacclientes(rs.getDate("datacclientes"));

                lista.add(c);
            }
            stmt.close();
            co.Fechar_Conexao();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..."
                    + e.getMessage(), "Pesquisa de Clientes", 0);
        }
        return lista;
    }

    public void deletar(Clientes_model li) {

        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "DELETE FROM clientes "
                    + "WHERE"
                    + "    codcliente = ?");

            stmt.setInt(1, li.getCodcliente());
            stmt.executeUpdate();
            stmt.close();
            co.Fechar_Conexao();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!",
                    "aviso", 1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..."
                    + e.getMessage(), "Exclusão de Clientes", 0);
        }
    }

    public void alterar(Clientes_model li) {

        try {
            co.conectar();
            PreparedStatement stmt = co.con.prepareStatement(
                    "UPDATE clientes "
                    + "SET "
                    + "    nomecliente = ?, "
                    + "    cpfcnpjclientes = ?, "
                    + "    datacclientes = ? "
                    + "WHERE"
                    + "    codcliente = ? ");

            stmt.setString(1, li.getNomecliente());
            stmt.setString(2, li.getCpfcnpjclientes());
            stmt.setDate(3, li.getDatacclientes());
            stmt.setInt(4, li.getCodcliente());

            stmt.executeUpdate();
            stmt.close();
            co.Fechar_Conexao();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!",
                    "aviso", 1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO..."
                    + e.getMessage(), "Alteração de Clientes", 0);
        }
    }
}
