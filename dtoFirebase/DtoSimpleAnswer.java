package redes.com.pruebaanswer.firebase.Dto;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;

public class DtoSimpleAnswer {
    private long idAnswer;
    private long reportIdentifier;
    private String indputId; //ID DE QUESTION
    private String answer;
    private String createdAt;

    public long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getIndputId() {
        return indputId;
    }

    public void setIndputId(String indputId) {
        this.indputId = indputId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getReportIdentifier() {
        return reportIdentifier;
    }

    public void setReportIdentifier(long reportIdentifier) {
        this.reportIdentifier = reportIdentifier;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void convertToSimple(DtoAnswer dtoAnswer){
        this.idAnswer = dtoAnswer.getIdAnswer();
        this.indputId = dtoAnswer.getIndputId(); //ID DE QUESTION
        this.reportIdentifier = dtoAnswer.getReportIdentifier();
        this.answer = dtoAnswer.getAnswer();
        this.createdAt = dtoAnswer.getCreatedAt();
    }

    @Override
    public String toString() {
        return "DtoSimpleAnswer{" +
                "idAnswer='" + idAnswer + '\'' +
                ", indputId='" + indputId + '\'' +
                ", reportIdentifier='" + reportIdentifier + '\'' +
                ", answer='" + answer + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
