package com.example.androidcalculator;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static java.lang.Double.isNaN;

public class ScientificFunctionFragment extends Fragment implements View.OnClickListener
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScientificFunctionFragment() {
        // Required empty public constructor
    }

    public static ScientificFunctionFragment newInstance(String param1, String param2) {
        ScientificFunctionFragment fragment = new ScientificFunctionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientific_functions, container, false);

        view.findViewById(R.id.Sin).setOnClickListener(this);
        view.findViewById(R.id.Cos).setOnClickListener(this);
        view.findViewById(R.id.Tan).setOnClickListener(this);
//        view.findViewById(R.id.ArcSin).setOnClickListener(this);
//        view.findViewById(R.id.ArcCos).setOnClickListener(this);
//        view.findViewById(R.id.ArcTan).setOnClickListener(this);
//        view.findViewById(R.id.Abs).setOnClickListener(this);
        view.findViewById(R.id.Power).setOnClickListener(this);
        view.findViewById(R.id.Power2).setOnClickListener(this);
        view.findViewById(R.id.screamer).setOnClickListener(this);
        view.findViewById(R.id.sqrt).setOnClickListener(this);
        view.findViewById(R.id.log).setOnClickListener(this);
        view.findViewById(R.id.ln).setOnClickListener(this);
//        view.findViewById(R.id.Pi).setOnClickListener(this);
//        view.findViewById(R.id.E).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        TextView textView = getActivity().findViewById(R.id.textView);
        TextView resultTextView = getActivity().findViewById(R.id.resultTextView);
        String text = textView.getText().toString();

        switch (v.getId())
        {
            case R.id.Sin:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        text = updateText(textView.getText(), "sin(");
                    }
                    else
                    {
                        if (Solver.operationFlag || text.equals(""))
                            text = updateText(textView.getText(), "sin(");
                        else
                        {
                            text = updateText(textView.getText(), "*sin(");
                        }
                    }
                }
                else if (Solver.operationFlag || text.equals(""))
                    text = updateText(textView.getText(), "sin(");
                else
                {
                    text = updateText(textView.getText(), "*sin(");
                }
                Solver.bracketFlag += 1;
                textView.setText(text);
                Solver.operationFlag = false;
                return;

            case R.id.Cos:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        text = updateText(textView.getText(), "cos(");
                    }
                    else {
                        if (Solver.operationFlag || text.equals(""))
                            text = updateText(textView.getText(), "cos(");
                        else
                            text = updateText(textView.getText(), "*cos(");
                    }
                }
                else if (Solver.operationFlag || text.equals(""))
                    text = updateText(textView.getText(), "cos(");
                else
                {
                    text = updateText(textView.getText(), "*cos(");
                }
                Solver.bracketFlag += 1;
                textView.setText(text);
                Solver.operationFlag = false;
                return;

            case R.id.Tan:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        text = updateText(textView.getText(), "tan(");
                    }
                    else
                    {
                        if (Solver.operationFlag || text.equals(""))
                            text = updateText(textView.getText(), "tan(");
                        else
                        {
                            text = updateText(textView.getText(), "*tan(");
                        }
                    }
                }
                else if (Solver.operationFlag || text.equals(""))
                    text = updateText(textView.getText(), "tan(");
                else
                {
                    text = updateText(textView.getText(), "*tan(");
                }
                Solver.bracketFlag += 1;
                textView.setText(text);
                Solver.operationFlag = false;
                return;

//            case R.id.ArcSin:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "arcsin(");
//                else
//                {
//                    text = updateText(textView.getText(), "*arcsin(");
//                }
//                Solver.bracketFlag += 1;
//                textView.setText(text);
//                Solver.operationFlag = false;
//                return;
//
//            case R.id.ArcCos:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "arccos(");
//                else
//                {
//                    text = updateText(textView.getText(), "*arccos(");
//                }
//                Solver.bracketFlag += 1;
//                textView.setText(text);
//                Solver.operationFlag = false;
//                return;
//
//            case R.id.ArcTan:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "arctan(");
//                else
//                {
//                    text = updateText(textView.getText(), "*arctan(");
//                }
//                Solver.bracketFlag += 1;
//                textView.setText(text);
//                Solver.operationFlag = false;
//                return;

            case R.id.log:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        text = updateText(textView.getText(), "log10(");
                    }
                    else
                    {
                        if (Solver.operationFlag || text.equals(""))
                            text = updateText(textView.getText(), "log10(");
                        else
                        {
                            text = updateText(textView.getText(), "*log10(");
                        }
                    }
                }
                else if (Solver.operationFlag || text.equals(""))
                    text = updateText(textView.getText(), "log10(");
                else
                {
                    text = updateText(textView.getText(), "*log10(");
                }
                Solver.bracketFlag += 1;
                textView.setText(text);
                Solver.operationFlag = false;
                return;

            case R.id.ln:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        text = updateText(textView.getText(), "ln(");
                    }
                    else
                    {
                        if (Solver.operationFlag || text.equals(""))
                            text = updateText(textView.getText(), "ln(");
                        else
                        {
                            text = updateText(textView.getText(), "*ln(");
                        }
                    }
                }
                else if (Solver.operationFlag || text.equals(""))
                    text = updateText(textView.getText(), "ln(");
                else
                {
                    text = updateText(textView.getText(), "*ln(");
                }
                Solver.bracketFlag += 1;
                textView.setText(text);
                Solver.operationFlag = false;
                return;

//            case R.id.Abs:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "abs(");
//                else
//                {
//                    text = updateText(textView.getText(), "*abs(");
//                }
//                Solver.bracketFlag += 1;
//                textView.setText(text);
//                Solver.operationFlag = false;
//                return;

            case R.id.Power:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        return;
                    }
                }
                if (!Solver.operationFlag && !text.equals(""))
                    text = updateText(textView.getText(), "^");
                textView.setText(text);
                Solver.operationFlag = true;
                return;

            case R.id.Power2:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        return;
                    }
                }
                if (!Solver.operationFlag && !text.equals(""))
                    text = updateText(textView.getText(), "^2");
                textView.setText(text);
                Solver.operationFlag = false;
                break;

            case R.id.sqrt:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        return;
                    }
                }
                if (!Solver.operationFlag && !text.equals(""))
                    text = updateText(textView.getText(), "^0.5");
                textView.setText(text);
                Solver.operationFlag = false;
                break;

            case R.id.screamer:
                if (text.length() > 0)
                {
                    if (text.toCharArray()[text.length() - 1] == '(')
                    {
                        return;
                    }
                }
                if (!Solver.operationFlag && !text.equals(""))
                    text = updateText(textView.getText(), "!");
                textView.setText(text);
                Solver.operationFlag = false;
                break;

//            case R.id.Pi:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "pi");
//                else
//                {
//                    text = updateText(textView.getText(), "*pi");
//                }
//                textView.setText(text);
//                Solver.operationFlag = false;
//                break;
//
//            case R.id.E:
//                if (Solver.operationFlag || text.equals(""))
//                    text = updateText(textView.getText(), "e");
//                else
//                {
//                    text = updateText(textView.getText(), "*e");
//                }
//                textView.setText(text);
//                Solver.operationFlag = false;
//                break;

            default:
                return;
        }
        if (!text.equals("")) {
            short newBracketFlag = Solver.bracketFlag;
            while (newBracketFlag > 0) {
                text = textView.getText() + ")";
                newBracketFlag--;
            }
            while (newBracketFlag < 0) {
                text = "(" + textView.getText();
                newBracketFlag++;
            }

            double result = Solver.solve(text);
            String answer = isNaN(result) ? "Wrong Expression" : Double.toString(result);
            resultTextView.setText(answer);
        }
    }

    private String updateText(CharSequence viewText, String addText)
    {
        return viewText + addText;
    }
}