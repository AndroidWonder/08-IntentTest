//This Activity is started when the correct password has been entered.
package com.course.example.intenttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class GoodGuess extends Activity {


    private ImageButton btnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_guess);

        btnImg = (ImageButton) findViewById(R.id.btnGoodGuess);

   btnImg.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            //activity finishes OK
            Toast.makeText(GoodGuess.this, "Return Code Set",
                    Toast.LENGTH_LONG).show();
            setResult(Activity.RESULT_OK);                 //set result code
            finish();
        }
    });
}
}
