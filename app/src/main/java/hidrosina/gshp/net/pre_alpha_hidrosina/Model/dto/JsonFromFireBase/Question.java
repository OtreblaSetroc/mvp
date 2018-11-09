package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {
    private String id;
    private String description8;
    private String answerDefault;

    private String idParent;
    private String id_question;
    private String idSecction;
    private String idType;
    private String maxPhoto;
    private String minPhoto;
    private List<Option> option = null;
    private String order;
    private String requeried;
    private String visibility;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAnswerDefault() {
        return answerDefault;
    }

    public void setAnswerDefault(String answerDefault) {
        this.answerDefault = answerDefault;
    }

    public String getDescription() {
        return description8;
    }

    public void setDescription(String description) {
        this.description8 = description;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    public String getIdQuestion() {
        return id_question;
    }

    public void setIdQuestion(String idQuestion) {
        this.id_question = idQuestion;
    }

    public String getIdSecction() {
        return idSecction;
    }

    public void setIdSecction(String idSecction) {
        this.idSecction = idSecction;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getMaxPhoto() {
        return maxPhoto;
    }

    public void setMaxPhoto(String maxPhoto) {
        this.maxPhoto = maxPhoto;
    }

    public String getMinPhoto() {
        return minPhoto;
    }

    public void setMinPhoto(String minPhoto) {
        this.minPhoto = minPhoto;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRequeried() {
        return requeried;
    }

    public void setRequeried(String requeried) {
        this.requeried = requeried;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("answerDefault", answerDefault).append("description8", description8).append("idParent", idParent).append("id_question", id_question).append("idSecction", idSecction).append("idType", idType).append("maxPhoto", maxPhoto).append("minPhoto", minPhoto).append("option", option).append("order", order).append("requeried", requeried).append("visibility", visibility).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idType).append(answerDefault).append(maxPhoto).append(visibility).append(idSecction).append(minPhoto).append(id_question).append(order).append(additionalProperties).append(description8).append(idParent).append(requeried).append(option).toHashCode();
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
        return new EqualsBuilder().append(idType, rhs.idType).append(answerDefault, rhs.answerDefault).append(maxPhoto, rhs.maxPhoto).append(visibility, rhs.visibility).append(idSecction, rhs.idSecction).append(minPhoto, rhs.minPhoto).append(id_question, rhs.id_question).append(order, rhs.order).append(additionalProperties, rhs.additionalProperties).append(description8, rhs.description8).append(idParent, rhs.idParent).append(requeried, rhs.requeried).append(option, rhs.option).isEquals();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}