package hidrosina.gshp.net.pre_alpha_hidrosina.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import hidrosina.gshp.net.pre_alpha_hidrosina.Model.Model;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dao.DaoQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoDefaultLayout;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoOption;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSection;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSimpleOption;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSimpleQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase.IdSeccion1;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.JsonFromFireBase.Question;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain2;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVRowMain;
import io.realm.RealmList;

public class Presenter {
    private static final String PATH="Seccion";
    private static final String PATH_SECCTION="IdSeccion2";
    private View view;
    private DtoDefaultLayout dtoDefaultLayout;
    private Model model;
    private List<ViewItem> viewItemsList;
    private List<ViewItems> viewsItemsList;
    private List<DtoSimpleQuestion> dtoQuestionList = new ArrayList<>();


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
       /* List<String> questions= new ArrayList<>();
        for (int i=0;i<10;i++){
            questions.add("¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?");
            Log.e("sergioq ",questions.get(i)+"");
        }
        return new RVMain(questions);*/
       return null;
    }
    public RVMain getAdapter( Context context){
       /* List<String> questions= new ArrayList<>();
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



        return new RVMain(questions,new RVRowMain(viewsItemsList,1),context); */
       return null;
    }
    public RVMain2 getAdapter(int type){
        List<DtoSimpleOption> dtoOptions;
        int options=1;
        for (int i=0;i<10;i++){
            dtoOptions= new RealmList<>();
            for (int j=0;j<options;j++){
                DtoSimpleOption dtoOption= new DtoSimpleOption();
                            dtoOption.setIdOption(j+"");
                            dtoOption.setValue("Sí-NO");
                dtoOptions.add(dtoOption);
            }
            DtoSimpleQuestion dtoQuestion= new DtoSimpleQuestion();
            dtoQuestion.setId_question(i+"");
            dtoQuestion.setId_secction(1+"");
            dtoQuestion.setId_type(type+"");
            dtoQuestion.setLength("0");
            dtoQuestion.setDescription("¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?");
            dtoQuestion.setRequeried("0");
            dtoQuestion.setVisibility("1");
           // dtoQuestion.setOption(dtoOptions);
            dtoQuestionList.add(dtoQuestion);
            /*dtoQuestionList.add(new DtoQuestion(i+"",1+"","0",type+"",0+"","¿SE ACTUALIZÖ LA INFORMACIÓN DE PRECIOS EN EL ANUNCIO INDEPENDIENTE Y LOS DISPENSARIOS DE ACUERDO AL CORREO ELECTRÓNICO? "+i+"?"
                    ,0+"",1+"",dtoOptions));*/
           // dtoQuestionList.add(new DtoQuestion(i+"","1",i+"","9","0","Foto","0","1",null));

        }

        return new RVMain2(dtoQuestionList,type);
    }
    private void setRvMain(RVMain2 adapter,Context context) {
        view.setRv(adapter,context);
    }
    public void initStetho(Context context){
        view.initStethoWithReal(context);
    }


    public void init() {
        setMenuTittle();
        setHeaderTittle();
        setRvMain(getAdapter(1),null);
    }
    public void init(Context context) {
        setMenuTittle();
        setHeaderTittle();
        setRvMain(getAdapter(1),context);
        initStetho(context);

    }

    public void setupRecyclerView(RecyclerView rvMain,Context context) {
        Log.e("sergioHola", "hola");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference reference= database.getReference("Prueba").child("nombre");
        DatabaseReference reference = database.getReference(PATH).child(PATH_SECCTION);
        DatabaseReference reference1 = database.getReference("Seccion").child("IdSeccion2").child("question");
        DatabaseReference reference2 = database.getReference("Seccion").child("IdSeccion2").child("question").child("1");

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Question question = dataSnapshot.getValue(Question.class);
                Log.e("sergioOnlyQu","sergio "+question.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    Question dtoQuestion = postData.getValue(Question.class);
                    Log.e("sergioQuestion1",dtoQuestion.toString());
                    // dtoQuestionList.add(dtoQuestion);
                }
                //Log.e("listQuestion", "List " + dtoQuestionList);
                /*
                Question question = dataSnapshot.getValue(Question.class);
                Log.e("sergioSnapshot2","hola2 "+question.toString()+"");*/
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                IdSeccion1 idSeccion1 = dataSnapshot.getValue(IdSeccion1.class);
               // String nombre = dataSnapshot.getValue(String.class);
                Log.e("sergioSnapshot","hola "+idSeccion1.toString()+"");
                Log.e("sergioE","sergio " + idSeccion1.getIdSeccion());
                String maxphoto=idSeccion1.getQuestion().get(1).getMaxPhoto();
                if (maxphoto!=null){
                    Log.e("sergioQuestion ","sergio " +maxphoto);
                }else{
                    Log.e("sergioQuestion ","sergio nel");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }



    public interface View {
        void changeMenuTittle(String info);
        void changeHeaderTittle(String info);
        void setRv(RVMain2 rvMain,Context context);
        void initStethoWithReal(Context context);
    }


}
