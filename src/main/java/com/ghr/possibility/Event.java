package com.ghr.possibility;

public class Event {
    private double possibility;

    Event(double possibility) {
        if (possibility < 0.0 || possibility > 1.0)
            throw new IllegalArgumentException("illegal possibility");
        this.possibility = possibility;
    }

    public Event negate() {
        return new Event(1.0 - this.possibility);
    }

    public Event and(Event event) {
        return new Event(this.possibility * event.possibility);
    }

    public Event or(Event event) {
        return new Event(1.0 - (1.0 - this.possibility) * (1.0 - event.possibility));
    }
}
