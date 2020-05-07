package shmathes.github.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shmathes.github.config.AppConfig;
import shmathes.github.config.GameConfig;

public class Main
{
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container) - using XML setup
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //create context (container) - linking to the AppConfig class
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        //close context
        context.close();
    }
}
