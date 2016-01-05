package jwangsadinata.github.io.stayintouch.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import jwangsadinata.github.io.stayintouch.R;

/**
 * Created by Jason on 12/6/15.
 */
public class SearchPeopleAdapter extends BaseAdapter {
    private final String ARRAY_KEY = "array_key";
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;

    private ArrayList<HashMap<String, String>> mData = new ArrayList<HashMap<String, String>>();
    private LayoutInflater mInflater;

    private TreeSet<Integer> mSeparatorsSet = new TreeSet<Integer>();

    public SearchPeopleAdapter(Activity activity) {
        mInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(HashMap<String, String> item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSeparatorItem(HashMap<String, String> item) {
        mData.add(item);
        mSeparatorsSet.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    public int getCount() {
        return mData.size();
    }

    public HashMap<String, String> getItem(int position) {
        return mData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        System.out.println("getView " + position + " " + convertView
                + " type = " + type);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.layout_name, null);
                    holder.textView = (TextView) convertView
                            .findViewById(R.id.tvList_Item);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.layout_category, null);
                    holder.textView = (TextView) convertView
                            .findViewById(R.id.textSeparator);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> mTemp = mData.get(position);
        holder.textView.setText(mTemp.get(ARRAY_KEY));
        return convertView;
    }

    public class ViewHolder {
        public TextView textView;
    }

}
