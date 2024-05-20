package com.algorithm.comparison.matcher;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateFinderTest {

    @Test
    void testCalculateMatchScore() {
        Contact contact1 = new Contact(1, "John", "Doe", "john.doe@example.com", "12345", "100 Some St");
        Contact contact2 = new Contact(2, "John", "Doe", "john.doe@example.com", "12345", "100 Some St");
        Contact contact3 = new Contact(3, "Jane", "Smith", "jane.smith@example.com", "54321", "200 Any St");

        assertEquals(80, DuplicateFinder.calculateMatchScore(contact1, contact2), "Scores should match exactly.");
        assertEquals(0, DuplicateFinder.calculateMatchScore(contact1, contact3), "Scores should not match.");
    }


    @Test
    void testFindDuplicates() {
        Contact contact1 = new Contact(1, "John", "Doe", "john.doe@example.com", "12345", "100 Some St");
        Contact contact2 = new Contact(2, "Martin", "Garcia", "Martin.Garcia@example.com", "52345", "700 Some St");
        Contact contact3 = new Contact(3, "Jane", "Doe", "jane.doe@example.com", "12345", "101 Some St");
        Contact contact4 = new Contact(4, "John", "Doe", "", "12345", "100 Some St");
        Contact contact5 = new Contact(5, "John", "Doe", null, "12345", "100 Some St");
        
        List<Contact> contacts = Arrays.asList(contact1, contact2, contact3, contact4, contact5);
        List<ContactMatchResult> results = DuplicateFinder.findDuplicates(contacts);
        System.out.println(results.toString());

        assertEquals(1, results.get(0).sourceId, "Source ID should be 1.");
        assertEquals(3, results.get(0).matchId, "Match ID should be 3.");
        assertEquals("LOW", results.get(0).accuracy, "Accuracy should be Very High.");

        assertEquals(1, results.get(1).sourceId, "Source ID should be 1.");
        assertEquals(4, results.get(1).matchId, "Match ID should be 4.");

    }
}