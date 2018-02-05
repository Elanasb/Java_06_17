package com.company;

public class dot {

    public double x = 0;
    public double y = 0;
    public String spalva = "";

    public dot() {
    }

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public dot(double x, double y, String spalva) {
        this.x = x;
        this.y = y;
        this.spalva = spalva;
    }

    public dot(String spalva) {
        this.spalva = spalva;
    }


    public double getDistance(dot taskas) {
        double result = 0;
        //formule
        // c= kvadratine saknis ((x2-x1)^2+(y2-y1)^2)
        result = Math.sqrt(Math.pow(this.x - taskas.x, 2) + Math.pow(this.y - taskas.y, 2));

        return result;
    }

    public int getQuarter() {
        int result = -1;
        //formule
        if (this.x >= 0 && this.y >= 0) {
            result = 0;
        }

        if (this.x >= 0 && this.y < 0) {
            result = 1;
        }
        if (this.x < 0 && this.y < 0) {
            result = 2;
        }

        if (this.x < 0 && this.y >= 0) {
            result = 3;
        }

        return result;
    }

    public boolean isSameQuarter(dot taskas) {
        boolean result = this.getQuarter() == taskas.getQuarter();

        return result;

    }

    public String toString() {
        return "Spalva:  " + this.spalva + " x: " + this.x + " y: " + this.y;

    }

    public boolean equals(dot dot) {

        boolean result = true;
        if (this.x != dot.x) {
            result = false;
        }
        if (this.y != dot.y) {
            result = false;
        }
        if (!this.spalva.equals(dot.spalva)) {
            result = false;
        }

        return result;
    }
}
