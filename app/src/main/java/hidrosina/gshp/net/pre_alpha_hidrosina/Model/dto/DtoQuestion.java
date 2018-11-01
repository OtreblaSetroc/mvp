package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

import java.util.List;

public class DtoQuestion {
    private String id_question;
    private String id_secction;
    private String id_type;
    private String length;
    private String description;
    private String requeried;
    private String visibility;
    private String order;
    private String Max_photo;
    private String Min_photo;
    private String answer_default;
    private String id_parent;
    private List<DtoOption> dtoOptions;

    public DtoQuestion(String id_question, String id_secction,String id_parent, String id_type, String length, String description, String requeried, String visibility, List<DtoOption> dtoQuestionList) {
        this.id_question = id_question;
        this.id_secction = id_secction;
        this.id_parent=id_parent;
        this.id_type = id_type;
        this.length = length;
        this.description = description;
        this.requeried = requeried;
        this.visibility = visibility;
        this.dtoOptions = dtoQuestionList;
    }



    public DtoQuestion() {
    }

    public String getId_question() {
        return id_question;
    }

    public void setId_question(String id_question) {
        this.id_question = id_question;
    }

    public String getId_secction() {
        return id_secction;
    }

    public void setId_secction(String id_secction) {
        this.id_secction = id_secction;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMax_photo() {
        return Max_photo;
    }

    public void setMax_photo(String max_photo) {
        Max_photo = max_photo;
    }

    public String getMin_photo() {
        return Min_photo;
    }

    public void setMin_photo(String min_photo) {
        Min_photo = min_photo;
    }

    public String getAnswer_default() {
        return answer_default;
    }

    public void setAnswer_default(String answer_default) {
        this.answer_default = answer_default;
    }

    public List<DtoOption> getDtoOptions() {
        return dtoOptions;
    }

    public void setDtoOptions(List<DtoOption> dtoOptions) {
        this.dtoOptions = dtoOptions;
    }
}
