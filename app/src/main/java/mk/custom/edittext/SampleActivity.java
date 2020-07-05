package mk.custom.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import custom.edittext.lib.CustomEditText;
import custom.edittext.lib.EmailAddress;
import custom.edittext.lib.Password;
import custom.edittext.lib.PhoneNumber;
import custom.edittext.lib.Username;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {
    Username user;
    Password pass;
    EmailAddress email;
    PhoneNumber phone;
    CustomEditText text;
    TextView test1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();

    }

    @Override
    public void onClick(View view) {
        usernameValid();
        passwordValid();
        emailValid();
        phoneNum();

    }

    private void phoneNum() {
//        Toast.makeText(this, phone.getCountryCode()+" "+phone.getText(), Toast.LENGTH_SHORT).show();
             test1.setText(phone.getCountryCode()+" "+phone.getText());
    }

    private void emailValid() {
        boolean mailValid = email.isValid(EmailAddress.ValidationType.EMAIL);
            if (mailValid == true){
                Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            }
            else if (mailValid==false){
                email.setError("Email is invalid");
            }
    }

    private void passwordValid() {
        boolean passValid = pass.isValid(Password.ValidationType.PASSWORD);

        if (passValid==true){
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        } else if (passValid==false){
            pass.setError("8 characters long\ninclude at least one number and symbol\n1 uppercase & 1 lowercase character");
        }
    }

    private void usernameValid() {
        boolean userValid = user.isValid(Username.ValidationType.USERNAME);
        if (userValid==true){
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        } else {
            user.setError("Please use only letters (a-z) , numbers and Underline");
            //4-32 character
        }
    }


    private void bind() {
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        text = findViewById(R.id.text);
        test1 = findViewById(R.id.test1);
        findViewById(R.id.validate).setOnClickListener(this);
    }


}