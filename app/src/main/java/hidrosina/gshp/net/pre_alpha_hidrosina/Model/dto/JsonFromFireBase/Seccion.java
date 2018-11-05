
package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Seccion {

    private IdSeccion1 idSeccion1;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public IdSeccion1 getIdSeccion1() {
        return idSeccion1;
    }

    public void setIdSeccion1(IdSeccion1 idSeccion1) {
        this.idSeccion1 = idSeccion1;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

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
