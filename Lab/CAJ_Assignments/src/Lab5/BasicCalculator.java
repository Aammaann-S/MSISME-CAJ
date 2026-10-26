package Lab5;

class BasicCalculator implements Calculator {
    int cells[];
    int t;

    private BasicCalculator() {
        cells = new int[2];
        t = 0;
    }

    public Calculator put(int n) {
        cells[t] = n;
        t = (t + 1) % 2;
        return this;
    }

    public int read() {
        return cells[0];
    }

    public Calculator neg() {
        cells[0] = cells[0] * (-1);
        return this;
    }

    public Calculator add() {
        cells[0] = cells[0] + cells[1];
        cells[1] = 0;
        t = 1;
        return this;
    }

    public Calculator sub() {
        cells[0] = cells[0] - cells[1];
        cells[1] = 0;
        t = 1;
        return this;
    }

    public Calculator mul() {
        cells[0] = cells[0] * cells[1];
        cells[1] = 0;
        t = 1;
        return this;
    }

    public Calculator div() {
        if (cells[1] == 0) {
            throw new ArithmeticException("Division by zero");
        }

        cells[0] = cells[0] / cells[1];
        cells[1] = 0;
        t = 1;
        return this;
    }

    public Calculator clear() {
        cells[t] = 0;
        t = 0;
        return this;
    }

    public Calculator clearAll() {
        cells[0] = 0;
        cells[1] = 0;
        t = 0;
        return this;
    }

    public static Calculator getInstance() {
        Calculator calc = new BasicCalculator();
        calc.clearAll();
        return calc;
    }
}
