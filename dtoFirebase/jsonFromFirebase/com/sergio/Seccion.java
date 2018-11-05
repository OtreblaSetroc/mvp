
package com.sergio;

import java.util.HashMap;
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
    "IdSeccion1"
})
public class Seccion {

    @JsonProperty("IdSeccion1")
    private IdSeccion1 idSeccion1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IdSeccion1")
    public IdSeccion1 getIdSeccion1() {
        return idSeccion1;
    }

    @JsonProperty("IdSeccion1")
    public void setIdSeccion1(IdSeccion1 idSeccion1) {
        this.idSeccion1 = idSeccion1;
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
        return new ToStringBuilder(this).append("idSeccion1", idSeccion1).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idSeccion1).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Seccion) == false) {
            return false;
        }
        Seccion rhs = ((Seccion) other);
        return new EqualsBuilder().append(idSeccion1, rhs.idSeccion1).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
