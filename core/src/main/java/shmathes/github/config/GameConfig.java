package shmathes.github.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import shmathes.github.GuessCount;
import shmathes.github.MaxNumber;
import shmathes.github.MinNumber;

@Configuration
@ComponentScan(basePackages = "shmathes.github")
@PropertySource("classpath:config/game.properties")
public class GameConfig
{
    // == fields ==
    @Value("${game.minNumber:0}")
    public int minNumber;

    //pulling value from game.properties
    //If value from properties file isn't found, assign 20 as default
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
