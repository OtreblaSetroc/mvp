package redes.com.pruebaanswer.realm.Dao.Dto;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import redes.com.pruebaanswer.firebase.Dto.DtoSimpleAnswer;

public class DtoAnswer extends RealmObject {
    @PrimaryKey
    @NonNull
    private long idAnswer;
    private long reportIdentifier;
    private String indputId; //ID DE QUESTION
    private String answer;
    private String createdAt;

    @NonNull
    public long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(@NonNull long idAnswer) {
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

    public DtoSimpleAnswer convertToSimple(){
        DtoSimpleAnswer dtoSimpleAnswer = new DtoSimpleAnswer();
        dtoSimpleAnswer.setIndputId(this.indputId);
        dtoSimpleAnswer.setReportIdentifier(this.reportIdentifier);
        dtoSimpleAnswer.setAnswer(this.answer);
        dtoSimpleAnswer.setCreatedAt(this.createdAt);

        return dtoSimpleAnswer;
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
