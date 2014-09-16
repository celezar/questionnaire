package me.zarko.questionnaire.dao;

import javax.transaction.Transactional;
import me.zarko.questionnaire.dao.entity.QuestionSet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author zarko
 */
public class DaoService {

    private SessionFactory sessionFactory;

    public DaoService() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public QuestionSet getQuestionSetById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        QuestionSet questionSet = (QuestionSet) session.get(QuestionSet.class, id);
        session.getTransaction().commit();
        return questionSet;
    }
}
