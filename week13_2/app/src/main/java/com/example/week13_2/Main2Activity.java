package com.example.week13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class Main2Activity extends AppCompatActivity {
    //ListView 控件使用
    private ListView mListView;
    private String[] names = {"1", "2", "3", "4", "5"};
    private int[] icons = {R.drawable.test, R.drawable.two, R.drawable.san, R.drawable.si, R.drawable.wu};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choose);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();//创建一个适配器的实例
        mListView.setAdapter(mAdapter);//设置适配器
    }
    class MyBaseAdapter extends BaseAdapter {
        //得到item的总数
        public int getCount() {//返回 List view item 条目的总数
            return names.length;
        }
        //得到item代表的对象
        public Object getItem(int position){
        //返回List view item 条目代表的对象
            return names[position];
        }
        //得到item的id
        public long getItemId(int position) {
        //返回List view item 的id
            return position;
        }
        //得到item的view视图
        public View getView(final int position, View convertView, ViewGroup parent) {
        //将List view_xml文件找出来并转换成view 对象
            View view = View.inflate(Main2Activity.this, R.layout.view, null);
            TextView mTextView = (TextView) view.findViewById(R.id.item_tv);
            mTextView.setText(names[position]);
            ImageView mImageView = (ImageView) view.findViewById(R.id.item_image);
            mImageView.setBackgroundResource(icons[position]);
            //给ListView中的Item写点击事件
            //来确定ListView中Item对应的yinyue
            //点击之后跳转页面
            view.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                    switch (position){
                        case 0:
                            intent.putExtra("music", "0");
                            break;
                        case 1:
                            intent.putExtra("music", "1");
                            break;
                        case 2:
                            intent.putExtra("music", "2");
                            break;
                        case 3:
                            intent.putExtra("music", "3");
                            break;
                        case 4:
                            intent.putExtra("music", "4");
                            break;
                        default:
                            break;
                    }
                    startActivity(intent);
                }

            });
            return view;
        }
    }
}