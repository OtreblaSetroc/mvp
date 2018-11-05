package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

public class DtoSection {
    private String idSeccion;
    private Object Question;
    private String idform;
    private String description;
    private boolean loaded;
    private boolean managed;
    private String name;
    private boolean valid;

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Object getQuestion() {
        return Question;
    }

    public void setQuestion(Object question) {
        Question = question;
    }

    public String getIdform() {
        return idform;
    }

    public void setIdform(String idform) {
        this.idform = idform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isManaged() {
        return managed;
    }

    public void setManaged(boolean managed) {
        this.managed = managed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
