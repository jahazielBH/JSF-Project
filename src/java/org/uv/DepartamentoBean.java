/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.dao.Departamento;
import org.dao.DepartamentoDAO;

/**
 *
 * @author GabrielHS
 */
@ManagedBean
@SessionScoped
public class DepartamentoBean implements Serializable{

    private Departamento departamento;
    private DepartamentoDAO dao;
    private List<Departamento> lista;
    
    public DepartamentoBean() {
        departamento = new Departamento();
        dao = new DepartamentoDAO();
        
    }
    
    public Departamento getDepartamento(){
        return departamento;
    }
    
    public List<Departamento> getLista(){
        return lista;
    }
    
    public void insertar() {
        
        dao.ingresar(this.departamento);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Agregacion exitosa"));
     
    }

    public void actualizar() {

        dao.actualizar(this.departamento);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Actualizacion exitosa"));
    }

    public void eliminar() {

        dao.eliminar(this.departamento.getId());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Eliminacion exitosa"));
    }
    
    public void buscarId() {
        lista = new ArrayList<>();
        lista.add(dao.mostrarById(departamento.getId()));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("EXITO", "MOSTRANDO DATO"));
    }
    
    public void listar() {
        lista = new ArrayList<>();
        lista = (dao.mostrarAll());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("EXITO", "MOSTRANDO DATOS"));
    }
    
    
    
}
