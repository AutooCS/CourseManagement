package com.example.wwk.myapplication;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class courseAdapter extends ArrayAdapter<Course> {

	private int resourceId;

	public courseAdapter(Context context, int textViewResourceId,
						 List<Course> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Course course1 = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.ItemName = (TextView) view.findViewById(R.id.ItemName);
			viewHolder.ItemSelect = (TextView) view.findViewById(R.id.ItemSelect);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.ItemName.setText(course1.getName());
		viewHolder.ItemSelect.setText(course1.getChoice());
		return view;
	}
	
	class ViewHolder {
		
		TextView ItemName;
		
		TextView ItemSelect;
		
	}

}
