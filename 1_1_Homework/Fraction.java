import java.util.Objects;

public class Fraction extends Number {

    public int numerator;
    public int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator != 0");
        } else {
            this.denominator = denominator;
        }
        reduce();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int intValue() {
        return getNumerator()/getDenominator();
    }

    public long longValue() {
        return (long) getNumerator()/getDenominator();
    }

    public float floatValue() {
        return (float) getNumerator()/getDenominator();
    }

    public double doubleValue() {
        return (double) getNumerator()/getDenominator();
    }

    public Fraction add(Fraction other) {
        return new Fraction(getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator(), getDenominator() * other.getDenominator());
    }

    public Fraction subtract(Fraction other) {
        return new Fraction(getNumerator() * other.getDenominator() - getDenominator() * other.getNumerator(), getDenominator() * other.getDenominator());
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(getNumerator() * other.getNumerator(), getDenominator() * other.getDenominator());
    }

    public Fraction divide(Fraction other) {
        return new Fraction(getNumerator() * other.getDenominator(), getDenominator() * other.getNumerator());
    }

    public void reduce() {
        for (int i = getNumerator(); i > 2; i--) {
            if (getNumerator() % i == 0 && getDenominator() % i == 0) {
                setNumerator(getNumerator()/i);
                setDenominator(getDenominator()/i);
            }
        }
    }

    public Fraction negate(Fraction da) {
        return new Fraction(-numerator, da.getDenominator());
    }

    public boolean isProper(Fraction da) {
        return (Math.abs(da.getNumerator()) < Math.abs(da.getDenominator()));
    }

    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return getNumerator() == ((Fraction) obj).getNumerator() && getDenominator() == ((Fraction) obj).getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator,denominator);
    }
}