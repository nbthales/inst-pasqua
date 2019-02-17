/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inst.model;

import java.sql.Date;

/**
 *
 * @author nbthales
 */
public class Clientes_model {

    private int codcliente;
    private String nomecliente;
    private String cpfcnpjclientes;
    private Date datacclientes;


    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getCpfcnpjclientes() {
        return cpfcnpjclientes;
    }

    public void setCpfcnpjclientes(String cpfcnpjclientes) {
        this.cpfcnpjclientes = cpfcnpjclientes;
    }

    public Date getDatacclientes() {
        return datacclientes;
    }

    public void setDatacclientes(Date datacclientes) {
        this.datacclientes = datacclientes;
    }

}
