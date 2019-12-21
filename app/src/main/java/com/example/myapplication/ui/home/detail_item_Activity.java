package com.example.myapplication.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.myapplication.R;

public class detail_item_Activity extends AppCompatActivity {

    private TextView courseid;
    private TextView name;
    private TextView code;
    private TextView categoryId;
    private TextView description;
    private TextView price;
    private TextView status;
    private TextView openDate;
    private TextView lastUpdateOn;
    private TextView level;
    private TextView shared;
    private TextView sharedUrl;
    private TextView avatar;
    private TextView bigAvatar;
    private TextView certification;
    private TextView certificationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item_);

        Intent intent = getIntent();
        detail_item detail_item=intent.getParcelableExtra("detail_item");

        System.out.println("77777777:"+detail_item);


        courseid = this.findViewById(R.id.id);
        code = this.findViewById(R.id.code);
        categoryId = this.findViewById(R.id.categoryId);
        description = this.findViewById(R.id.description);
        price = this.findViewById(R.id.price);
        status = this.findViewById(R.id.status);
        openDate = this.findViewById(R.id.openDate);
        lastUpdateOn = this.findViewById(R.id.lastUpdateOn);
        level = this.findViewById(R.id.level);
        shared = this.findViewById(R.id.shared);
        sharedUrl = this.findViewById(R.id.sharedUrl);
        avatar = this.findViewById(R.id.avatar);
        bigAvatar = this.findViewById(R.id.bigAvatar);
        certification = this.findViewById(R.id.certification);
        certificationDuration = this.findViewById(R.id.certificationDuration);

        courseid.setText("课程ID："+detail_item.getCourseid());
        code.setText("课程代码："+detail_item.getCode());
        categoryId.setText("目录ID："+detail_item.getCategoryId());
        description.setText("课程描述："+detail_item.getDescription());
        price.setText("课程价格："+detail_item.getPrice());
        status.setText("课程状态："+detail_item.getStatus());
        openDate.setText("开课日期："+detail_item.getOpenDate());
        lastUpdateOn.setText("最近更新时间："+detail_item.getLastUpdateOn());
        level.setText("课程等级："+detail_item.getLevel());
        shared.setText("分享："+detail_item.getShared());
        sharedUrl.setText("分享链接："+detail_item.getSharedUrl());
        avatar.setText("avatar:"+detail_item.getAvatar());
        bigAvatar.setText("bigavatar："+detail_item.getBigAvatar());
        certification.setText("认证："+detail_item.getCertification());
        certificationDuration.setText("认证时长："+detail_item.getCertificationDuration());


    }
}
