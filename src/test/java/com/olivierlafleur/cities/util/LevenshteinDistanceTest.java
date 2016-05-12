package com.olivierlafleur.cities.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevenshteinDistanceTest {
    @Test
    public void distanceOfOneCharacter() {
        int distance = LevenshteinDistance.computeLevenshteinDistance("Bonjour", "bonjour");

        assertEquals(1, distance);
    }

    @Test
    public void distanceOfZeroCharacter() {
        int distance = LevenshteinDistance.computeLevenshteinDistance("bonjour", "bonjour");

        assertEquals(0, distance);
    }

    @Test
    public void distanceOfTwoCharacters() {
        int distance = LevenshteinDistance.computeLevenshteinDistance("hello", "allo");

        assertEquals(2, distance);
    }
}
