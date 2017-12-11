package android.com.gaoxiao.Fragment;

import android.com.gaoxiao.R;
import android.com.gaoxiao.kebiao.KBMainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mummyding on 15-8-14.
 */
public class kbFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_kb_fragment,null);

        Intent intent= new Intent(getActivity(), KBMainActivity.class);
        startActivityForResult(intent,1);
     return view;
      }

}
