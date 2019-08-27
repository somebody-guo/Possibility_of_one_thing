package com.ghr.possibility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @Test
    public void negate() {
        //given
        Event oneThing = new Event(0.3);
        //when
        Event negateTheThing = oneThing.negate();
        //then
        assertThat(negateTheThing).hasFieldOrPropertyWithValue("possibility", 0.7);
    }

    @Test
    public void and() {
        //given
        Event oneThing = new Event(0.5);
        Event anotherThing = new Event(0.5);
        //when
        Event oneAndAnother = oneThing.and(anotherThing);
        //then
        assertThat(oneAndAnother).hasFieldOrPropertyWithValue("possibility", 0.25);
    }

    @Test
    public void or() {
        //given
        Event oneThing = new Event(0.5);
        Event anotherThing = new Event(0.5);
        //when
        Event oneOrAnother = oneThing.or(anotherThing);
        //then
        assertThat(oneOrAnother).hasFieldOrPropertyWithValue("possibility", 0.75);
    }
}
