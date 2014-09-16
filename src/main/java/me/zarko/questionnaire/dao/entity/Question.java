package me.zarko.questionnaire.dao.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author zarko
 */
@Entity
public class Question {

    private Integer id;
    private String questionText;
    private QuestionSet questionSet;
    private List<Answer> answers;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Column
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    @ManyToOne
    @JoinColumn(name = "questionSet", referencedColumnName = "id")
    public QuestionSet getQuestionSet() { return questionSet; }
    public void setQuestionSet(QuestionSet questionSet) { this.questionSet = questionSet; }

    @OneToMany(mappedBy = "question")
    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> answers) { this.answers = answers; }

}
