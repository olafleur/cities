package com.olivierlafleur.cities.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevenshteinDistanceTest {
    @Test
    public void distanceOfOneCharacter() {
        int distance = LevenshteinDistance.compute("Bonjour", "bonjour");

        assertEquals(1, distance);
    }

    @Test
    public void distanceOfZeroCharacter() {
        int distance = LevenshteinDistance.compute("bonjour", "bonjour");

        assertEquals(0, distance);
    }

    @Test
    public void distanceOfTwoCharacters() {
        int distance = LevenshteinDistance.compute("hello", "allo");

        assertEquals(2, distance);
    }
}
