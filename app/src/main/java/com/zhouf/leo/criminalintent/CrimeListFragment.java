package com.zhouf.leo.criminalintent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by Leo on 2017-5-3.
 */

public class CrimeListFragment extends ListFragment {
    private static final String TAG = "CrimeListFragment";

    private ArrayList<Crime> crimes;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        crimes = CrimeLab.get(getActivity()).getCrimes();
//        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,crimes);
        CrimeAdapter adapter = new CrimeAdapter(crimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime)l.getItemAtPosition(position);
        Log.d(TAG, "onListItemClick: Title=" + c.getTitle());
    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);
            }

            Crime c = getItem(position);

            TextView title = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            title.setText(c.getTitle());
            TextView date = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            date.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss",c.getDate()).toString());
            CheckBox checkbox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            checkbox.setChecked(c.isSolved());

            return convertView;
        }
    }
}
