package jwangsadinata.github.io.stayintouch.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jwangsadinata.github.io.stayintouch.MainActivity;
import jwangsadinata.github.io.stayintouch.R;
import jwangsadinata.github.io.stayintouch.SecondActivity;

/**
 * Created by Jason on 12/6/15.
 */
public class TabPeopleAdapter extends RecyclerView.Adapter<TabPeopleAdapter.ViewHolder> {

    private static final String NAME_KEY = "NAME_KEY";
    private List<String> mItems;

    public TabPeopleAdapter(List<String> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_name, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        String item = mItems.get(i);
        viewHolder.mTextView.setText(item);

        switch (item) {
            case "Joe Koshakow":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Joe Koshakow");
                        context.startActivity(intent);
                    }
                });
                break;
            case "Kendell Byrd":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Kendell Byrd");
                        context.startActivity(intent);
                    }
                });
                break;
            case "Gyula Y. Katona":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Gyula Y. Katona");
                        context.startActivity(intent);
                    }
                });
                break;
            case "Péter Ekler":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Péter Ekler");
                        context.startActivity(intent);
                    }
                });
                break;
            case "Ákos Kocsány":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Ákos Kocsány");
                        context.startActivity(intent);
                    }
                });
                break;
            case "Jason Wangsadinata":
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, SecondActivity.class);
                        intent.putExtra(NAME_KEY, "Jason Wangsadinata");
                        context.startActivity(intent);
                    }
                });
                break;
            default:
                viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Toast.makeText(context, mItems.get(i), Toast.LENGTH_SHORT).show();
                    }
                });

        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.tvList_Item);
        }
    }

}