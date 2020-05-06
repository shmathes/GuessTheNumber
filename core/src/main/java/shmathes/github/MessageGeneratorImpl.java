package shmathes.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator
{
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void reset(){
        log.info("MessageGeneratorImpl - reset called.");
    }

    @Override
    public String getMainMessage() {
        return "getMainMessage - Called";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage - Called";
    }
}
