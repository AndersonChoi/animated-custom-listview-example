package com.circlezero.animatedcustomlistlayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.custom_list);
        mAdapter = new ListViewAdapter();
        mListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_dialog:
                showAnimationSettingDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void showAnimationSettingDialog() {
        final CharSequence[] animationTypeList = new CharSequence[3];
        animationTypeList[0] = "Alpha with translate animation";
        animationTypeList[1] = "Only alpha animation";
        animationTypeList[2] = "Only scale animation";

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Set animation");
        dialogBuilder.setItems(animationTypeList, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                mAdapter.setListAnimation(animationTypeList[item].toString());
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();

    }
}
