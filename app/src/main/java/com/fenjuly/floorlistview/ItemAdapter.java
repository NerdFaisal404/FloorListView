package com.fenjuly.floorlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

/**
 * Created by liurongchan on 16/2/25.
 */
public class ItemAdapter extends BaseAdapter {

    Context mContext;

    public ItemAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        }
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("mTranstateY", position + "");
                return false;
            }
        });
        final View view = convertView;
        TextView textView = (TextView) convertView.findViewById(R.id.textview);
        textView.setText("I Am Number " + position );
        SwipeLayout swipeLayout = (SwipeLayout) convertView.findViewById(R.id.swipe);
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {
                view.setElevation(dp2px(4));
            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {
                view.setElevation(dp2px(1));
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });
        return convertView;
    }

    private float dp2px(float dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

}
