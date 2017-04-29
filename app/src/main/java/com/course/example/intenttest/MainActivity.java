/*This example tests the startActivityForResult() method with one or two requests
to start an Activity. The example starts with one. Each request has a different request code.
onActivityResult() when called is passed the request code and result code.

onStart() is used to start the Activities. This allows multiple attempts
to enter the correct name. If onCreate() was used, the app wouldn't restart.
Can you explain why?

Notice the manifest entries for all the Activities.
*/

package com.course.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int requestCode_235 = 235;
    public static final int requestCode_240 = 240;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent1 = new Intent(this, UIDemo.class);
        startActivityForResult(intent1, requestCode_235);

       // Intent intent2 = new Intent(this, UIDemo.class);
       // startActivityForResult(intent2, requestCode_240);

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case (requestCode_235): {

                if (resultCode == Activity.RESULT_OK)
                    Toast.makeText(this, "Result OK for " + requestCode, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, "Result NOT OK for " + requestCode, Toast.LENGTH_LONG).show();
                break;
            }

            case (requestCode_240): {

                if (resultCode == Activity.RESULT_OK) {
                    Log.e("IntentTest", "Result OK for " + requestCode);
                    Toast.makeText(this, "Result OK for " + requestCode, Toast.LENGTH_LONG).show();
                } else {
                    Log.e("IntentTest", "Result NOT OK for " + requestCode);
                    Toast.makeText(this, "Result NOT OK for " + requestCode, Toast.LENGTH_LONG).show();
                }
                break;
            }

            default:
                Toast.makeText(this, "Not my problem", Toast.LENGTH_LONG).show();
        }//switch

    }// onActivityResult

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"Restart!!!",Toast.LENGTH_LONG).show();
    }

}

