package hidrosina.gshp.net.pre_alpha_hidrosina.Presenter;

import android.util.Log;
import android.view.View;

import hidrosina.gshp.net.pre_alpha_hidrosina.Model.Model;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoDefaultLayout;

public class Presenter {
    private View view;
    private DtoDefaultLayout dtoDefaultLayout;
    private Model model;

    public Presenter(View view) {
        this.view = view;
        model =new Model();
        this.dtoDefaultLayout= new DtoDefaultLayout();
        model.initInfoLayoutParent(dtoDefaultLayout);
        Log.e("Sergio", dtoDefaultLayout.toString());
    }

    public void setMenuTittle(){
        Log.e("Sergio1", dtoDefaultLayout.getMenuTittle()+"");
        view.changeMenuTittle(dtoDefaultLayout.getMenuTittle());

    }
    public void setHeaderTittle(){
        Log.e("Sergio2", dtoDefaultLayout.getHeaderTittle()+"");
        view.changeHeaderTittle(dtoDefaultLayout.getHeaderTittle());
    }

    public void init() {
        setMenuTittle();
        setHeaderTittle();
    }

    public interface View {
        void changeMenuTittle(String info);
        void changeHeaderTittle(String info);
    }
}
