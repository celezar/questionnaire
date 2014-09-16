package me.zarko.questionnaire;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Set;
import me.zarko.questionnaire.controller.QuestionSetController;
import me.zarko.questionnaire.service.IQuestionService;
import me.zarko.questionnaire.view.QuestionSetView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Theme("questionnaire")
@SuppressWarnings("serial")
public class QuestionnaireUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = QuestionnaireUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        IQuestionService questionService = context.getBean("questionService", IQuestionService.class);
        QuestionSetController controller = new QuestionSetController(questionService);
        
        layout.addComponent(new QuestionSetView(controller));
        
        /*
        final Label testLabel = new Label();
        
        OptionGroup single = new OptionGroup("Single");
        single.setImmediate(true);
        single.addItem("kako je sto se radi");
        single.addItem("eo nista a ti");
        single.addItem("isto tako vala");
        single.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                System.out.println("object selected : " + event.getProperty().getValue());
                testLabel.setCaption(event.getProperty().getValue().toString());
            }
        });
        
        
        OptionGroup multi = new OptionGroup("Single");
        multi.setMultiSelect(true);
        multi.setImmediate(true);
        multi.addItem("Italija");
        multi.addItem("Njemacka");
        multi.addItem("Holandija");
        multi.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                System.out.println("multi object selected : " + event.getProperty().getValue());
                testLabel.setCaption(event.getProperty().getValue().toString());
                Set strings = (Set) event.getProperty().getValue();
            }
        });
        layout.addComponent(single);
        layout.addComponent(multi);
        layout.addComponent(testLabel);
                */
    }

}
