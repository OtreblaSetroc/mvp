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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class DaoAnswer {
    private Realm realm;
    private DatabaseReference mDatabase;
    private List<DtoAnswer> dtoAnswerList;

    public DaoAnswer(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public long autoIncrementId(){
        realm.beginTransaction();
        Number maxValue = realm.where(DtoAnswer.class).max("idAnswer");
        long pk = (maxValue != null) ? (long)maxValue + 1 : 1;
        realm.commitTransaction();
        return pk;
    }

    public List<DtoAnswer> selectRealm(String idReport) {
        realm.beginTransaction();
        ArrayList<DtoAnswer> dtoAnswerList = new ArrayList(realm.where(DtoAnswer.class).equalTo("idReport", idReport).findAll());
        realm.commitTransaction();
        Log.i("selectAnswers", dtoAnswerList.toString());
        return dtoAnswerList;
    }

    public int insertRealm(long id, List<DtoAnswer> dtoAnswers) {
        int resp = 0;
        for (int i = 0; i < dtoAnswers.size(); i++) {
            dtoAnswers.get(i).setIdAnswer(autoIncrementId() + i);
            dtoAnswers.get(i).setReportIdentifier(id);
            Log.i("DtoAnswer", dtoAnswers.get(i).toString());
        }
        realm.beginTransaction();
        realm.insertOrUpdate(dtoAnswers);
        realm.commitTransaction();
        return resp;
    }


    public int deleteRealm() {
        int resp = 0;
        realm.beginTransaction();


        realm.commitTransaction();
        return resp;
    }


    public int updateRealm(List<DtoAnswer> dtoAnswers) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoAnswers);
        realm.commitTransaction();
        return resp;
    }

    public List<DtoAnswer> selectFirebase(int idReport) {
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + idReport).child("answer");
        dtoAnswerList = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    DtoAnswer dtoAnswer = postData.getValue(DtoAnswer.class);
                    dtoAnswerList.add(dtoAnswer);
                }
                Log.e("listAnswer", "List " + dtoAnswerList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return dtoAnswerList;
    }

    public int insertFirebase(DtoReport dtoReport, Map<String, DtoAnswer> dtoAnswerList) {
        int resp = 0;
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer");
        mDatabase.setValue(dtoAnswerList);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoReport dtoReport, final DtoAnswer dtoAnswer) {
        int resp = 0;
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("answerId" + dtoAnswer.getIdAnswer());
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, Object> resultUpdate = new HashMap<>();
                resultUpdate.put("answer", dtoAnswer.getAnswer());
                dataSnapshot.getRef().updateChildren(resultUpdate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return resp;
    }


}
