package custom.edittext.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username extends RelativeLayout {
    private ImageView icon;
    private EditText txt;
    public Username(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.username_edittext_item , this ,true);
        icon = v.findViewById(R.id.icon);
        txt = v.findViewById(R.id.txt);

        TypedArray attrsArray =
                getContext().obtainStyledAttributes(
                        attrs, R.styleable.Username);

        Drawable hintIcon = attrsArray.getDrawable(R.styleable.Username_hintIcon);
        if (hintIcon != null) {
            icon.setImageDrawable(hintIcon);
        }

        String hintText = attrsArray.getString(R.styleable.Username_hintText);
        if (hintText != null) {
            txt.setHint(hintText);
        }
        String textValue = attrsArray.getString(R.styleable.Username_set_text);
        if (textValue != null) {
            txt.setText(textValue);
        }

    } public void setError(String value) {
        txt.setError(value);
    }

    public void setText(String value) {
        txt.setText(value);
    }

    public String getText() {
        return txt.getText().toString();
    }

    public boolean isValid(ValidationType type) {
        String value = txt.getText().toString();
        if (value.length() > 0)
            if (type == ValidationType.USERNAME) {
                return isValid(value);
            }
        return false;
    }


    public enum ValidationType {
        USERNAME
    }

    private boolean isValid(String txt) {
        String regex = "^([_a-zA-Z0-9]{4,32})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        if (!matcher.matches()) {
            return false;
        } else
            return true;
    }


}
