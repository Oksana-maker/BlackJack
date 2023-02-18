package org.itstep;

public enum Suit {
    HEART(3), DIAMOND(4), CLUB(5), SPADE(6);
    public int view;

    Suit(int view) {
        this.view = view;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}

