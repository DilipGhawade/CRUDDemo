package com.meteorsoftech.cruddemo;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Delete on 6/26/2017.
 */

public class Validation {

    public static final String EMAIL_REGX= "^[A-Za-z0-9._%+\\\\-]+@[A-Za-z0-9.\\\\-]+\\\\.[A-Za-z]{2,4}$";
    public static final String PHONE_REGX="^[0-9]{10}$";

    public static final String REQUIRED_MSG="Required";
    public static final String EMAIL_MSG="Enter Valid Email";
    public static final String PHONE_MSG="Enter 10 digit only";

    public static boolean isEmailId(EditText editText, boolean Required) {
        return isValid(editText,EMAIL_REGX,EMAIL_MSG,Required);
    }
    public static boolean isMobileNo(EditText editText, boolean Required)
    {
        return isValid(editText,PHONE_REGX,PHONE_MSG,Required);
    }

    public static boolean isValid(EditText editText,String regex,String msg,boolean Required)
    {
        String text = editText.getText().toString().trim();
        editText.setError(null);
        if (Required && !hasText(editText))
        return false;
        if (Required && Pattern.matches(regex,text))
        {
            editText.setError(msg);
            return false;

        };
            return true;

    }

    public static boolean hasText(EditText editText)
    {
        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length()==0)
        {
            editText.setError(REQUIRED_MSG);
            return false;
        }
        return true;
    }

}
