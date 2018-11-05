
package com.sergio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Question",
    "description",
    "idSeccion",
    "idform",
    "loaded",
    "managed",
    "name",
    "valid"
})
public class IdSeccion1 {

    @JsonProperty("Question")
    private List<Question> question = null;
    @JsonProperty("description")
    private String description;
    @JsonProperty("idSeccion")
    private String idSeccion;
    @JsonProperty("idform")
    private String idform;
    @JsonProperty("loaded")
    private boolean loaded;
    @JsonProperty("managed")
    private boolean managed;
    @JsonProperty("name")
    private String name;
    @JsonProperty("valid")
    private boolean valid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Question")
    public List<Question> getQuestion() {
        return question;
    }

    @JsonProperty("Question")
    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("idSeccion")
    public String getIdSeccion() {
        return idSeccion;
    }

    @JsonProperty("idSeccion")
    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    @JsonProperty("idform")
    public String getIdform() {
        return idform;
    }

    @JsonProperty("idform")
    public void setIdform(String idform) {
        this.idform = idform;
    }

    @JsonProperty("loaded")
    public boolean isLoaded() {
        return loaded;
    }

    @JsonProperty("loaded")
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    @JsonProperty("managed")
    public boolean isManaged() {
        return managed;
    }

    @JsonProperty("managed")
    public void setManaged(boolean managed) {
        this.managed = managed;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("valid")
    public boolean isValid() {
        return valid;
    }

    @JsonProperty("valid")
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
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
