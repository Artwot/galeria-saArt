package control;

import modelo.Autores;
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

@Named("autoresController")
@SessionScoped
public class AutoresController implements Serializable {

    @EJB
    private control.AutoresFacade ejbFacade;
    private List<Autores> items = null;
    private List<Autores> itemsEliminados = null;
    private Autores selected;

    public AutoresController() {
    }

    public List<Autores> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Autores> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Autores getSelected() {
        return selected;
    }

    public void setSelected(Autores selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AutoresFacade getFacade() {
        return ejbFacade;
    }

    public Autores prepareCreate() {
        selected = new Autores();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AutoresCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AutoresUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AutoresUpdated"));
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AutoresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.

        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AutoresUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Autores> getItems() {
        if (items == null) {
            //items = getFacade().findAll();
            items = ejbFacade.consultarAutores();
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

    public Autores getAutores(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Autores> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Autores> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Autores.class)
    public static class AutoresControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AutoresController controller = (AutoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "autoresController");
            return controller.getAutores(getKey(value));
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
            if (object instanceof Autores) {
                Autores o = (Autores) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Autores.class.getName()});
                return null;
            }
        }

    }

}
