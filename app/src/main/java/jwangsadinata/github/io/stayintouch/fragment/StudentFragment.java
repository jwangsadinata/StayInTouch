package jwangsadinata.github.io.stayintouch.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import jwangsadinata.github.io.stayintouch.R;
import jwangsadinata.github.io.stayintouch.adapter.TabPeopleAdapter;
import jwangsadinata.github.io.stayintouch.data.People;

/**
 * Created by Jason on 12/6/15.
 */
public class StudentFragment extends Fragment {
    public static final String TAG = "STUDENT";

    People people = new People();
    String[] student = people.getStudents();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<String> items = new ArrayList<String>();
        items.addAll(Arrays.asList(student).subList(0, student.length));

        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TabPeopleAdapter(items));

        return rootView;
    }
}