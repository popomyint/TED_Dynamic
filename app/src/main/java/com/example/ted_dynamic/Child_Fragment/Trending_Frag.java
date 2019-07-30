package com.example.ted_dynamic.Child_Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ted_dynamic.R;

public class Trending_Frag extends Fragment {
    private onFragmentInterface trendingListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInztanceState){
        View v = inflater.inflate(R.layout.trending_layout, container, false);
        return v;
    }

    public interface onFragmentInterface{
        void trendingInterface(Uri uri);
    }

    public void onAttach(Context content){
        super.onAttach(content);
        if(content instanceof onFragmentInterface){
            trendingListener = (onFragmentInterface) content;
        }
    }

    public void onDetach(){
        super.onDetach();
        trendingListener = null;
    }
}
