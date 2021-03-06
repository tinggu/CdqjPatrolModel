package com.cdqj.cdqjpatrolandroid.comstomview.dropdownmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdqj.cdqjpatrolandroid.R;

import java.util.List;

/**
 * Created by lyf on 2017/9/29.
 *
 */
public class SpinnerGridAdapter extends BaseSpinnerAdapter{

    private List<SelectSpinnerBean> mObjects;

    private LayoutInflater mInflater;

    private Context context;

    public SpinnerGridAdapter(Context context, List<SelectSpinnerBean> mObjects){
        this.mObjects = mObjects;
        this.context = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return mObjects.size();
    }

    @Override
    public Object getItem(int pos) {
        return mObjects.get(pos).toString();
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int pos, View convertView, ViewGroup arg2) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cdqj_patrol_spinner_grid_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = convertView.findViewById(R.id.spinner_item_textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SelectSpinnerBean item =  mObjects.get(pos);

        if (!isSingle) {
            viewHolder.mTextView.setTextColor(ContextCompat.getColor(context,
                    item.isSelect()?R.color.theme_one:R.color.text_gray_to));
            viewHolder.mTextView.setBackgroundResource(item.isSelect()?R.drawable.stroke_bg_radius_them_blue_4:R.drawable.stroke_bg_radius_them_4);
        }
        viewHolder.mTextView.setText(item.getTitle());

        return convertView;
    }

    public static class ViewHolder {
        TextView mTextView;
    }
}
