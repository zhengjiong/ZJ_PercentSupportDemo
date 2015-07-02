package com.zj.example.zj_perentsupportlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * create by zhengjiong
 * Date: 2015-07-02
 * Time: 08:51
 */
public class DemoFragment extends Fragment{

    public static DemoFragment newInstance(int layoutRes) {

        Bundle args = new Bundle();
        args.putInt("layout", layoutRes);

        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getArguments().getInt("layout");
        return inflater.inflate(layoutRes, container, false);
    }
}
