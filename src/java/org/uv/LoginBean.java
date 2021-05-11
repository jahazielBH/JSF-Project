package org.uv;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.dao.Cuenta;
import org.dao.CuentaDAO;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

    private Cuenta cuenta, cuenta1, cuentaComparacion;
    private CuentaDAO dao;

    public LoginBean() {
        cuenta = new Cuenta();
        cuenta1 = new Cuenta();
        dao = new CuentaDAO();
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Cuenta getCuenta1() {
        return cuenta1;
    }

    public void insertar() {

        dao.ingresar(this.cuenta1);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro", "Agregacion exitosa"));

    }

    public void buscar() throws IOException {
        cuentaComparacion = dao.mostrarById(cuenta.getNombre(), cuenta.getPassword());

        if (cuenta.getNombre().equals(cuentaComparacion.getNombre()) & cuenta.getPassword().equals(cuentaComparacion.getPassword())) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("faces/menu.xhtml");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Registro", "Error, intentelo de nuevo"));
        }

    }

}
