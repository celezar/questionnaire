package me.zarko.questionnaire.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import me.zarko.questionnaire.controller.QuestionSetController;
import me.zarko.questionnaire.model.QuestionSet;

/**
 *
 * @author zarko
 */
public class QuestionSetView extends VerticalLayout{
    
    private final QuestionSetController controller;
    private final QuestionSet model;
    private int questionPosition = 0;
    
    public QuestionSetView(QuestionSetController controller){
        this.controller = controller;
        this.model = controller.getModel();
        this.addComponent(new QuestionView(model.getQuestions().get(questionPosition)));
        this.addComponent(getNextButton());
    }
    
    private Button getNextButton(){
        Button button = new Button("Next Question");
        final VerticalLayout that = this;
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                questionPosition++;
                if (questionPosition < model.getQuestions().size()){
                    that.removeComponent(that.getComponent(0));
                    that.addComponent(new QuestionView(model.getQuestions().get(questionPosition)), 0);
                } else {
                    that.removeAllComponents();
                    that.addComponent(new Label(controller.evaluate()));
                }
            }
        });
        return button;
    }

}
