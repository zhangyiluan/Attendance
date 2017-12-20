package android.com.gaoxiao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends BaseActivity  {
    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private Button login;

    private CheckBox rememberPass;
    private EditText nameEdit,passwordEdit;
    private Button loginButtonHttpURLConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        loginButtonHttpURLConnectionOption();

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox) findViewById(R.id.remember_password);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            // 将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            nameEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

    }

    private void loginButtonHttpURLConnectionOption() {
        loginButtonHttpURLConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url=HttpUtilsHttpURLConnection.BASE_URL+"/servlet/LoginServlet";
                        Map<String, String> params = new HashMap<String, String>();
                        String name=nameEdit.getText().toString();
                        String password=passwordEdit.getText().toString();
                        params.put("name",name);
                        params.put("password",password);

                        editor = pref.edit();
                        if (rememberPass.isChecked()) { // 检查复选框是否被选中
                            editor.putBoolean("remember_password", true);
                            editor.putString("name", name);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.apply();

                        String result = HttpUtilsHttpURLConnection.getContextByHttp(url,params);

                        Message msg = new Message();
                        msg.what=0x12;
                        Bundle data=new Bundle();
                        data.putString("result",result);
                        msg.setData(data);


                        hander.sendMessage(msg);
                    }

                    Handler hander = new Handler(){
                        @Override
                        public void handleMessage(Message msg) {
                            if (msg.what==0x12){
                                Bundle data = msg.getData();
                                String key = data.getString("result");//得到json返回的json
//                                   Toast.makeText(MainActivity.this,key,Toast.LENGTH_LONG).show();
                                try {
                                    JSONObject json= new JSONObject(key);
                                    String result = (String) json.get("result");
                                    if ("success".equals(result)){
                                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else if("error".equals(result)){
                                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                }).start();
            }
        });
    }


    private void init() {
        nameEdit = (EditText) findViewById(R.id.username_inputbox);
        passwordEdit = (EditText) findViewById(R.id.password_inputbox);
        loginButtonHttpURLConnection= (Button) findViewById(R.id.login_btn);
    }


}