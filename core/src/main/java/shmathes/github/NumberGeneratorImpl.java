package shmathes.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator
{

    // == fields ==
    private final Random random = new Random();

    private final int minNumber;

    private final int maxNumber;

    // == constructors ==

    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber)
    {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    // == public methods ==
    @Override
    public int next()
    {
        //min = 5; max = 50 -> max-min=45 -> range 0-45 + min -> 5-50
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMinNumber()
    {
        return minNumber;
    }

    @Override
    public int getMaxNumber()
    {
        return maxNumber;
    }
}
