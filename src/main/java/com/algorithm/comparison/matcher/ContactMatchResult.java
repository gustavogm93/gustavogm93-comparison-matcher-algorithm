package com.algorithm.comparison.matcher;

public class ContactMatchResult {
    int sourceId;
    int matchId;
    String accuracy;

    public ContactMatchResult(int sourceId, int matchId, String accuracy) {
        this.sourceId = sourceId;
        this.matchId = matchId;
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "ContactMatchResult{" +
                "sourceId=" + sourceId +
                ", matchId=" + matchId +
                ", accuracy='" + accuracy + '\'' +
                '}';
    }
}
