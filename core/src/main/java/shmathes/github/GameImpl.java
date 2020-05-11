package shmathes.github;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game
{
    // == constants ==

    //Replacing with SLF4J annotation
    //private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Getter(AccessLevel.NONE) //Lombok will not generate a getter for this field
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter //Generates setter method setGuess()
    private int guess;

    // == constructors ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount)
    {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    //Resets game to the starting values
    public void reset()
    {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    // == public methods ==

    //Replaced with the Getter annotation
//    @Override
//    public int getNumber()
//    {
//        return number;
//    }
//    @Override
//    public int getGuess()
//    {
//        return guess;
//    }

    //Replaced with the Lombok Setter annotation
//    @Override
//    public void setGuess(int guess)
//    {
//        this.guess = guess;
//    }


    //Replaced with the Lombok Getter annotation
//    @Override
//    public int getSmallest()
//    {
//        return smallest;
//    }
//    @Override
//    public int getBiggest()
//    {
//        return largest;
//    }
//    @Override
//    public int getRemainingGuesses()
//    {
//        return remainingGuesses;
//    }
//    @Override
//    public int getGuessCount(){return guessCount;}

    @Override
    public void check()
    {
        checkValidNumberRange();

        if(validNumberRange)
        {
            if(guess > number)
            {
                biggest = guess - 1;
            }
            if(guess < number)
            {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange()
    {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon()
    {
        return guess == number;
    }

    @Override
    public boolean isGameLost()
    {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange()
    {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
