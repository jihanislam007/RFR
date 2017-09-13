package devsbox.rfr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton one, two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (ImageButton) findViewById(R.id.OneImageView);
        two = (ImageButton) findViewById(R.id.TwoImageView);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,OneActivity.class);
                startActivity(in);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(MainActivity.this,TwoActivity.class);
                startActivity(in);
            }
        });
    }
}
