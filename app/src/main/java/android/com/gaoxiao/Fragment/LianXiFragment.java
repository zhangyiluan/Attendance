package android.com.gaoxiao.Fragment;

import android.com.gaoxiao.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mummyding on 15-8-14.
 */
public class LianXiFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lianxi_fragment);
        TextView title = (TextView) findViewById(R.id.lxtitle_tv);
        Button button = (Button) findViewById(R.id.lxheader_imgbtn);
        title.setText("联系人");
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("添加");

    }
}
