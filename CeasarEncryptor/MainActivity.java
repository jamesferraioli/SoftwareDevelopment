package edu.gatech.seclass.sdpencryptoractivity;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

    EditText messageInput;
    EditText keyNumber;
    EditText incrementNumber;
    TextView cipherText;
    Button encryptButton;
    String newString;
    String messageToEnCrypt;
    int keyNum;
    int incrNum;
    String mesInput;
    int message_error;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageInput = findViewById(R.id.messageInput);
        messageInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int test1 = 0;
                if (messageInput.getText().length() == 0) {
                    messageInput.setError("Invalid Message");
                }
                if (messageInput.getText().length() > 0) {
                    for (int j = 0; j < messageInput.getText().length(); j++) {
                        if (messageInput.getText().charAt(j) == 'a' || (messageInput.getText().charAt(j) == 'b') || (messageInput.getText().charAt(j) == 'c') || (messageInput.getText().charAt(j) == 'd')
                                || (messageInput.getText().charAt(j) == 'e') || (messageInput.getText().charAt(j) == 'f') || (messageInput.getText().charAt(j) == 'g') || (messageInput.getText().charAt(j) == 'h')
                                || (messageInput.getText().charAt(j) == 'i') || (messageInput.getText().charAt(j) == 'j') || (messageInput.getText().charAt(j) == 'k') || (messageInput.getText().charAt(j) == 'l')
                                || (messageInput.getText().charAt(j) == 'm') || (messageInput.getText().charAt(j) == 'n') || (messageInput.getText().charAt(j) == 'o') || (messageInput.getText().charAt(j) == 'p')
                                || (messageInput.getText().charAt(j) == 'q') || (messageInput.getText().charAt(j) == 'r') || (messageInput.getText().charAt(j) == 's') || (messageInput.getText().charAt(j) == 't')
                                || (messageInput.getText().charAt(j) == 'u') || (messageInput.getText().charAt(j) == 'v') || (messageInput.getText().charAt(j) == 'w') || (messageInput.getText().charAt(j) == 'x')
                                || (messageInput.getText().charAt(j) == 'y') || (messageInput.getText().charAt(j) == 'z')) {
                            test1 = test1 + 1;
                        }
                        if (messageInput.getText().charAt(j) == '1' || (messageInput.getText().charAt(j) == '2') || (messageInput.getText().charAt(j) == '3') || (messageInput.getText().charAt(j) == '4')
                                || (messageInput.getText().charAt(j) == '5') || (messageInput.getText().charAt(j) == '6') || (messageInput.getText().charAt(j) == '7') || (messageInput.getText().charAt(j) == '8')
                                || (messageInput.getText().charAt(j) == '9') || (messageInput.getText()).charAt(j) == ' ' || (messageInput.getText()).charAt(j) == '!' || (messageInput.getText()).charAt(j) == '#' || (messageInput.getText()).charAt(j) == '$' || (messageInput.getText()).charAt(j) == '%' || (messageInput.getText()).charAt(j) == '(' ||
                                (messageInput.getText()).charAt(j) == ')' || (messageInput.getText()).charAt(j) == '*' || (messageInput.getText()).charAt(j) == '+' || (messageInput.getText()).charAt(j) == ',' || (messageInput.getText()).charAt(j) == '-' || (messageInput.getText()).charAt(j) == '.') {
                            test1 = test1 + 0;
                        }

                    }
                }
                if (test1 == 0) {
                    messageInput.setError("Invalid Message");
                    message_error = 1;
                }
            }
        });

        keyNumber = findViewById(R.id.keyNumber);
        final String keyNumberString = keyNumber.getText().toString();
        final int keyS = Integer.parseInt(keyNumberString);
            keyNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (keyNumber.getText().toString().isEmpty()) {
                    }
                    else {
                        if (Integer.parseInt(keyNumber.getText().toString()) < 1 || Integer.parseInt(keyNumber.getText().toString()) > 26) {
                            keyNumber.setError("Invalid Key Number");
                            messageInput.setText(null);
                        }
                    }
                }
            });
        incrementNumber = findViewById(R.id.incrementNumber);
        final String incrstring = incrementNumber.getText().toString();
        final int incr = Integer.parseInt(incrstring);
            incrementNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }


                @Override
                public void afterTextChanged(Editable editable) {
                    if (incrementNumber.getText().toString().isEmpty()) {
                    }
                    else {
                        if (Integer.parseInt(incrementNumber.getText().toString()) < 1 || Integer.parseInt(incrementNumber.getText().toString()) > 26) {
                            incrementNumber.setError("Invalid Increment Number");
                            messageInput.setText(null);
                        }
                    }
                }
            });

            keyNumber = findViewById(R.id.keyNumber);
        cipherText = findViewById(R.id.cipherText);
        encryptButton = findViewById(R.id.encryptButton);
        incrementNumber = findViewById(R.id.incrementNumber);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                keyNum = Integer.parseInt(keyNumber.getText().toString());
                messageToEnCrypt = messageInput.getText().toString();
                incrNum = Integer.parseInt(incrementNumber.getText().toString());
                newString = encrypt(messageToEnCrypt, keyNum);
                mesInput = messageInput.getText().toString();
                cipherText.setText(newString);
            }
        });

    }

    public String encrypt(String messageToEnCrypt, int keyNum) {
            StringBuffer output;
            int prev;
            int next;
            output = new StringBuffer();


            for (int i = 0; i < messageToEnCrypt.length(); i++) {
                if (messageToEnCrypt.charAt(i) == ' ' || messageToEnCrypt.charAt(i) == '!' || messageToEnCrypt.charAt(i) == '#' || messageToEnCrypt.charAt(i) == '$' || messageToEnCrypt.charAt(i) == '%' || messageToEnCrypt.charAt(i) == '(' ||
                        messageToEnCrypt.charAt(i) == ')' || messageToEnCrypt.charAt(i) == '*' || messageToEnCrypt.charAt(i) == '+' || messageToEnCrypt.charAt(i) == ',' || messageToEnCrypt.charAt(i) == '-' || messageToEnCrypt.charAt(i) == '.'
                        || messageToEnCrypt.charAt(i) == '0' || messageToEnCrypt.charAt(i) == '1' || messageToEnCrypt.charAt(i) == '2' || messageToEnCrypt.charAt(i) == '3' || messageToEnCrypt.charAt(i) == '4' || messageToEnCrypt.charAt(i) == '5'
                        || messageToEnCrypt.charAt(i) == '6' || messageToEnCrypt.charAt(i) == '7' || messageToEnCrypt.charAt(i) == '8' || messageToEnCrypt.charAt(i) == '9' || messageToEnCrypt.charAt(i) == ':' ||
                        messageToEnCrypt.charAt(i) == ';' || messageToEnCrypt.charAt(i) == '<' || messageToEnCrypt.charAt(i) == '?' || messageToEnCrypt.charAt(i) == '@' || messageToEnCrypt.charAt(i) == '{' ||
                        messageToEnCrypt.charAt(i) == '|' || messageToEnCrypt.charAt(i) == '}' || messageToEnCrypt.charAt(i) == '~' || messageToEnCrypt.charAt(i) == '^' || messageToEnCrypt.charAt(i) == '/' ||
                        messageToEnCrypt.charAt(i) == '[' || messageToEnCrypt.charAt(i) == ']' || messageToEnCrypt.charAt(i) == '_' || messageToEnCrypt.charAt(i) == '`' || messageToEnCrypt.charAt(i) == '&') {
                    output.append(Character.toString(messageToEnCrypt.charAt(i)));
                    continue;
                }

                if (messageToEnCrypt.charAt(i) == 'a' || messageToEnCrypt.charAt(i) == 'b' || messageToEnCrypt.charAt(i) == 'c' || messageToEnCrypt.charAt(i) == 'd' || messageToEnCrypt.charAt(i) == 'e' ||
                        messageToEnCrypt.charAt(i) == 'f' || messageToEnCrypt.charAt(i) == 'g' || messageToEnCrypt.charAt(i) == 'h' || messageToEnCrypt.charAt(i) == 'i' ||
                        messageToEnCrypt.charAt(i) == 'j' || messageToEnCrypt.charAt(i) == 'k' || messageToEnCrypt.charAt(i) == 'l' || messageToEnCrypt.charAt(i) == 'm' || messageToEnCrypt.charAt(i) == 'n' ||
                        messageToEnCrypt.charAt(i) == 'o' || messageToEnCrypt.charAt(i) == 'p' || messageToEnCrypt.charAt(i) == 'q' || messageToEnCrypt.charAt(i) == 'r' || messageToEnCrypt.charAt(i) == 's' ||
                        messageToEnCrypt.charAt(i) == 't' || messageToEnCrypt.charAt(i) == 'u' || messageToEnCrypt.charAt(i) == 'v' ||
                        messageToEnCrypt.charAt(i) == 'w' || messageToEnCrypt.charAt(i) == 'x' || messageToEnCrypt.charAt(i) == 'y' || messageToEnCrypt.charAt(i) == 'z') {
                    prev = (int) messageToEnCrypt.charAt(i);
                    next = prev + keyNum;
                    while (next > 90 && Character.isUpperCase(messageToEnCrypt.charAt(i)) || next > 122) {
                        next -= 26;
                    }

                    output.append(Character.toString((char) next));
                    keyNum = keyNum + incrNum;
                }

                if (messageToEnCrypt.charAt(i) == 'A' || messageToEnCrypt.charAt(i) == 'B' || messageToEnCrypt.charAt(i) == 'C' || messageToEnCrypt.charAt(i) == 'D' || messageToEnCrypt.charAt(i) == 'E' ||
                        messageToEnCrypt.charAt(i) == 'F' || messageToEnCrypt.charAt(i) == 'G' || messageToEnCrypt.charAt(i) == 'H' || messageToEnCrypt.charAt(i) == 'I' ||
                        messageToEnCrypt.charAt(i) == 'J' || messageToEnCrypt.charAt(i) == 'K' || messageToEnCrypt.charAt(i) == 'L' || messageToEnCrypt.charAt(i) == 'M' || messageToEnCrypt.charAt(i) == 'N' ||
                        messageToEnCrypt.charAt(i) == 'O' || messageToEnCrypt.charAt(i) == 'P' || messageToEnCrypt.charAt(i) == 'Q' || messageToEnCrypt.charAt(i) == 'R' || messageToEnCrypt.charAt(i) == 'S' ||
                        messageToEnCrypt.charAt(i) == 'T' || messageToEnCrypt.charAt(i) == 'U' || messageToEnCrypt.charAt(i) == 'V' ||
                        messageToEnCrypt.charAt(i) == 'W' || messageToEnCrypt.charAt(i) == 'X' || messageToEnCrypt.charAt(i) == 'Y' || messageToEnCrypt.charAt(i) == 'Z') {
                    prev = (int) messageToEnCrypt.charAt(i);
                    next = prev + keyNum;
                    while (next > 90 && Character.isUpperCase(messageToEnCrypt.charAt(i)) || next > 122) {
                        next -= 26;
                    }

                    output.append((char) next);
                    keyNum = keyNum + incrNum;

                }
            }
            return String.valueOf(output);
    }
}
