package com.algorithm.comparison.matcher;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinder {

    public static List<ContactMatchResult> findDuplicates(List<Contact> contacts) {
        List<ContactMatchResult> results = new ArrayList<>();
        for (int i = 0; i < contacts.size() - 1; i++) {
            Contact source = contacts.get(i);
            for (int j = i + 1; j < contacts.size(); j++) {
                int score = calculateMatchScore(source, contacts.get(j));
                if (score > 0) {
                    String accuracy = scoreToAccuracy(score);
                    results.add(new ContactMatchResult(source.id, contacts.get(j).id, accuracy));
                }
            }
        }
        return results;
    }

    public static int calculateMatchScore(Contact a, Contact b) {
        int score = 0;
        if (a.email.equalsIgnoreCase(b.email)) score += 30;
        if (a.firstName.equalsIgnoreCase(b.firstName)) score += 10;
        if (a.lastName.equalsIgnoreCase(b.lastName)) score += 10;
        if (a.zipCode.equalsIgnoreCase(b.zipCode)) score += 5;
        if (a.address.equalsIgnoreCase(b.address)) score += 25;
        return score;
    }

    public static String scoreToAccuracy(int score) {
        if (score >= 50) return MatchEnum.VERY_HIGH.toString();
        if (score >= 40) return MatchEnum.HIGH.toString();
        if (score >= 25) return MatchEnum.MEDIUM.toString();
        if (score >= 10) return MatchEnum.LOW.toString();
        return MatchEnum.VERY_LOW.toString();
    }
}

//
//public class DuplicateFinder {
//    public static List<ContactMatchResult> findDuplicates(List<Contact> contacts) {
//        List<ContactMatchResult> results = new ArrayList<>();
//        for (int i = 0; i < contacts.size(); i++) {
//            Contact source = contacts.get(i);
//            for (int j = i + 1; j < contacts.size(); j++) {
//                Contact target = contacts.get(j);
//                int score = calculateMatchScore(source, target);
//                if (score > 0) {
//                    String accuracy = scoreToAccuracy(score);
//                    results.add(new ContactMatchResult(source.id, target.id, accuracy));
//                }
//            }
//        }
//        return results;
//    }
//
//    private static int calculateMatchScore(Contact a, Contact b) {
//        int score = 0;
//        if (a.email.equalsIgnoreCase(b.email)) score += 50;
//        if (a.address.equalsIgnoreCase(b.address)) score += 30;
//        if (a.zipCode.equalsIgnoreCase(b.zipCode)) score += 20;
//        if (a.firstName.equalsIgnoreCase(b.firstName) && a.lastName.equalsIgnoreCase(b.lastName)) score += 50;
//        return score;
//    }
//
//    private static String scoreToAccuracy(int score) {
//        if (score >= 100) return "Very High";
//        if (score >= 80) return "High";
//        if (score >= 50) return "Medium";
//        if (score >= 20) return "Low";
//        return "None";
//    }
//}