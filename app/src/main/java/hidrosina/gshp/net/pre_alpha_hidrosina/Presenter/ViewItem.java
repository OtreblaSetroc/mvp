package hidrosina.gshp.net.pre_alpha_hidrosina.Presenter;

public class ViewItem {
    private int id;
    private String descrip;
    private int type;
    private String extrainfo;
    private int isCheck;

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public ViewItem( final int id,final String descrip,final int type, final String extrainfo) {
        this.id = id;
        this.descrip = descrip;
        this.type = type;
        this.extrainfo = extrainfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ViewItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getExtrainfo() {
        return extrainfo;
    }

    public void setExtrainfo(String extrainfo) {
        this.extrainfo = extrainfo;
    }
}
