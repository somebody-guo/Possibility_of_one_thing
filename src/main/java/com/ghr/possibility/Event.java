package com.ghr.possibility;

import java.math.BigDecimal;

public class Event {
    private String eventAction;
    BigDecimal eventPossibility = new BigDecimal("0.0");

    Event(String eventAction) {
        this.eventAction = eventAction;
    }

    public void setEventPossibility(double eventPossibility) throws Exception {
        if(eventPossibility < 0.0 || eventPossibility > 1.0)
            throw new Exception("illegal Possibility");
        this.eventPossibility = BigDecimal.valueOf(eventPossibility);
    }

    public double possibilityOfOccurrence(Event... events) {
        BigDecimal output = this.eventPossibility;
        for (Event event : events) {
            output = output.multiply(BigDecimal.valueOf(event.possibilityOfOccurrence()));
        }
        return output.doubleValue();
    }
}
