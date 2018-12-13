package com.circlezero.animatedcustomlistlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;


class ListViewAdapter extends BaseAdapter {

    private static String animationType="";

    public ListViewAdapter() {
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Integer getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.customlist_item, parent, false);
        }
        TextView tv_name = (TextView) convertView.findViewById(R.id.list_item_text);
        tv_name.setText("Number : " + String.valueOf(position));


        if (animationType.equals("Alpha with translate animation")) {

            TranslateAnimation translateAnimation = new TranslateAnimation(300, 0, 0, 0);
            Animation alphaAnimation = new AlphaAnimation(0, 1);
            translateAnimation.setDuration(500);
            alphaAnimation.setDuration(1300);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(translateAnimation);
            animation.addAnimation(alphaAnimation);
            convertView.setAnimation(animation);

        } else if (animationType.equals("Only alpha animation")) {

            Animation animation = new AlphaAnimation(0, 1);
            animation.setDuration(1500);
            convertView.setAnimation(animation);

        } else if (animationType.equals("Only scale animation")) {

            Animation animation = new ScaleAnimation(
                    0f, 1f,
                    0, 1f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 1f);
            animation.setFillAfter(true);
            animation.setDuration(1500);
            convertView.setAnimation(animation);

        }

        return convertView;
    }

    public void setListAnimation(String listAnimation) {
        this.animationType = listAnimation;
    }
}
