package hidrosina.gshp.net.pre_alpha_hidrosina.Presenter;

import java.util.List;

public class ViewItems {
    private String idQuestion;
    private int type;
    private String question;
    private List<ViewItem> viewItems;

    public ViewItems(final String idQuestion, final String question,final List<ViewItem> viewItems,final int type) {
        this.idQuestion = idQuestion;
        this.question=question;
        this.viewItems = viewItems;
        this.type=type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ViewItems(){}

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public List<ViewItem> getViewItems() {
        return viewItems;
    }

    public void setViewItems(List<ViewItem> viewItems) {
        this.viewItems = viewItems;
    }


}
