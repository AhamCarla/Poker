public enum PokerColor {
    C("C"), D("D"), H("H"), S("S");

    private String color;

    PokerColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
