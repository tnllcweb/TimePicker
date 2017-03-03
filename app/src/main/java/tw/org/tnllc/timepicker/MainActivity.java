package tw.org.tnllc.timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePicker firstTime;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTime = (TimePicker) findViewById(R.id.firstTime);
        button = (Button)findViewById(R.id.button);
        firstTime.setIs24HourView(true);
        TimeListener timeListener = new TimeListener();
        firstTime.setOnTimeChangedListener(timeListener);

        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);

    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int hour = firstTime.getCurrentHour();
            int minute = firstTime.getCurrentMinute();
            Log.i("時",String.valueOf(hour));
            Log.i("分",String.valueOf(minute));
        }
    }

    class TimeListener implements TimePicker.OnTimeChangedListener {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Log.i("時:",String.valueOf(hourOfDay));
            Log.i("分:",String.valueOf(minute));
        }
    }
}
