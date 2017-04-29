//This Activity tests for the correct password. If yes, it starts another Activity.
//If not, it finishes.
package com.course.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UIDemo extends Activity {

    private EditText txtUserName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uidemo);

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        button = (Button) findViewById(R.id.btnLogin);
        

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v1) {
                String strUserName = txtUserName.getText().toString();
                if (strUserName.equals("Harry Bentley")) {

                    Intent intent = new Intent(UIDemo.this, GoodGuess.class);
                    startActivity(intent);
                    Toast.makeText(UIDemo.this,
                            "Go Harry!", Toast.LENGTH_LONG).show();
                    setResult(Activity.RESULT_OK);     //set result code
                    finish();
                }
                else {
                    //activity does not finish successfully
                    Toast.makeText(UIDemo.this,
                            "Invalid User", Toast.LENGTH_LONG).show();
                    setResult(Activity.RESULT_CANCELED);     //set result code
                    finish();
                }

            }
        });

    }
}
