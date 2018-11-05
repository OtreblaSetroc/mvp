package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoQuestion;

public class DaoQuestion {
    private Realm realm;
    private DatabaseReference mDatabase;
    private List<DtoQuestion> dtoQuestionList;

    public DaoQuestion(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public List<DtoQuestion> selectRealm(int idReport) {
        realm.beginTransaction();
        ArrayList<DtoQuestion> dtoQuestions = new ArrayList(realm.where(DtoQuestion.class).equalTo("id_report", idReport).findAll());
        realm.commitTransaction();
        return dtoQuestions;
    }

    public int insertRealm(List<DtoQuestion> dtoQuestionList) {
        int resp = 0;
        RealmList<DtoQuestion> dtoQuestions = new RealmList<>();
        realm.beginTransaction();
        dtoQuestions.addAll(dtoQuestionList);
        realm.commitTransaction();
        return resp;
    }


    public int deleteRealm() {
        int resp = 0;
        realm.beginTransaction();


        realm.commitTransaction();
        return resp;
    }


    public int updateRealm(DtoQuestion dtoQuestion) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoQuestion);
        realm.commitTransaction();
        return resp;
    }

    public List<DtoQuestion> selectFirebase(int idSeccion) {
        mDatabase = FirebaseDatabase.getInstance().getReference("Seccion").child("IdSeccion" + idSeccion).child("Question");
        dtoQuestionList = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    DtoQuestion dtoQuestion = postData.getValue(DtoQuestion.class);
                    dtoQuestionList.add(dtoQuestion);
                }
                Log.e("listQuestion", "List " + dtoQuestionList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return dtoQuestionList;
    }

    public int insertFirebase(int idSeccion) {
        int resp = 0;
//        mDatabase.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("id_answer" + dtoAnswer.getIdAnswer()).setValue(dtoAnswer);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoQuestion dtoAnswer) {
        int resp = 0;


        return resp;
    }

}
