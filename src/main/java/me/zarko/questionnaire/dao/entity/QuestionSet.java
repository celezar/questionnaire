package me.zarko.questionnaire.dao.entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author zarko
 */
@Entity
public class QuestionSet {

    private Integer id;
    private String decsription;
    private Collection<Question> questions;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id; }

    public String getDecsription() { return decsription; }
    public void setDecsription(String decsription) { this.decsription = decsription; }

    @OneToMany(mappedBy = "questionSet")
    public Collection<Question> getQuestions() { return questions; }
    public void setQuestions(Collection<Question> questions) { this.questions = questions; }
    
    
}
