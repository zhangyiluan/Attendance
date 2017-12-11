package android.com.gaoxiao.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.com.gaoxiao.R;

/**
 * Created by mummyding on 15-8-14.
 */
public class QzoneFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_qzone_fragment,null);
        TextView title = (TextView) view.findViewById(R.id.dttitle_tv);
        title.setText("动态");

        Button button = (Button) view.findViewById(R.id.dtheader_imgbtn);
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("更多");

        return view;
    }
}
