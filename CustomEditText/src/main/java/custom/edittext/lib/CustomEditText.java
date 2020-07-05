package custom.edittext.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class CustomEditText extends RelativeLayout {
   private ImageView icon;
   private EditText txt;
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_iconic_edittext_item, this, true);
        icon = v.findViewById(R.id.icon);
        txt = v.findViewById(R.id.txt);

        TypedArray attrsArray =
                getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText);

        Drawable hintIcon = attrsArray.getDrawable(R.styleable.CustomEditText_hintIcon);
        if (hintIcon != null) {
            icon.setImageDrawable(hintIcon);
        }

        String hintText = attrsArray.getString(R.styleable.CustomEditText_hintText);
        if (hintText != null) {
            txt.setHint(hintText);
        }
        String textValue = attrsArray.getString(R.styleable.CustomEditText_set_text);
        if (textValue != null) {
            txt.setText(textValue);
        }
        int typeValue = attrsArray.getInt(R.styleable.CustomEditText_input_type , 1);

            if (typeValue == 2) {
                txt.setInputType(TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);

            }
            if (typeValue==3) {
                txt.setInputType(InputType.TYPE_CLASS_NUMBER);

            }
            if (typeValue==4) {
                txt.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

            }



    }
    public void setError(String value) {
        txt.setError(value);
    }

    public void setText(String value) {
        txt.setText(value);
    }

    public String getText() {
        return txt.getText().toString();
    }

}
