package me.zarko.questionnaire.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author zarko
 */
@Entity
public class Answer {

    private Integer id;
    private String answerText;
    private Question question;
    private boolean correct;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "id")
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    
}
