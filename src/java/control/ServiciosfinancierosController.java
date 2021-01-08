package control;

import modelo.Serviciosfinancieros;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("serviciosfinancierosController")
@SessionScoped
public class ServiciosfinancierosController implements Serializable {

    @EJB
    private control.ServiciosfinancierosFacade ejbFacade;
    private List<Serviciosfinancieros> items = null;
    private List<Serviciosfinancieros> itemsEliminados = null;
    private Serviciosfinancieros selected;

    public ServiciosfinancierosController() {
    }

    public List<Serviciosfinancieros> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Serviciosfinancieros> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Serviciosfinancieros getSelected() {
        return selected;
    }

    public void setSelected(Serviciosfinancieros selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServiciosfinancierosFacade getFacade() {
        return ejbFacade;
    }

    public Serviciosfinancieros prepareCreate() {
        selected = new Serviciosfinancieros();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosfinancierosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosfinancierosUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosfinancierosUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosfinancierosUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Serviciosfinancieros> getItems() {
        if (items == null) {
            items = ejbFacade.consultarServiciosfinancieros();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Serviciosfinancieros getServiciosfinancieros(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Serviciosfinancieros> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Serviciosfinancieros> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Serviciosfinancieros.class)
    public static class ServiciosfinancierosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiciosfinancierosController controller = (ServiciosfinancierosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviciosfinancierosController");
            return controller.getServiciosfinancieros(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Serviciosfinancieros) {
                Serviciosfinancieros o = (Serviciosfinancieros) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Serviciosfinancieros.class.getName()});
                return null;
            }
        }

    }

}
