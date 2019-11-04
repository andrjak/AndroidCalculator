package com.example.androidcalculator;

import org.mariuszgromada.math.mxparser.Expression;

public class Solver
{
    public static double solve(String expr)
    {
        return new Expression(expr).calculate();
    }
}
