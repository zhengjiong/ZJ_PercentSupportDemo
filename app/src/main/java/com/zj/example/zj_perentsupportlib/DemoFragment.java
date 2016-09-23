package com.zj.example.zj_perentsupportlib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * create by zhengjiong
 * Date: 2015-07-02
 * Time: 08:51
 */
public class DemoFragment extends Fragment{

    public static DemoFragment newInstance(int layoutRes, String title) {

        Bundle args = new Bundle();
        args.putInt("layout", layoutRes);
        args.putString("title", title);

        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getArguments().getInt("layout");
        String title = getArguments().getString("title");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

        return inflater.inflate(layoutRes, container, false);
    }
}
