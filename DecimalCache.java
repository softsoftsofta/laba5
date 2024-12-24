class DecimalCache implements DecimalInterface {
    private final Decimal d;
    private Double cache;

    DecimalCache(Decimal decimal) {
        d = decimal;
        cache = null;
    }

    public double getDoubleValue() {
        if (cache == null) {
            cache = d.getDoubleValue();
        }
        return cache;
    }

    public void setNumeratorDenominator(int numerator, int denominator) {
        d.setNumeratorDenominator(numerator, denominator);
        cache = null;
    }
}
