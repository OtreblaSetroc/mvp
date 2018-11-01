package hidrosina.gshp.net.pre_alpha_hidrosina.Model.dao;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoQuestion;
import io.realm.Realm;

public class DaoQuestion {
    private Realm realm;
    private DatabaseReference mDatabase;
    private List<DtoQuestion> dtoQuestionList;
}
