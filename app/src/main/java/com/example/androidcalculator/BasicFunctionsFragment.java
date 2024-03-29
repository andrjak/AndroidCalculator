package com.example.androidcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static java.lang.Double.isNaN;


public class BasicFunctionsFragment extends Fragment implements View.OnClickListener
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BasicFunctionsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BasicFunctionsFragment newInstance(String param1, String param2) {
        BasicFunctionsFragment fragment = new BasicFunctionsFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_basic_function, container, false);
        view.findViewById(R.id.but0).setOnClickListener(this);
        view.findViewById(R.id.but1).setOnClickListener(this);
        view.findViewById(R.id.but2).setOnClickListener(this);
        view.findViewById(R.id.but3).setOnClickListener(this);
        view.findViewById(R.id.but4).setOnClickListener(this);
        view.findViewById(R.id.but5).setOnClickListener(this);
        view.findViewById(R.id.but6).setOnClickListener(this);
        view.findViewById(R.id.but7).setOnClickListener(this);
        view.findViewById(R.id.but8).setOnClickListener(this);
        view.findViewById(R.id.but9).setOnClickListener(this);
        view.findViewById(R.id.mul).setOnClickListener(this);
        view.findViewById(R.id.div).setOnClickListener(this);
        view.findViewById(R.id.sub).setOnClickListener(this);
        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.result).setOnClickListener(this);
        view.findViewById(R.id.dot).setOnClickListener(this);
        view.findViewById(R.id.bracket1).setOnClickListener(this);
        view.findViewById(R.id.bracket2).setOnClickListener(this);
        view.findViewById(R.id.Del).setOnClickListener(this);
        view.findViewById(R.id.C).setOnClickListener(this);

        return view;
    }

    // Переменные для метода onClick
//    static short bracketFlag = 0;
//    static boolean operationFlag = false;

    @Override
    public void onClick(View v)
    {
        TextView textView = getActivity().findViewById(R.id.textView);
        TextView resultTextView = getActivity().findViewById(R.id.resultTextView);
        StringBuilder text = new StringBuilder(textView.getText().toString());

        switch (v.getId())
        {
            case R.id.but0:
                text = new StringBuilder(updateText(textView.getText(), "0"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but1:
                text = new StringBuilder(updateText(textView.getText(), "1"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but2:
                text = new StringBuilder(updateText(textView.getText(), "2"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but3:
                text = new StringBuilder(updateText(textView.getText(), "3"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but4:
                text = new StringBuilder(updateText(textView.getText(), "4"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but5:
                text = new StringBuilder(updateText(textView.getText(), "5"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but6:
                text = new StringBuilder(updateText(textView.getText(), "6"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but7:
                text = new StringBuilder(updateText(textView.getText(), "7"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but8:
                text = new StringBuilder(updateText(textView.getText(), "8"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.but9:
                text = new StringBuilder(updateText(textView.getText(), "9"));
                textView.setText(text.toString());
                Solver.operationFlag = false;
                break;

            case R.id.Del:
                textView.setText("");
                resultTextView.setText("");
                Solver.bracketFlag = 0;
                Solver.operationFlag = false;
                return;

            case R.id.C:
                int len = text.length();
                if (len > 0)
                {
                    char[] array = text.toString().toCharArray();
                    if (array[len - 1] == ')') {
                        Solver.bracketFlag += 1;
                    } else if (array[len - 1] == '(') {
                        Solver.bracketFlag -= 1;
                    }
                    if (len > 1) {
                        if (!(array[len - 2] == '+' || array[len - 2] == '-' || array[len - 2] == '*' || array[len - 2] == '/' || array[len - 2] == '^'))
                            Solver.operationFlag = false;
                        else
                            Solver.operationFlag = true;
                    }
                    text = new StringBuilder(text.substring(0, len - 1));
                    textView.setText(text.toString());
                }
                if (text.toString().equals("")) {
                    resultTextView.setText("");
                    return;
                }
                break;

            case R.id.bracket1:
                if (!Solver.operationFlag && !text.toString().equals(""))
                    text = new StringBuilder(updateText(textView.getText(), "*("));
                else
                    text = new StringBuilder(updateText(textView.getText(), "("));
                textView.setText(text.toString());
                Solver.bracketFlag += 1;
                return;

            case R.id.bracket2:
                if (Solver.operationFlag || Solver.bracketFlag <= 0)
                    return;
                text = new StringBuilder(updateText(textView.getText(), ")"));
                textView.setText(text.toString());
                Solver.bracketFlag -= 1;
                return;

            case R.id.div:
                if (Solver.operationFlag || text.toString().equals(""))
                    return;
                text = new StringBuilder(updateText(textView.getText(), "/"));
                textView.setText(text.toString());
                Solver.operationFlag = true;
                return;

            case R.id.mul:
                if (Solver.operationFlag || text.toString().equals(""))
                    return;
                text = new StringBuilder(updateText(textView.getText(), "*"));
                textView.setText(text.toString());
                Solver.operationFlag = true;
                return;

            case R.id.sub:
                if (Solver.operationFlag)
                    return;
                text = new StringBuilder(updateText(textView.getText(), "-"));
                textView.setText(text.toString());
                Solver.operationFlag = true;
                return;

            case R.id.add:
                if (Solver.operationFlag)
                    return;
                text = new StringBuilder(updateText(textView.getText(), "+"));
                textView.setText(text.toString());
                Solver.operationFlag = true;
                return;

            case R.id.dot:
                if (Solver.operationFlag || text.toString().equals(""))
                    return;
                text = new StringBuilder(updateText(textView.getText(), "."));
                textView.setText(text.toString());
                return;

            case R.id.result:
                if (text.toString().equals(""))
                    return;
                short newBracketFlag = Solver.bracketFlag;
                while (newBracketFlag > 0)
                {
                    text = new StringBuilder(textView.getText() + ")");
                    newBracketFlag--;
                }
                while (newBracketFlag < 0)
                {
                    text = new StringBuilder("(" + textView.getText());
                    newBracketFlag++;
                }
                textView.setText(text.toString());

                double result = Solver.solve(textView.getText().toString());
                String answer = isNaN(result) ? "Wrong Expression" : Double.toString(result);
                textView.setText(answer);
                resultTextView.setText("");
                Solver.operationFlag = false;
                return;

            default:
                return;
        }

        short newBracketFlag = Solver.bracketFlag;
        while (newBracketFlag > 0)
        {
            text.append(")");
            newBracketFlag--;
        }
        while (newBracketFlag < 0)
        {
            text.insert(0, "(");
            newBracketFlag++;
        }

        double result = Solver.solve(text.toString());
        String answer = isNaN(result) ? "Wrong Expression" : Double.toString(result);
        resultTextView.setText(answer);
    }

    private String updateText(CharSequence viewText, String addText)
    {
        return viewText + addText;
    }
}
