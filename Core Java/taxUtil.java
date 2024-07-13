public class TaxUtil {
    private static final double RATE = 0.15;
 
    public double calculateTax(double amount) {
        return amount * RATE;
    }
}
