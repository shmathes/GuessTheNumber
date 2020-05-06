package shmathes.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container) - using XML setup
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //create context (container) - linking to the AppConfig class
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        //log generator number
        log.info("number = {}", number);

        //Get game bean from context (container)
        //Game game = context.getBean(Game.class);

        //call reset method
        //game.reset();

        //Get MessengerGenerator bean from context
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //Call MessageGenerator methods
        String mainMessage = messageGenerator.getMainMessage();
        String resultMessage = messageGenerator.getResultMessage();

        //log message generator messages
        log.info("Main message = {}", mainMessage);
        log.info("Result message = {}", resultMessage);

        //close context
        context.close();
    }
}
