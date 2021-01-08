package control;

import modelo.Tarjetascliente;
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

@Named("tarjetasclienteController")
@SessionScoped
public class TarjetasclienteController implements Serializable {

    @EJB
    private control.TarjetasclienteFacade ejbFacade;
    private List<Tarjetascliente> items = null;
    private List<Tarjetascliente> itemsEliminados = null;
    private Tarjetascliente selected;

    public TarjetasclienteController() {
    }

    public List<Tarjetascliente> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Tarjetascliente> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Tarjetascliente getSelected() {
        return selected;
    }

    public void setSelected(Tarjetascliente selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TarjetasclienteFacade getFacade() {
        return ejbFacade;
    }

    public Tarjetascliente prepareCreate() {
        selected = new Tarjetascliente();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TarjetasclienteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TarjetasclienteUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TarjetasclienteUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TarjetasclienteUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tarjetascliente> getItems() {
        if (items == null) {
            items = ejbFacade.consultarTarjetascliente();
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

    public Tarjetascliente getTarjetascliente(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tarjetascliente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tarjetascliente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tarjetascliente.class)
    public static class TarjetasclienteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TarjetasclienteController controller = (TarjetasclienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tarjetasclienteController");
            return controller.getTarjetascliente(getKey(value));
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
            if (object instanceof Tarjetascliente) {
                Tarjetascliente o = (Tarjetascliente) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tarjetascliente.class.getName()});
                return null;
            }
        }

    }

}
