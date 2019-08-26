package com.ghr.possibility;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {
    double delta = 0.000000000000000001;

    @Test
    public void possibilityOfOccurrence() {
        //given
        Event headUp = new Event("toss a coin and head up");
        Event tailUp = new Event("toss a coin and tail up");
        try {
            headUp.setEventPossibility(0.5);
            tailUp.setEventPossibility(0.5);
        } catch (Exception e) {
            System.out.println("catch Exception: illegal possibility");
        }
        //when
        Double possibilityOfHeadUp = headUp.possibilityOfOccurrence();
        Double possibilityOfOneHeadUpAndOneTailUp = headUp.possibilityOfOccurrence(tailUp);
        Double possibilityOfTwoHeadUp = headUp.possibilityOfOccurrence(headUp);
        //then
        Assert.assertEquals(0.5, possibilityOfHeadUp, delta);
        Assert.assertEquals(0.25, possibilityOfOneHeadUpAndOneTailUp, delta);
        Assert.assertEquals(0.25, possibilityOfTwoHeadUp, delta);
    }
}
