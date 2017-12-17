package android.com.gaoxiao.Fragment;

import android.com.gaoxiao.Adapter.MsgListAdapter;
import android.com.gaoxiao.Item.MsgListItem;
import android.com.gaoxiao.R;
import android.com.gaoxiao.kebiao.DataSchedule;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 import android.os.Bundle;
 import android.os.Handler;
 import android.support.v4.app.Fragment;
 import android.support.v4.widget.SwipeRefreshLayout;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.ListView;
 import android.widget.TextView;

 import android.com.gaoxiao.Adapter.MsgListAdapter;
 import android.com.gaoxiao.R;
 import android.com.gaoxiao.Item.MsgListItem;

 import java.util.ArrayList;
 import java.util.List;

 /**
 * Created by mummyding on 15-8-14.
 */
public class ChaXunFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private View view;
    private RelativeLayout schedule;
    private DataSchedule dataSchedule;
    private List<MsgListItem> list;
    private MsgListAdapter msgListAdapter;
    private ListView listView;
    private SwipeRefreshLayout swipeContainer;//下拉刷新
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_chaxun_fragment,container,false);
        setTitle();

        return view;
    }


    void setTitle(){
        TextView title = (TextView) view.findViewById(R.id.cxtitle_tv);
        title.setText("课程");
        Button button = (Button) view.findViewById(R.id.cxheader_imgbtn);
        button.setBackgroundResource(R.drawable.header_btn_more);
        button.setText("");
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                msgListAdapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        }, 1000);
    }
}
