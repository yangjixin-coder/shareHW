package com.example.myapplication.ui.home;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //private HomeViewModel homeViewModel;
    String url = "http://tang5618.com:8080/elearn/courses";
    private List<recyle_item> itemList = new ArrayList<recyle_item>();
    private List<detail_item> detail_itemList = new ArrayList<detail_item>();
    private View view;//定义view用来设置fragment的layout
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel =
        //        ViewModelProviders.of(this).get(HomeViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_home, container, false);
        //获取fragment的layout
        view = inflater.inflate(R.layout.fragment_home, container, false);

        //模拟数据
        try {
            init_recyle_item();
            System.out.println("nmsl");
            //对recycleview进行配置
            recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyle_item_Adapter adapter = new recyle_item_Adapter(itemList);
            recyclerView.setAdapter(adapter);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return view;

    }

    private void init_recyle_item() throws InterruptedException {
        //解析json
        Thread a = new Thread() {
            @Override
            public void run() {

                String result = gethttpresult(url);
                System.out.println(result);
                if (result == null) {
                   // Looper.prepare();
                    Toast.makeText(getContext(), "网络连接错误！", Toast.LENGTH_SHORT).show();
                   // Looper.loop();
                } else {
                    JSONArray result_json = null;
                    try {
                        result_json = new JSONArray(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < result_json.length(); i++) {
                        System.out.println("6666666666666");
                        try {
                            recyle_item item = new recyle_item(result_json.getJSONObject(i).
                                    getString("id"), result_json.getJSONObject(i).getString("name"),
                                    result_json.getJSONObject(i).getString("description"));

                            detail_item ditem = new detail_item(result_json.getJSONObject(i).getString("id"),
                                    result_json.getJSONObject(i).getString("name"),
                                    result_json.getJSONObject(i).getString("code"),
                                    result_json.getJSONObject(i).getString("categoryId"),
                                    result_json.getJSONObject(i).getString("description"),
                                    result_json.getJSONObject(i).getString("price"),
                                    result_json.getJSONObject(i).getString("status"),
                                    result_json.getJSONObject(i).getString("openDate"),
                                    result_json.getJSONObject(i).getString("lastUpdateOn"),
                                    result_json.getJSONObject(i).getString("level"),
                                    result_json.getJSONObject(i).getString("shared"),
                                    result_json.getJSONObject(i).getString("sharedUrl"),
                                    result_json.getJSONObject(i).getString("avatar"),
                                    result_json.getJSONObject(i).getString("bigAvatar"),
                                    result_json.getJSONObject(i).getString("certification"),
                                    result_json.getJSONObject(i).getString("certificationDuration")
                                    );

                            itemList.add(item);
                            detail_itemList.add(ditem);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        a.start();
        a.join();


    }

    public static String gethttpresult(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            InputStream input = connect.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String line = "";
            System.out.println(connect.getResponseCode());
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    private class myViewHolder extends RecyclerView.ViewHolder {
        private TextView courseId;
        private TextView courseName;
        private TextView courseDescription;
        private  recyle_item item;


        public myViewHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.recyle_item,parent,false));
            courseId =(TextView) itemView.findViewById(R.id.course_id);
            courseName = (TextView) itemView.findViewById(R.id.course_name);
            courseDescription = (TextView) itemView.findViewById(R.id.description);
        }

        public void bind(recyle_item item){
            this.item=item;
            courseId.setText(item.getCourseid());
            courseName.setText(item.getName());
            courseDescription.setText(item.getDescription());

        }
    }

    private class myViewHolder2 extends RecyclerView.ViewHolder {
        private TextView courseId;
        private TextView courseName;
        private TextView courseDescription;
        private VideoView courseVideo;
        private  recyle_item item;


        public myViewHolder2(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.recyle_image_item,parent,false));
            courseId =(TextView) itemView.findViewById(R.id.course_id2);
            courseName = (TextView) itemView.findViewById(R.id.course_name2);
            courseDescription = (TextView) itemView.findViewById(R.id.description2);
            courseVideo= (VideoView) itemView.findViewById(R.id.course_video);
        }

        public void bind(recyle_item item){
            this.item=item;
            courseId.setText(item.getCourseid());
            courseName.setText(item.getName());
            courseDescription.setText(item.getDescription());
            courseVideo.setVideoPath("http://tang5618.com:8080/elearn/materials/1/media");
            /**为控件设置焦点*/
            courseVideo.requestFocus();
            /**         * 为 VideoView 视图设置媒体控制器，设置了之后就会自动由进度条、前进、后退等操作         */
            courseVideo.setMediaController(new MediaController(getContext()));
            /**视频准备完成时回调         * */
            courseVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i("tag", "--------------视频准备完毕,可以进行播放.......");
                }        });
            /**         * 视频播放完成时回调         */
            courseVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Log.i("tag", "------------------视频播放完毕..........");
                } });
            /**         * 视频播放发送错误时回调         */
            courseVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Log.i("tag", "---------------------视频播放失败...........");
                    return false;
                }  });

            courseVideo.start();
        }
    }



     private class recyle_item_Adapter extends RecyclerView.Adapter{

         public final static int GENERAL_ITEM = 1001;
         public final static int PHOTO_ITEM = 1002;
         private List<recyle_item> itemList;
         //定义点击事件
         private AdapterView.OnItemClickListener onItemClickListener;

         public recyle_item_Adapter( List<recyle_item> courseList) {

             this.itemList = courseList;
         }
         @NonNull
         @Override
         public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

             if(viewType == GENERAL_ITEM){
                 LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                 return new myViewHolder(layoutInflater,parent);
             }else if(viewType == PHOTO_ITEM){
                 LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                 return new myViewHolder2(layoutInflater,parent);
             }
             LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
             return new myViewHolder(layoutInflater,parent);
         }


         @Override
         public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

             if(holder instanceof myViewHolder){
                    recyle_item ritem = itemList.get(position);
                    myViewHolder viewHolder=(myViewHolder)holder;
                    viewHolder.bind(ritem);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {            @Override
                    public void onClick(View v) {

                        //点击条目进行跳转到另外一个Activity
                        Intent intent=new Intent(v.getContext(),detail_item_Activity.class);
                        detail_item detail_item = detail_itemList.get(position);
                        intent.putExtra("detail_item",detail_item);
                        v.getContext().startActivity(intent);            }        });

             }else if(holder instanceof myViewHolder2){
                    recyle_item ritem = itemList.get(position);
                    myViewHolder2 viewHolder2=(myViewHolder2)holder;
                    viewHolder2.bind(ritem);
                    viewHolder2.itemView.setOnClickListener(new View.OnClickListener() {            @Override
                 public void onClick(View v) {

                     //点击条目进行跳转到另外一个Activity
                     Intent intent=new Intent(v.getContext(),detail_item_Activity.class);
                     detail_item detail_item = detail_itemList.get(position);
                     intent.putExtra("detail_item",detail_item);
                     v.getContext().startActivity(intent);            }        });
             }
         }

         @Override
         public int getItemCount() {
             return itemList.size();
         }

         @Override
         public int getItemViewType(int position){
             if(position==0){
                return GENERAL_ITEM;
             }else if(position==1){
                return PHOTO_ITEM;
             }else {
                 return super.getItemViewType(position);
             }
         }
     }


}