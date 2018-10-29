package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

public class DtoRadioButton {
    private int id;
    private String name;
    private int isCheck;

    public DtoRadioButton(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DtoRadioButton() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }
}
