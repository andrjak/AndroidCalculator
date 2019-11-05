package com.example.androidcalculator;

import org.mariuszgromada.math.mxparser.Expression;

public class Solver
{
    public static short bracketFlag = 0;
    public static boolean operationFlag = false;
    public static boolean constFlag = false;

    public static double solve(String expr)
    {
        return new Expression(expr).calculate();
    }
}


