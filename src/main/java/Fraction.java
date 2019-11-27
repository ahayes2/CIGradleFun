public class Fraction {//implements Comparable{
    int numerator;
    int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if(numerator > Integer.MAX_VALUE) {
            System.out.println("You're numerator is too big. Default to 0/1.");
            this.numerator = 0;
            this.denominator = 1;
        }
        else if(numerator < Integer.MIN_VALUE) {
            System.out.println("You're numerator is too small. Default to 0/1.");
            this.numerator = 0;
            this.denominator =1;
        }
        else {
            this.numerator = numerator;
        }
        if(denominator > Integer.MAX_VALUE) {
            System.out.println("You're denominator is too big. Default to 0/1.");
            this.numerator = 0;
            this.denominator =1;
        }
        else if(denominator < Integer.MIN_VALUE) {
            System.out.println("You're denominator is too small. Default to 0/1.");
            this.numerator = 0;
            this.denominator =1;
        }
        else if(denominator == 0) {
            System.out.println("Denominator cannot be zero. Default to 0/1.");
            this.numerator = 0;
            this.denominator =1;
        }
        else {
           this.denominator = denominator;
        }
        if(numerator < 0 && denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double getRealValue() {
        return (double) numerator / (double) denominator;
    }

    public Fraction reduce(Fraction fraction) {
        int remainder = 0;
        int num1 = numerator;
        int num2 = denominator;

        while (num2 != 0) {
            remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        numerator = numerator / num1;
        denominator = denominator / num1;

        fraction = new Fraction(numerator, denominator);

        return fraction;
    }

    public Fraction add(Fraction fraction) {
        Fraction newCur;
        Fraction newPer;
        Fraction answer;
        newCur = new Fraction((this.numerator * fraction.denominator), (this.denominator * fraction.denominator));
        newPer = new Fraction((fraction.numerator * this.denominator), (fraction.denominator * this.denominator));
        answer = new Fraction((newCur.numerator + newPer.numerator), (newCur.denominator));
        answer = reduce(answer);
        return fraction;
    }

    public boolean equals(Fraction fraction) {
        fraction = reduce(fraction);
        Fraction curFraction = new Fraction(reduce(this).numerator, reduce(this).denominator);
        if((curFraction.numerator == fraction.numerator) && (curFraction.denominator == fraction.denominator)) {
            return true;
        }
        return false;
    }
/*
    @Override
    public int compareTo(Fraction fraction) {
        fraction = reduce(fraction);
        Fraction curFraction = new Fraction(reduce(this).numerator, reduce(this).denominator);

        if ((curFraction.denominator < fraction.denominator) && ()) {
            return -1;
        }
        if (this.radius > o.radius) {
            return 1;
        }
        return 0;
    }*/


}
