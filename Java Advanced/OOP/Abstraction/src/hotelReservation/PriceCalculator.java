package hotelReservation;

public class PriceCalculator {
    double dailyPrice;
    int days;
    Season season;
    Discount discount;

    public PriceCalculator(double dailyPrice, int days, String season, String discount) {
        this.dailyPrice = dailyPrice;
        this.days = days;
        this.season = Season.valueOf(season.toUpperCase());
        this.discount = Discount.valueOf(discount.toUpperCase());
    }

    public double calculate() {
        return this.dailyPrice * this.days * this.season.getPriceMultiplier() * (1 - this.discount.getDiscount());
    }
}
