package com.example.ted_dynamic.Child_Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ted_dynamic.R;

public class Newest_Frag extends Fragment {

    private OnFragmentInteractionListener newestListner;

    public interface OnFragmentInteractionListener{
        void messageFragment(Uri uri);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.newest_layout, container, false);
        return v;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            newestListner = (OnFragmentInteractionListener) context;
        }
    }

    public void onDetach(){
        super.onDetach();
        newestListner = null;
    }
}
