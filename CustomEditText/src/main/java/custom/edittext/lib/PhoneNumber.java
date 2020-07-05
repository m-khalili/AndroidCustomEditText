package custom.edittext.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class PhoneNumber extends RelativeLayout {
    private Spinner spinner1;
    private EditText number;
    private String item;

    public PhoneNumber(Context context, AttributeSet attrs) {
        super(context, attrs);

        View v = LayoutInflater.from(context).inflate(R.layout.phone_number_edittext_item, this, true);
        spinner1 = v.findViewById(R.id.spinner1);
        number = v.findViewById(R.id.number);
        addItemOnSpinner();

        TypedArray attrsArray =
                getContext().obtainStyledAttributes(
                        attrs, R.styleable.PhoneNumber);

        String hintText = attrsArray.getString(R.styleable.Password_hintText);
        if (hintText != null)
            number.setHint(hintText);

    }

    private void addItemOnSpinner() {
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public String getCountryCode() {
        return item;
    }

    public String getText() {
        return number.getText().toString();

    }

    public void setError(String value) {
        number.setError(value);
    }

}
