
package org.uv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.dao.Empleado;
import org.dao.EmpleadoDAO;


@ManagedBean
@SessionScoped
public class EmpleadoBean implements Serializable{
    
     private Empleado empleado;
     private EmpleadoDAO dao;
     private List<Empleado> lista;

    public EmpleadoBean() {
    empleado = new Empleado();
    dao = new EmpleadoDAO();
   
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
    public List<Empleado> getLista(){
        return lista;
    }
    
    

    public void insertar() {
        
        dao.ingresar(this.empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Agregacion exitosa"));
     
    }

    public void actualizar() {

        dao.actualizar(this.empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Actualizacion exitosa"));
    }

    public void eliminar() {

        dao.eliminar(this.empleado.getId());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro","Eliminacion exitosa"));
    }
    
    public void buscarId() {
        lista = new ArrayList<>();
        lista.add(dao.mostrarById(empleado.getId()));
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
