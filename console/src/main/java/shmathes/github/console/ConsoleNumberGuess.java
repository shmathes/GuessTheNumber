package shmathes.github.console;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import shmathes.github.Game;
import shmathes.github.MessageGenerator;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess
{
    // == constants ==
    //Replacing with lombok SLF4J annotation
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == constructors ==

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator)
    {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //Once the application context has been intialized, this method will be fired.
    @EventListener(ContextRefreshedEvent.class)
    public void start()
    {
        log.info("start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }
}
