package control;

import modelo.Exhibiciones;
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

@Named("exhibicionesController")
@SessionScoped
public class ExhibicionesController implements Serializable {

    @EJB
    private control.ExhibicionesFacade ejbFacade;
    private List<Exhibiciones> items = null;
    private List<Exhibiciones> itemsEliminados = null;
    private Exhibiciones selected;

    public ExhibicionesController() {
    }

    public List<Exhibiciones> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Exhibiciones> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Exhibiciones getSelected() {
        return selected;
    }

    public void setSelected(Exhibiciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ExhibicionesFacade getFacade() {
        return ejbFacade;
    }

    public Exhibiciones prepareCreate() {
        selected = new Exhibiciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ExhibicionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExhibicionesUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExhibicionesUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExhibicionesUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Exhibiciones> getItems() {
        if (items == null) {
            items = ejbFacade.consultarExhibiciones();
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

    public Exhibiciones getExhibiciones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Exhibiciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Exhibiciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Exhibiciones.class)
    public static class ExhibicionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ExhibicionesController controller = (ExhibicionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "exhibicionesController");
            return controller.getExhibiciones(getKey(value));
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
            if (object instanceof Exhibiciones) {
                Exhibiciones o = (Exhibiciones) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Exhibiciones.class.getName()});
                return null;
            }
        }

    }

}
