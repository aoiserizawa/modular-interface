package com.serverus.modularinterface;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alvinvaldez on 2/16/15.
 */
public class FragmentB extends Fragment {
    TextView text;
    String data;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_b, container, false);

        if(savedInstanceState != null) {
            data = savedInstanceState.getString("text");
            text = (TextView) view.findViewById(R.id.textView);
            text.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        text = (TextView) getActivity().findViewById(R.id.textView);
    }

    public void changeData(int position){
        Resources res = getResources(); // to get the resources values
        // getting the resources string-array description
        // then push it inside the String[] array
        String[] descriptions = res.getStringArray(R.array.descriptions);
        // get call the description index
        data = descriptions[position];
        
        text.setText(descriptions[position]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);
    }


}
