package control;

import modelo.Fotosexhibiciones;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.UploadedFile;

@Named("fotosexhibicionesController")
@SessionScoped
public class FotosexhibicionesController implements Serializable {

    @EJB
    private control.FotosexhibicionesFacade ejbFacade;
    private List<Fotosexhibiciones> items = null;
    private List<Fotosexhibiciones> itemsEliminados = null;
    private Fotosexhibiciones selected;
    private UploadedFile foto;
    private String aux;

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public FotosexhibicionesController() {
    }

    public List<Fotosexhibiciones> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Fotosexhibiciones> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Fotosexhibiciones getSelected() {
        return selected;
    }

    public void setSelected(Fotosexhibiciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FotosexhibicionesFacade getFacade() {
        return ejbFacade;
    }

    public Fotosexhibiciones prepareCreate() {
        selected = new Fotosexhibiciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        selected.setRuta(aux);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FotosexhibicionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosexhibicionesUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosexhibicionesUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosexhibicionesUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Fotosexhibiciones> getItems() {
        if (items == null) {
            items = ejbFacade.consultarFotosexhibiciones();
        }
        return items;
    }

    //Para subir y guardar el archivo en carpeta y la ruta en la BD:
    public void NuevoDocumento() {
        System.out.println("MIME TYPE: " + getFoto().getContentType());
        System.out.println("TAMAÑO: " + getFoto().getSize());
        System.out.println("EXTENSIÓN PNG: " + getFoto().getFileName().endsWith(".png"));
        System.out.println("EXTENSIÓN JPG: " + getFoto().getFileName().endsWith(".jpg"));
        System.out.println("EXTENSIÓN GIF: " + getFoto().getFileName().endsWith(".gif"));
        /*if (getFoto().getFileName().endsWith(".png")
                || getFoto().getFileName().endsWith(".jpg")
                || getFoto().getFileName().endsWith(".gif")) {
            if (SubirArchivo()) {
                create();
                aux = "";
            }
        } else {
            FacesMessage mensaje = new FacesMessage("El archivo NO es una imagen.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            selected = null;
        }*/
        if (SubirArchivo()) {
            create();
            aux = "";
        }
    }

    public Boolean SubirArchivo() {
        try {
            aux = "resources/exhibicionesfotos";
            System.out.println("RUTA: " + aux);
            File archivo = new File(JsfUtil.getPath() + aux);
            if (!archivo.exists()) {
                archivo.mkdirs();
            }
            copiar_archivo(getFoto().getFileName(), getFoto().getInputstream());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void copiar_archivo(String nombre_archivo, InputStream in) {
        try {
            aux = aux + "/" + nombre_archivo;
            System.out.println("Se va a guardar el archivo.");
            System.out.println("Ruta OK: " + aux);
            System.out.println("Ruta real: " + JsfUtil.getPath() + aux);
            OutputStream out = new FileOutputStream(new File(JsfUtil.getPath() + aux));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            System.out.println("El archivo se ha guardado.");
            aux = aux.substring(9);
            System.out.println("Ruta en la base: " + aux);
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").toString());
        }
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

    public Fotosexhibiciones getFotosexhibiciones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Fotosexhibiciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Fotosexhibiciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Fotosexhibiciones.class)
    public static class FotosexhibicionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FotosexhibicionesController controller = (FotosexhibicionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fotosexhibicionesController");
            return controller.getFotosexhibiciones(getKey(value));
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
            if (object instanceof Fotosexhibiciones) {
                Fotosexhibiciones o = (Fotosexhibiciones) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Fotosexhibiciones.class.getName()});
                return null;
            }
        }

    }

}
