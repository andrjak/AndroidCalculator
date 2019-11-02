package com.example.androidcalculator;

public class Solver {
    static String result;

    static void Solve()
    {

    }

    static int GetPriority(String operation) {
        switch (operation) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "sin":
            case "cos":
            case "tg":
            case "arcsin":
            case "arccos":
            case "arctg":
            case "sqrt":
            case "ln":
            case "log":
            case "abc":
            case "^":
                return 3;
            case "Pi":
            case "E":
                return 4;
            default:
                return -1;
        }
    }
}
