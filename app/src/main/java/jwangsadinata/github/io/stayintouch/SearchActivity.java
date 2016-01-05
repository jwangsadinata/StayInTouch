package jwangsadinata.github.io.stayintouch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import jwangsadinata.github.io.stayintouch.adapter.SearchPeopleAdapter;
import jwangsadinata.github.io.stayintouch.data.People;

/**
 * Created by Jason on 12/6/15.
 */
public class SearchActivity extends AppCompatActivity implements TextView.OnEditorActionListener, AdapterView.OnItemClickListener {
    private static final String NAME_KEY = "NAME_KEY";
    public final String ARRAY_KEY = "array_key";

    ListView mListView;
    SearchPeopleAdapter searchAdapter;
    EditText mtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.mListView);
        searchAdapter = new SearchPeopleAdapter(this);
        mtxt = (EditText) findViewById(R.id.edSearch);
        mtxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (0 != mtxt.getText().length()) {
                    String spnId = mtxt.getText().toString();
                    setSearchResult(spnId);
                } else {
                    setData();
                }
            }
        });
        setData();
    }

    public static String[] mHeader = { "Student", "Professor", "Staff", };
    ArrayList<HashMap<String, String>> mAllData;
    ArrayList<HashMap<String, String>> mCacheCopy;

    public void setData() {
        People people = new People();
        String[] students = people.getStudents();
        String[] professor = people.getProfessor();
        String[] staff = people.getStaff();

        searchAdapter = new SearchPeopleAdapter(this);
        HashMap<String, String> mData = new HashMap<String, String>();
        mData.put(ARRAY_KEY, "Student");
        searchAdapter.addSeparatorItem(mData);
        Temp mTem = new Temp();
        for (int i = 0; i < students.length; i++) {
            mData = new HashMap<String, String>();
            mData.put(ARRAY_KEY, students[i]);
            mTem.setData(mData);
            searchAdapter.addItem(mData);
        }
        mAllVector.add(mTem);


        mData = new HashMap<String, String>();
        mData.put(ARRAY_KEY, "Professor");
        searchAdapter.addSeparatorItem(mData);
        mTem = new Temp();
        for (int i = 0; i < professor.length; i++) {
            mData = new HashMap<String, String>();
            mData.put(ARRAY_KEY, professor[i]);
            mTem.setData(mData);
            searchAdapter.addItem(mData);
        }
        mAllVector.add(mTem);


        mData = new HashMap<String, String>();
        mData.put(ARRAY_KEY, "Staff");
        searchAdapter.addSeparatorItem(mData);
        mTem = new Temp();
        for (int i = 0; i < staff.length; i++) {
            mData = new HashMap<String, String>();
            mData.put(ARRAY_KEY, staff[i]);
            mTem.setData(mData);
            searchAdapter.addItem(mData);
        }
        mAllVector.add(mTem);

        mListView.setOnItemClickListener(this);
        mListView.setAdapter(searchAdapter);
    }

    Vector<Temp> mAllVector = new Vector<Temp>();

    private class Temp {
        ArrayList<HashMap<String, String>> mAll = new ArrayList<HashMap<String, String>>();

        public void setData(HashMap<String, String> m) {
            mAll.add(m);
        }

        public ArrayList<HashMap<String, String>> getetData() {
            return mAll;
        }
    }

    public void setSearchResult(String str) {
        searchAdapter = new SearchPeopleAdapter(this);
        int i = 0;
        for (Temp temp : mAllVector) {
            switch (i) {
                case 0:
                    findArray("Student", str, temp.getetData());
                    break;
                case 1:
                    findArray("Professor", str, temp.getetData());
                    break;
                case 2:
                    findArray("Staff", str, temp.getetData());
                    break;
            }
            i++;
        }
        mListView.setAdapter(searchAdapter);
    }

    public void findArray(String header, String str,
                          ArrayList<HashMap<String, String>> mAll) {
        boolean isFound = false;
        for (HashMap<String, String> mTemp : mAll) {
            if (mTemp.get(ARRAY_KEY).toLowerCase().contains(str.toLowerCase())) {
                if (!isFound) {
                    HashMap<String, String> head = new HashMap<String, String>();
                    head.put(ARRAY_KEY, header);
                    searchAdapter.addSeparatorItem(head);
                    searchAdapter.addItem(mTemp);
                    isFound = true;
                } else {
                    searchAdapter.addItem(mTemp);
                }
            }
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                            long arg3) {
        HashMap<String, String> mItem = searchAdapter.getItem(position);
        Intent intent = new Intent(SearchActivity.this, SecondActivity.class);
        switch (mItem.get(ARRAY_KEY)) {
            case "Joe Koshakow":
                intent.putExtra(NAME_KEY, "Joe Koshakow");
                startActivity(intent);
                break;
            case "Kendell Byrd":
                intent.putExtra(NAME_KEY, "Kendell Byrd");
                startActivity(intent);
                break;
            case "Gyula Y. Katona":
                intent.putExtra(NAME_KEY, "Gyula Y. Katona");
                startActivity(intent);
                break;
            case "Péter Ekler":
                intent.putExtra(NAME_KEY, "Péter Ekler");
                startActivity(intent);
                break;
            case "Ákos Kocsány":
                intent.putExtra(NAME_KEY, "Ákos Kocsány");
                startActivity(intent);
                break;
            case "Jason Wangsadinata":
                intent.putExtra(NAME_KEY, "Jason Wangsadinata");
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, mItem.get(ARRAY_KEY), Toast.LENGTH_LONG).show();
        }
    }
}