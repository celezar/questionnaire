package me.zarko.questionnaire.model;

import java.util.List;

/**
 *
 * @author zarko
 */
public class QuestionSet {
    
    private String decsription;
    private List<Question> questions;

    public String getDecsription() {
        return decsription;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
