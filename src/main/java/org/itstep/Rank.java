package org.itstep;

public enum Rank {
    JACK(10, 74), QUEEN(10, 81), KING(10, 75), ACE(10, 65), _2_(2, 2), _3_(3, 3), _4_(4, 4), _5_(5, 5), _6_(6, 6), _7_(7, 7), _8_(8, 8), _9_(9, 9), _10_(10, 10);
    private int meaning;
    private int points;

    Rank(int points, int meaning) {
        this.meaning = meaning;
        this.points = points;
    }

    public int getMeaning() {
        return meaning;
    }

    public void setMeaning(int meaning) {
        this.meaning = meaning;
    }

    public int getPoints() {
        return points;
    }
}
