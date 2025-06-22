import java.util.Arrays;
import java.util.List;

public class FinancialForecast {
    public static double forecastNextMonth(List<Double> revenues) {
        int size = revenues.size();
        if (size < 3) {
            throw new IllegalArgumentException("Need at least 3 months of data.");
        }
        double sum = 0;
        for (int i = size - 3; i < size; i++) {
            sum += revenues.get(i);
        }
        return sum / 3;
    }

    public static void main(String[] args) {
        List<Double> revenues = Arrays.asList(12000.0, 12500.0, 12800.0, 13000.0, 13300.0, 13600.0);
        double forecast = forecastNextMonth(revenues);
        System.out.println("Forecasted Revenue for Next Month: ₹" + forecast);
    }
}
