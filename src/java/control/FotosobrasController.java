package control;

import modelo.Fotosobras;
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

@Named("fotosobrasController")
@SessionScoped
public class FotosobrasController implements Serializable {

    @EJB
    private control.FotosobrasFacade ejbFacade;
    private List<Fotosobras> items = null;
    private List<Fotosobras> itemsEliminados = null;
    private Fotosobras selected;
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

    public FotosobrasController() {
    }

    public List<Fotosobras> getItemsEliminados() {
        if (itemsEliminados == null) {
            itemsEliminados = ejbFacade.consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Fotosobras> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    public Fotosobras getSelected() {
        return selected;
    }

    public void setSelected(Fotosobras selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FotosobrasFacade getFacade() {
        return ejbFacade;
    }

    public Fotosobras prepareCreate() {
        selected = new Fotosobras();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        selected.setRuta(aux);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FotosobrasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosobrasUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosobrasUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosobrasUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;    // Invalidate list of items to trigger re-query.
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Fotosobras> getItems() {
        if (items == null) {
            items = ejbFacade.consultarFotosobras();
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
        if (getFoto().getFileName().endsWith(".png")
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
        }
    }

    public Boolean SubirArchivo() {
        try {
            aux = "resources/obrasfotos";
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

    public Fotosobras getFotosobras(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Fotosobras> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Fotosobras> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Fotosobras.class)
    public static class FotosobrasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FotosobrasController controller = (FotosobrasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fotosobrasController");
            return controller.getFotosobras(getKey(value));
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
            if (object instanceof Fotosobras) {
                Fotosobras o = (Fotosobras) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Fotosobras.class.getName()});
                return null;
            }
        }

    }

}
