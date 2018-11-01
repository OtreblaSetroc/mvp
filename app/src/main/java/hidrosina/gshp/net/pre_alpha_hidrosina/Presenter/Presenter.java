package hidrosina.gshp.net.pre_alpha_hidrosina.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import hidrosina.gshp.net.pre_alpha_hidrosina.Model.Model;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoDefaultLayout;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoOption;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain2;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVRowMain;

public class Presenter {
    private View view;
    private DtoDefaultLayout dtoDefaultLayout;
    private Model model;
    private List<ViewItem> viewItemsList;
    private List<ViewItems> viewsItemsList;
    private List<DtoQuestion> dtoQuestionList;

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
    public RVMain getAdapter(){
        List<String> questions= new ArrayList<>();
        for (int i=0;i<10;i++){
            questions.add("¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?");
            Log.e("sergioq ",questions.get(i)+"");
        }
        return new RVMain(questions);
    }
    public RVMain getAdapter( Context context){
        List<String> questions= new ArrayList<>();
        List<String> botones= new ArrayList<>();
        viewsItemsList=new ArrayList<>();
        int options=2; // opciones 2 por pregunta simulando lo que viene de servicios
          int count=0;
        for (int i=0;i<10;i++){
            questions.add("¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?");
            Log.e("sergioq ",questions.get(i)+"");
            viewItemsList=new ArrayList<>();
            for (int j=0;j<options;j++){
                Log.e("sergioItemC"," "+count);
                if (j==0){
                    viewItemsList.add(new ViewItem(count,"hai",0,""));
                }else{
                    viewItemsList.add(new ViewItem(count,"iie",0,""));
                }
                count++;
            }
            viewsItemsList.add(new ViewItems(i+"",questions.get(i),viewItemsList,1));

        }



        return new RVMain(questions,new RVRowMain(viewsItemsList,1),context);
    }
    public RVMain2 getAdapter(int type){
        dtoQuestionList= new ArrayList<>();
        List<DtoOption> dtoOptions;
        int options=1;
        for (int i=0;i<10;i++){
            dtoOptions= new ArrayList<>();
            for (int j=0;j<options;j++){
                dtoOptions.add(new DtoOption(j+"","Sí-NO"));
            }
            dtoQuestionList.add(new DtoQuestion(i+"",1+"","0",type+"",0+"","¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?"
                    ,0+"",1+"",dtoOptions));
            dtoQuestionList.add(new DtoQuestion(i+"","1",i+"","9","0","Foto","0","1",null));

        }

        return new RVMain2(dtoQuestionList,type);
    }
    private void setRvMain(RVMain2 adapter) {
        view.setRv(adapter);
    }


    public void init() {
        setMenuTittle();
        setHeaderTittle();
        setRvMain(getAdapter(1));
    }
    public void init(Context context) {
        setMenuTittle();
        setHeaderTittle();
        setRvMain(getAdapter(1));
    }



    public interface View {
        void changeMenuTittle(String info);
        void changeHeaderTittle(String info);
        void setRv(RVMain2 rvMain);
    }

}
