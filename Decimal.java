import java.util.Scanner;

import static java.lang.System.out;

public final class Decimal extends Number implements DecimalInterface {

    private int numerator; //числитель
    private int denominator; //знаменатель
    Scanner in = new Scanner(System.in);

    public Decimal(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalStateException("Знаменатель не может быть равен нулю");

        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Decimal() {
        out.println("Введите числитель дроби");
        int numerator = in.nextInt();

        out.println("Введите знаменатель дроби (не может быть равен нулю): ");
        int denominator = in.nextInt();

        if (denominator == 0)
            throw new IllegalStateException("Знаменатель не может быть равен нулю");

        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Decimal sum(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " + " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (this.denominator * f.numerator) + (f.denominator * this.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator + f.numerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal sum(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " + " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (this.denominator * f.numerator) + (f.denominator * this.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator + f.numerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal minus(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " - " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (f.denominator * this.numerator) - (this.denominator * f.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator - f.numerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal minus(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " - " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator;
        int placeholderNumerator;

        if (this.denominator != f.denominator) {
            placeholderDenominator = this.denominator * f.denominator;
            placeholderNumerator = (f.denominator * this.numerator) - (this.denominator * f.numerator);

        } else {
            placeholderDenominator = this.denominator;
            placeholderNumerator = this.numerator - f.numerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal mult(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " * " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.denominator;
        int placeholderNumerator = this.numerator * f.numerator;

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal mult(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " * " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.denominator;
        int placeholderNumerator = this.numerator * f.numerator;

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal div(Decimal f) {
        out.print(this.numerator + "/" + this.denominator + " / " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.numerator;
        int placeholderNumerator = this.numerator * f.denominator;

        if (placeholderDenominator < 0) {
            placeholderDenominator = -placeholderDenominator;
            placeholderNumerator = -placeholderNumerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    public Decimal div(int number) {
        Decimal f = new Decimal(number, 1);

        out.print(this.numerator + "/" + this.denominator + " / " + f.numerator + "/" + f.denominator + " = ");

        int placeholderDenominator = this.denominator * f.numerator;
        int placeholderNumerator = this.numerator * f.denominator;

        if (placeholderDenominator < 0) {
            placeholderDenominator = -placeholderDenominator;
            placeholderNumerator = -placeholderNumerator;
        }

        Decimal placeholder = new Decimal(placeholderNumerator, placeholderDenominator);
        out.println(placeholder.numerator + "/" + placeholder.denominator);
        return new Decimal(placeholder.numerator, placeholder.denominator);
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Decimal fraction = (Decimal) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    public double getDoubleValue() {
        return (double) numerator / denominator;
    }

    public void setNumeratorDenominator(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalStateException("Знаменатель не может быть равен нулю");

        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }


}