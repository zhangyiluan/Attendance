package android.com.gaoxiao.Fragment;

import android.com.gaoxiao.Adapter.MsgListAdapter;
import android.com.gaoxiao.Item.MsgListItem;
import android.com.gaoxiao.R;
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

import java.util.ArrayList;
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
    private List<MsgListItem> list;
    private MsgListAdapter msgListAdapter;
    private ListView listView;
    private SwipeRefreshLayout swipeContainer;//下拉刷新
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_chaxun_fragment,container,false);
        setTitle();
        initData();

        return view;
    }
    void setTitle(){
        TextView title = (TextView) view.findViewById(R.id.cxtitle_tv);
        title.setText("课程");
        Button button = (Button) view.findViewById(R.id.cxheader_imgbtn);
        button.setBackgroundResource(R.drawable.header_btn_more);
        button.setText("");
    }
    void initData(){

        list = new ArrayList<MsgListItem>();
        listView = (ListView) view.findViewById(R.id.cx_list);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.cxswipeContainer);
        swipeContainer.setOnRefreshListener(this);
        msgListAdapter = new MsgListAdapter(getActivity(),R.id.cx_list,list);
        MsgListItem msgListItem = new MsgListItem(R.drawable.avatar_03,"编译原理","","","");
        list.add(msgListItem);

        msgListItem = new MsgListItem(R.drawable.avatar_03,"大学英语","","","");
        list.add(msgListItem);

        msgListItem = new MsgListItem(R.drawable.avatar_03,"高等数学","","","");
        list.add(msgListItem);

        listView.setAdapter(msgListAdapter);
    }
    void addItems(){
        MsgListItem msgListItem =  new MsgListItem(R.drawable.avatar_03,"计算机图形学","","","");
        list.add(msgListItem);
        msgListItem = new MsgListItem(R.drawable.avatar_03,"大学语文","","","");
        list.add(msgListItem);
        msgListItem = new MsgListItem(R.drawable.avatar_03,"体育","","","");
        list.add(msgListItem);


    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addItems();
                msgListAdapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        }, 1000);
    }
}
