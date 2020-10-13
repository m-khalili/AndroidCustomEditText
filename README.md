# AndroidCustomEditText
# testing
[![](https://jitpack.io/v/mrmkh/AndroidCustomEditText.svg)](https://jitpack.io/#mrmkh/AndroidCustomEditText)

```ruby
	repositories {
	
		maven { url 'https://jitpack.io' }
		
	}
                dependencies {
	        implementation 'com.github.mrmkh:AndroidCustomEditText:1.0.2'
	}
```

![Alt text](http://s12.picofile.com/file/8403992950/Untitled1.png "Optional title")

```xml
        <custom.edittext.lib.Username
        android:id="@+id/user"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <custom.edittext.lib.Password
        android:id="@+id/pass"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <custom.edittext.lib.EmailAddress
        android:id="@+id/email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <custom.edittext.lib.PhoneNumber
        android:id="@+id/phone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>


    <custom.edittext.lib.CustomEditText
        android:id="@+id/text"
        app:hintText="Custom Iconic EditText"
        app:set_text=""
        app:input_type="textEmailAddress"
        app:hintIcon="@drawable/search_24dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

## Usage
```java
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
```
     

   

        
## License
[MIT](https://choosealicense.com/licenses/mit/)
