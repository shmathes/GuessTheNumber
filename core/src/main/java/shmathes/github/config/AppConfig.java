package shmathes.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import shmathes.github.*;

@Configuration
//@Import(GameConfig.class)
@ComponentScan(basePackages = "shmathes.github")
public class AppConfig
{
    // == bean methods ==
    //@Bean
    //public NumberGenerator numberGenerator()
    //{
    //    return new NumberGeneratorImpl();
    //}

    //@Bean
    //public Game game(){
    //    return new GameImpl();
    //}

    //@Bean
    //public MessageGenerator messageGenerator(){
    //    return new MessageGeneratorImpl();
    //}
}
