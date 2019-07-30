package com.example.ted_dynamic.Child_Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ted_dynamic.R;

public class Most_Viewed_Frag extends Fragment {
    private onFragmentInteractionListner mostViewedListner;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.most_viewed_layout, container, false);
        return v;
    }

    public interface onFragmentInteractionListner{
        void sendMessage(Uri uri);
    }

    public void onAttach(Context content){
        super.onAttach(content);
        if(content instanceof onFragmentInteractionListner){
            mostViewedListner = (onFragmentInteractionListner) content;
        }
    }

    public void onDetach(){
        super.onDetach();
        mostViewedListner = null;
    }
}
