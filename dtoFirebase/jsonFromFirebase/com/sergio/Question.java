
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
    "answer_default",
    "description",
    "id_parent",
    "id_question",
    "id_secction",
    "id_type",
    "max_photo",
    "min_photo",
    "option",
    "order",
    "requeried",
    "visibility"
})
public class Question {

    @JsonProperty("answer_default")
    private String answerDefault;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id_parent")
    private String idParent;
    @JsonProperty("id_question")
    private String idQuestion;
    @JsonProperty("id_secction")
    private String idSecction;
    @JsonProperty("id_type")
    private String idType;
    @JsonProperty("max_photo")
    private String maxPhoto;
    @JsonProperty("min_photo")
    private String minPhoto;
    @JsonProperty("option")
    private List<Option> option = null;
    @JsonProperty("order")
    private String order;
    @JsonProperty("requeried")
    private String requeried;
    @JsonProperty("visibility")
    private String visibility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("answer_default")
    public String getAnswerDefault() {
        return answerDefault;
    }

    @JsonProperty("answer_default")
    public void setAnswerDefault(String answerDefault) {
        this.answerDefault = answerDefault;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("id_parent")
    public String getIdParent() {
        return idParent;
    }

    @JsonProperty("id_parent")
    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    @JsonProperty("id_question")
    public String getIdQuestion() {
        return idQuestion;
    }

    @JsonProperty("id_question")
    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    @JsonProperty("id_secction")
    public String getIdSecction() {
        return idSecction;
    }

    @JsonProperty("id_secction")
    public void setIdSecction(String idSecction) {
        this.idSecction = idSecction;
    }

    @JsonProperty("id_type")
    public String getIdType() {
        return idType;
    }

    @JsonProperty("id_type")
    public void setIdType(String idType) {
        this.idType = idType;
    }

    @JsonProperty("max_photo")
    public String getMaxPhoto() {
        return maxPhoto;
    }

    @JsonProperty("max_photo")
    public void setMaxPhoto(String maxPhoto) {
        this.maxPhoto = maxPhoto;
    }

    @JsonProperty("min_photo")
    public String getMinPhoto() {
        return minPhoto;
    }

    @JsonProperty("min_photo")
    public void setMinPhoto(String minPhoto) {
        this.minPhoto = minPhoto;
    }

    @JsonProperty("option")
    public List<Option> getOption() {
        return option;
    }

    @JsonProperty("option")
    public void setOption(List<Option> option) {
        this.option = option;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("requeried")
    public String getRequeried() {
        return requeried;
    }

    @JsonProperty("requeried")
    public void setRequeried(String requeried) {
        this.requeried = requeried;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
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
        return new ToStringBuilder(this).append("answerDefault", answerDefault).append("description", description).append("idParent", idParent).append("idQuestion", idQuestion).append("idSecction", idSecction).append("idType", idType).append("maxPhoto", maxPhoto).append("minPhoto", minPhoto).append("option", option).append("order", order).append("requeried", requeried).append("visibility", visibility).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idType).append(answerDefault).append(maxPhoto).append(visibility).append(idSecction).append(minPhoto).append(idQuestion).append(order).append(additionalProperties).append(description).append(idParent).append(requeried).append(option).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Question) == false) {
            return false;
        }
        Question rhs = ((Question) other);
        return new EqualsBuilder().append(idType, rhs.idType).append(answerDefault, rhs.answerDefault).append(maxPhoto, rhs.maxPhoto).append(visibility, rhs.visibility).append(idSecction, rhs.idSecction).append(minPhoto, rhs.minPhoto).append(idQuestion, rhs.idQuestion).append(order, rhs.order).append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(idParent, rhs.idParent).append(requeried, rhs.requeried).append(option, rhs.option).isEquals();
    }

}
