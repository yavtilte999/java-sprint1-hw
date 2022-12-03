public class Converter {
    double converterDistance(int sumStep) {
        double km = 0.00075;
        return sumStep * km;
    }
    double converterKcal(int sumStep) {
        double kcal = 0.05;
        return sumStep * kcal;

    }
}