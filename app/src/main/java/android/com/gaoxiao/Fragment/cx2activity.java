package android.com.gaoxiao.Fragment;

import android.app.Activity;
import android.com.gaoxiao.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/12/13.
 */

public class cx2activity extends Activity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chaxun2);
        btn = (Button) findViewById(R.id.cxkqxx);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cx2activity.this,cxkqxx.class);
                startActivity(intent);
            }
        });

    }

}
