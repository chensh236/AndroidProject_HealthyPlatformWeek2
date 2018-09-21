package com.example.chensihang.project_week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button search_button;

    // 显示吐司
    private void ToastDisplayer(String input){
        Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_button = findViewById(R.id.search_button);
        search_button.setOnClickListener(new EnterClickListener());

        //  选中内容的提示
        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);
        RadioButton rb4 = findViewById(R.id.rb4);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ToastDisplayer("图片被选中");
            }
        });
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ToastDisplayer("视频被选中");
            }
        });
        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ToastDisplayer("问答被选中");
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ToastDisplayer("资讯被选中");
            }
        });
    }

    class EnterClickListener implements android.view.View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText search_text  = findViewById (R.id.search_text);
            String getText = search_text.getText().toString();

            //  判断搜索的结果
            if(getText.compareTo("") == 0){
                ToastDisplayer("搜索内容不能为空");
            } else if(getText.compareTo("Health") == 0){
                correctDialog();
            } else{
                failDialog();
            }
        }
        // 显示正确的对话框
        private void correctDialog(){

            //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);

            //    设置Title的图标
            builder.setIcon(R.drawable.ic_launcher_foreground);

            //    设置Title的内容
            builder.setTitle("提示");

            //    设置Content来显示一个信息
            builder.setMessage("回答搜索成功");

            //    设置一个PositiveButton
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
//                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
            });
            //    设置一个NegativeButton
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
//                    Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                }
            });

            //    显示出该对话框
            builder.show();

        }

        // 显示失败的对话框
        private void failDialog(){

            //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);

            //    设置Title的图标
            builder.setIcon(R.drawable.ic_launcher_foreground);

            //    设置Title的内容
            builder.setTitle("提示");

            //    设置Content来显示一个信息
            builder.setMessage("搜索失败");

            //    设置一个PositiveButton
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
//                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
            });
            //    设置一个NegativeButton
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
//                    Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                }
            });

            //    显示出该对话框
            builder.show();

        }
    }
}
