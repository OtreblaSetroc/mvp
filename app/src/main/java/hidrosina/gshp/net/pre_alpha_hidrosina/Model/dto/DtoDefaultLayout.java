package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

public class DtoDefaultLayout {
    private String menuTittle;
    private String headerTittle;

    public String getMenuTittle() {
        return menuTittle;
    }

    public void setMenuTittle(String menuTittle) {
        this.menuTittle = menuTittle;
    }

    public String getHeaderTittle() {
        return headerTittle;
    }

    public void setHeaderTittle(String headerTittle) {
        this.headerTittle = headerTittle;
    }

    @Override
    public String toString() {
        return "DtoDefaultLayout{" +
                "menuTittle='" + menuTittle + '\'' +
                ", headerTittle='" + headerTittle + '\'' +
                '}';
    }
}
