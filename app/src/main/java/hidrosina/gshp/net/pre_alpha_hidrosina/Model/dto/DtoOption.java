package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

public class DtoOption {
    private String idOption;
    private String option;
    private String value;
    private String order;


    public DtoOption(String idOption, String value) {
        this.idOption = idOption;
        this.value = value;
    }

    public DtoOption() {
    }

    public String getIdOption() {
        return idOption;
    }

    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
