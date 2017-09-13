package devsbox.rfr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class OneActivity extends AppCompatActivity {

    EditText name , company , comment;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        name = (EditText) findViewById(R.id.ThirdPhonEditTextzero);
        company = (EditText) findViewById(R.id.ThirdPhonEditTextOne);
        comment = (EditText) findViewById(R.id.ThirdPhonEditTextTwo);

        send= (Button) findViewById(R.id.ThirdSendButton);

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
                String commentdata = comment.getText().toString();


                String one = "01711425005";
                String two = "01730012307";
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", one + ";"+ two );
                smsIntent.putExtra("sms_body", (
                        namedata + "," +
                                companydata + "," +
                                commentdata+ "," +
                                date));
                startActivity(smsIntent);

            }
        });

    }
}
