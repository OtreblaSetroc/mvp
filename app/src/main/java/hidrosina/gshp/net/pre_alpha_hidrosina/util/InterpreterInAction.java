package hidrosina.gshp.net.pre_alpha_hidrosina.util;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.MainPresenter;

public class InterpreterInAction implements Interpreter,MainPresenter {
    private View view;
    private String data[];
    private int idModule;
    private int idForm;
    private int idLayout;
    private Layout lyt;
    private int colorHead;
    private String menuTittle;
    private String headTittle;
    private int rows;

    @Override
    public void setViewSecction(View v, int idModule, int idForm, String... data) {
        this.view = v;
        this.idModule = idModule;
        this.idForm = idForm;
        this.data = data;
    }

    @Override
    public void setLayoutDistribution( int idLayout, Layout lyt, int colorHead, String... title) {
        this.idLayout = idLayout;
        this.lyt = lyt;
        this.colorHead = colorHead;
        if (title.length > 1) {
            menuTittle = title[0];
            headTittle = title[1];
        } else if (title.length == 1) {
            menuTittle = title[0];
        }

    }

    @Override
    public void setLayoutDistributionFull(int rows, int colorHead, int margin, int marginLeft, int marginRight, int marginTop, int marginBottom, String... title) {

    }

    @Override
    public void changeMenuTittle(String info) {

    }

    @Override
    public void changeHeaderTittle(String info) {

    }
}
