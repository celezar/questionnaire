package me.zarko.questionnaire.model;

import java.util.List;

/**
 *
 * @author zarko
 */
public class Question {
    
    private String questionText;
    private List<Answer> answers;
    private boolean mulitpleCorrect;
    private boolean answeredCorrect;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isMulitpleCorrect() {
        return mulitpleCorrect;
    }

    public void setMulitpleCorrect(boolean mulitpleCorrect) {
        this.mulitpleCorrect = mulitpleCorrect;
    }

    public boolean isAnsweredCorrect() {
        return answeredCorrect;
    }

    public void setAnsweredCorrect(boolean answeredCorrect) {
        this.answeredCorrect = answeredCorrect;
    }

}
