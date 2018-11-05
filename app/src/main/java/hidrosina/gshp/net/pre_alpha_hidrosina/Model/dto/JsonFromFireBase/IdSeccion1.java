
package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class IdSeccion1 {

    private List<Question> question = null;
    private String description;
    private String idSeccion;
    private String idform;
    private boolean loaded;
    private boolean managed;
    private String name;
    private boolean valid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getIdform() {
        return idform;
    }

    public void setIdform(String idform) {
        this.idform = idform;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("question", question).append("description", description).append("idSeccion", idSeccion).append("idform", idform).append("loaded", loaded).append("managed", managed).append("name", name).append("valid", valid).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(valid).append(loaded).append(managed).append(idform).append(idSeccion).append(additionalProperties).append(description).append(name).append(question).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdSeccion1) == false) {
            return false;
        }
        IdSeccion1 rhs = ((IdSeccion1) other);
        return new EqualsBuilder().append(valid, rhs.valid).append(loaded, rhs.loaded).append(managed, rhs.managed).append(idform, rhs.idform).append(idSeccion, rhs.idSeccion).append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(name, rhs.name).append(question, rhs.question).isEquals();
    }

}
