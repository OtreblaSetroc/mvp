
package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DtoGeneral {

    private Seccion seccion;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("seccion", seccion).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(seccion).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DtoGeneral) == false) {
            return false;
        }
        DtoGeneral rhs = ((DtoGeneral) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(seccion, rhs.seccion).isEquals();
    }

}
