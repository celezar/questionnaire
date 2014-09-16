package me.zarko.questionnaire.service;

import java.util.ArrayList;
import me.zarko.questionnaire.dao.DaoService;
import me.zarko.questionnaire.model.Answer;
import me.zarko.questionnaire.model.Question;
import me.zarko.questionnaire.model.QuestionSet;

/**
 *
 * @author zarko
 */
public class HibernateQuestionService implements IQuestionService {

    @Override
    public QuestionSet getQuestionSet() {
        DaoService service = new DaoService();
        me.zarko.questionnaire.dao.entity.QuestionSet entitySet = service.getQuestionSetById(1);
        return getQuestionSetModel(entitySet);
    }

    private QuestionSet getQuestionSetModel(me.zarko.questionnaire.dao.entity.QuestionSet entitySet) {
        QuestionSet result = new QuestionSet();
        result.setDecsription(entitySet.getDecsription());
        ArrayList<Question> questions = new ArrayList<Question>();
        for (me.zarko.questionnaire.dao.entity.Question question : entitySet.getQuestions()) {
            questions.add(getQuestionModel(question));
        }
        result.setQuestions(questions);
        return result;
    }

    private Question getQuestionModel(me.zarko.questionnaire.dao.entity.Question question) {
        Question result = new Question();
        result.setQuestionText(question.getQuestionText());
        ArrayList<Answer> answers = new ArrayList<Answer>();
        int correctCount = 0;
        for (me.zarko.questionnaire.dao.entity.Answer answer : question.getAnswers()) {
            Answer answerModel = getAnswerModel(answer);
            if (answerModel.isCorrect()) correctCount++;
            answers.add(answerModel);
        }
        result.setMulitpleCorrect(correctCount > 1);
        result.setAnswers(answers);
        return result;
    }

    private Answer getAnswerModel(me.zarko.questionnaire.dao.entity.Answer answer) {
        Answer result = new Answer();
        result.setAnswerText(answer.getAnswerText());
        result.setCorrect(answer.isCorrect());
        return result;
    }

}
