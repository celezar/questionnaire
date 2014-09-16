package me.zarko.questionnaire.view;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;
import java.util.Set;
import me.zarko.questionnaire.model.Answer;
import me.zarko.questionnaire.model.Question;

/**
 *
 * @author zarko
 */
public class QuestionView extends VerticalLayout {


    public QuestionView(final Question question) {
        OptionGroup answerGroup = new OptionGroup();
        answerGroup.setMultiSelect(question.isMulitpleCorrect());
        for (Answer answer : question.getAnswers()) {
            Item item = answerGroup.addItem(answer);
            answerGroup.setItemCaption(answer, answer.getAnswerText());
        }
        answerGroup.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                for(Answer answer: question.getAnswers())
                    answer.setSelected(false);
                if(question.isMulitpleCorrect()){
                    Set<Answer> answers = (Set<Answer>) event.getProperty().getValue();
                    for(Answer answer : answers)
                        answer.setSelected(true);
                } else {
                    Answer answer = (Answer) event.getProperty().getValue();
                    answer.setSelected(true);
                }
            }
        });
        this.addComponent(new Label(question.getQuestionText()));
        this.addComponent(answerGroup);
    }
}
