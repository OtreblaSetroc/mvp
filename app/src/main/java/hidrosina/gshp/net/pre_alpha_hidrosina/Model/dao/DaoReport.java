package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dao;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import hidrosina.gshp.net.pre_alpha_hidrosina.AppDb;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoAnswer;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoReport;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSimpleReport;
import io.realm.Realm;
import io.realm.RealmList;

public class DaoReport {
    private Realm realm;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    public DaoReport(Context context) {
        realm = AppDb.getAppDbRealm(context);
        //TODO INSERTAR ESTAS DE UNA MEJOR FORMA
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();
    }
    public long autoIncrementIdReport() {
        realm.beginTransaction();
        Number maxValue = realm.where(DtoReport.class).max("reportIdentifier");
        long pk = (maxValue != null) ? (long) maxValue + 1 : 1;
        realm.commitTransaction();
        return pk;
    }

    public long autoIncrementIdAnswer() {
        realm.beginTransaction();
        Number maxValue = realm.where(DtoAnswer.class).max("idAnswer");
        long pk = (maxValue != null) ? (long) maxValue + 1 : 1;
        realm.commitTransaction();
        return pk;
    }

    public DtoReport selectRealm(int idReport) {
        realm.beginTransaction();
        DtoReport dtoReport = realm.where(DtoReport.class).equalTo("reportIdentifier", idReport).findFirst();
        realm.commitTransaction();
        Log.i("selectReports", dtoReport.toString());
        return dtoReport;
    }

    public List<DtoReport> selectToSendRealm() {
        realm.beginTransaction();
        ArrayList<DtoReport> dtoReports = new ArrayList(realm.where(DtoReport.class).equalTo("statusSend", "0").findAll());
        realm.commitTransaction();
        Log.i("selectReports", dtoReports.toString());
        return dtoReports;
    }

    public int insertRealm(List<DtoReport> dtoReportList) {
        int resp = 0;
        RealmList<DtoReport> dtoReportRealmList = new RealmList<>();
        realm.beginTransaction();
        dtoReportRealmList.addAll(dtoReportList);
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }

    public int insertRealm(DtoReport dtoReportList) {
        int resp = 0;
        dtoReportList.setReportIdentifier(autoIncrementIdReport());
        realm.beginTransaction();
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }

    public void insertAnswersRealm(DtoReport dtoReport, RealmList<DtoAnswer> dtoAnswers) {
        for (int i = 0; i < dtoAnswers.size(); i++) {
            dtoAnswers.get(i).setIdAnswer(autoIncrementIdAnswer() + i);
            dtoAnswers.get(i).setReportIdentifier(dtoReport.getReportIdentifier());
            Log.i("DtoAnswer", dtoAnswers.get(i).toString());
        }
        realm.beginTransaction();
        dtoReport.getAnswers().addAll(dtoAnswers);
        realm.insertOrUpdate(dtoReport);
        realm.commitTransaction();
    }


    public int deleteRealm() {
        int resp = 0;
        realm.beginTransaction();

        realm.commitTransaction();
        return resp;
    }


    public int updateRealm(DtoReport dtoReport) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoReport);
        realm.commitTransaction();
        return resp;
    }


    public List<DtoAnswer> selectFirebase() {
        List<DtoAnswer> dtoAnswerList = new ArrayList<>();


        return dtoAnswerList;
    }

    public int insertFirebase(DtoSimpleReport dtoSimpleReport) {
        int resp = 0;
        mDatabase.child("reports").child("reportIdentifier" + dtoSimpleReport.getReportIdentifier()).setValue(dtoSimpleReport);
        Log.e("sendFirebase", "enviado");

        return resp;
    }

    public int insertFirebase(List<DtoSimpleReport> dtoReports) {
        int resp = 0;
        mDatabase.child("reports").setValue(dtoReports);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoAnswer dtoAnswer) {
        int resp = 0;


        return resp;
    }
}
