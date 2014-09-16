package me.zarko.questionnaire.controller;

import me.zarko.questionnaire.model.Answer;
import me.zarko.questionnaire.model.Question;
import me.zarko.questionnaire.model.QuestionSet;
import me.zarko.questionnaire.service.IQuestionService;

/**
 *
 * @author zarko
 */
public class QuestionSetController {
    
    private final QuestionSet model;
    
    public QuestionSetController(IQuestionService questionService){
        model = questionService.getQuestionSet();
    }
    
    public String evaluate(){
        int correctAnswers = 0;
        for (Question question : model.getQuestions()){
            if (isAnswerCorrect(question))
                correctAnswers++;
        }
        return "Correct answers: " + correctAnswers + " out of " + model.getQuestions().size();
    }
    
    private boolean isAnswerCorrect(Question question){
        boolean result =  true;
        for (Answer answer: question.getAnswers()){
            if (answer.isCorrect() != answer.isSelected()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public QuestionSet getModel() {
        return model;
    }

}
