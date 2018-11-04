package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

public class DtoSimpleOption {
    private String idOption;
    private String IdInputEvent;
    private String value;
    private String order;

    public String getIdOption() {
        return idOption;
    }

    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }

    public String getIdInputEvent() {
        return IdInputEvent;
    }

    public void setIdInputEvent(String idInputEvent) {
        IdInputEvent = idInputEvent;
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

    @Override
    public String toString() {
        return "DtoSimpleOption{" +
                "idOption=" + idOption +
                ", IdInputEvent='" + IdInputEvent + '\'' +
                ", value='" + value + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
