package devsbox.rfr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class TwoActivity extends AppCompatActivity {
    CheckBox check_one, check_two, check_three, check_four, check_five;
    EditText name , company;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        name = (EditText) findViewById(R.id.ThirdPhonEditTextzero);
        company = (EditText) findViewById(R.id.ThirdPhonEditTextOne);
        send= (Button) findViewById(R.id.ThirdSendButton);

        check_one = (CheckBox) findViewById(R.id.ActionCheckBoxOne);
        check_two = (CheckBox) findViewById(R.id.ActionCheckBoxTwo);
        check_three = (CheckBox) findViewById(R.id.ActionCheckBoxThree);
        check_four = (CheckBox) findViewById(R.id.ActionCheckBoxFour);
        check_five = (CheckBox) findViewById(R.id.ActionCheckBoxFive);


        /////////////////////date picker////////////////////////////
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        //tv.setText(currentDateTimeString);
        final String date = currentDateTimeString;
        //   Toast.makeText(SendTvfotejMessageActivity.this, date , Toast.LENGTH_LONG).show();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String namedata = name.getText().toString();
                String companydata = company.getText().toString();

                //////////////////////for CheckBox///////////////////////

                StringBuilder output = new StringBuilder();

                if (check_one.isChecked()) {
                    output.append("ভেনুতে পৌঁছালাম, ");
                }
                if (check_two.isChecked()) {
                    output.append("অনুষ্ঠান শুরু হল, ");
                }
                if (check_three.isChecked()) {
                    output.append("অনুষ্ঠান শেষ হল, ");
                }
                if (check_four.isChecked()) {
                    output.append("ফুটেজ পাঠালাম,");
                }
                if (check_five.isChecked()) {
                    output.append("অফিসে আসছি, ");
                }

                String one = "01711425005";
                String two = "01730012307";
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", one + ";"+ two );
                smsIntent.putExtra("sms_body", (
                        namedata + "," +
                                companydata + ","+ output.toString()+","+
                                date));
                startActivity(smsIntent);

            }
        });
    }
}
