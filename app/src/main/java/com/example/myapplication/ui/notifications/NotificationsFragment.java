package com.example.myapplication.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;



import com.example.myapplication.R;
public class NotificationsFragment extends Fragment {

    private ImageView blurImageView;
    private ImageView avatarImageView;
    private Context mContext;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        blurImageView = (ImageView) root.findViewById(R.id.iv_blur);
        avatarImageView = (ImageView) root.findViewById(R.id.iv_avatar);

        Glide.with(getActivity()).load(R.drawable.head)
                .bitmapTransform(new BlurTransformation(getActivity(), 25), new CenterCrop(getActivity()))
                .into(blurImageView);

        Glide.with(getActivity()).load(R.drawable.head)
                .bitmapTransform(new CropCircleTransformation(getActivity()))
                .into(avatarImageView);
        return root;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;//mContext 是成员变量，上下文引用
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}