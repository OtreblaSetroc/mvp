package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hidrosina.gshp.net.pre_alpha_hidrosina.AppDb;
import io.realm.Realm;

public class DtoSimpleReport {
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
    private List<DtoSimpleAnswer> answers = new ArrayList<>();

    public long getReportIdentifier() {
        return reportIdentifier;
    }

    public void setReportIdentifier(long reportIdentifier) {
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

    public List<DtoSimpleAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<DtoSimpleAnswer> answers) {
        this.answers = answers;
    }

    public void convertSimple(Context context, DtoReport dtoReport){
        Realm realm = AppDb.getAppDbRealm(context);
        this.reportIdentifier = dtoReport.getReportIdentifier();
        this.identifier = dtoReport.getIdentifier();
        this.startedAt = dtoReport.getStartedAt();
        this.finishedAt = dtoReport.getFinishedAt();
        this.lat = dtoReport.getLat();
        this.lng = dtoReport.getLng();
        this.deviceId = dtoReport.getDeviceId();
        this.data = dtoReport.getData();
        this.siteInterestId = dtoReport.getSiteInterestId();
        this.statusSend = dtoReport.getStatusSend();
//        for(DtoAnswer dtoAnswer : dtoReport.getAnswers()){
//            this.answers.add(dtoAnswer.convertToSimple());
//        }
    }
}
