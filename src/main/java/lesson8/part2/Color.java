package lesson8.part2;

public enum Color {
    BLACK("Черный"),
    WHITE("Белый"),
    GREY("Серый");

    private String russianColor;

    public String getRussianColor() {
        return russianColor;
    }

    public void setRussianColor(String russianColor) {
        this.russianColor = russianColor;
    }

    Color(String russianColor) {
        this.russianColor = russianColor;
    }

    @Override
    public String toString() {
        return "Color{}";
    }
}
