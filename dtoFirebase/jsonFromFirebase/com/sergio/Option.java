
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
    "idInputEvent",
    "idOption",
    "order",
    "value"
})
public class Option {

    @JsonProperty("idInputEvent")
    private String idInputEvent;
    @JsonProperty("idOption")
    private String idOption;
    @JsonProperty("order")
    private String order;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idInputEvent")
    public String getIdInputEvent() {
        return idInputEvent;
    }

    @JsonProperty("idInputEvent")
    public void setIdInputEvent(String idInputEvent) {
        this.idInputEvent = idInputEvent;
    }

    @JsonProperty("idOption")
    public String getIdOption() {
        return idOption;
    }

    @JsonProperty("idOption")
    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
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
