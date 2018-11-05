package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DtoReport  extends RealmObject {
    @PrimaryKey
    @NonNull
    private long reportIdentifier;
    private String identifier;
    private String startedAt;
    private String finishedAt;
    private String lat;
    private String lng;
    private String deviceId;
    private String data;
    private String siteInterestId;
    private String statusSend;
    private RealmList<DtoAnswer> answers = new RealmList<>();
    @NonNull
    public long getReportIdentifier() {
        return reportIdentifier;
    }

    public void setReportIdentifier(@NonNull long reportIdentifier) {
        this.reportIdentifier = reportIdentifier;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSiteInterestId() {
        return siteInterestId;
    }

    public void setSiteInterestId(String siteInterestId) {
        this.siteInterestId = siteInterestId;
    }

    public String getStatusSend() {
        return statusSend;
    }

    public void setStatusSend(String statusSend) {
        this.statusSend = statusSend;
    }

    public RealmList<DtoAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(RealmList<DtoAnswer> answers) {
        this.answers = answers;
    }
    public DtoSimpleReport covertToSimple(){
        List<DtoSimpleAnswer> dtoAnswers = new ArrayList<>();
        DtoSimpleReport dtoSimpleReport = new DtoSimpleReport();
        dtoSimpleReport.setReportIdentifier(this.reportIdentifier);
        dtoSimpleReport.setIdentifier(this.identifier);
        dtoSimpleReport.setStartedAt(this.startedAt);
        dtoSimpleReport.setFinishedAt(this.finishedAt);
        dtoSimpleReport.setLat(this.lat);
        dtoSimpleReport.setLng(this.lng);
        dtoSimpleReport.setDeviceId(this.deviceId);
        dtoSimpleReport.setData(this.data);
        dtoSimpleReport.setSiteInterestId(this.siteInterestId);
        dtoSimpleReport.setStatusSend(this.statusSend);
        for(DtoAnswer dtoAnswer : this.answers){
            Log.i("respuestasAns", "dto" + dtoAnswer);
            dtoAnswers.add(dtoAnswer.convertToSimple());
        }
        dtoSimpleReport.setAnswers(dtoAnswers);

        Log.i("respuestas", dtoSimpleReport.getAnswers().toString());

        return dtoSimpleReport;
    }


}
