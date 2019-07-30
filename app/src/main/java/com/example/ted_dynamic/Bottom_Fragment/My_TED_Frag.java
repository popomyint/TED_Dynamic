package com.example.ted_dynamic.Bottom_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ted_dynamic.R;

public class My_TED_Frag extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntantceState){
        View v = inflater.inflate(R.layout.myted_layout, container, false);
        return v;
    }
}
