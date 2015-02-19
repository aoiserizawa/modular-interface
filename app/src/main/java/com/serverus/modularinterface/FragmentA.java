package com.serverus.modularinterface;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by alvinvaldez on 2/16/15.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    ListView list;
    Communicator communicator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();

        //get the list view from xml
        list = (ListView) getActivity().findViewById(R.id.listView);

        // translate the string-array to ArrayAdapter to be set into a list
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);

        // use the adapter and use it as a reference for the list
        list.setAdapter(adapter);

        // set a onClick listener for each list item
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }
}
