package android.com.gaoxiao.Fragment;

import android.com.gaoxiao.R;
import android.com.gaoxiao.kebiao.KBMainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mummyding on 15-8-14.
 */

public class kbFragment extends Fragment {
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_kb_fragment,null);
        btn=(Button)view.findViewById(R.id.wodekebiao);   btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), KBMainActivity.class);
                startActivityForResult(intent,1);
            }
        });

     return view;
      }


}
