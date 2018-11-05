package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Option {
    private String idInputEvent;
    private String idOption;
    private String order;
    private String value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIdInputEvent() {
        return idInputEvent;
    }

    public void setIdInputEvent(String idInputEvent) {
        this.idInputEvent = idInputEvent;
    }

    public String getIdOption() {
        return idOption;
    }

    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idInputEvent", idInputEvent).append("idOption", idOption).append("order", order).append("value", value).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(order).append(additionalProperties).append(value).append(idInputEvent).append(idOption).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Option) == false) {
            return false;
        }
        Option rhs = ((Option) other);
        return new EqualsBuilder().append(order, rhs.order).append(additionalProperties, rhs.additionalProperties).append(value, rhs.value).append(idInputEvent, rhs.idInputEvent).append(idOption, rhs.idOption).isEquals();
    }

}
