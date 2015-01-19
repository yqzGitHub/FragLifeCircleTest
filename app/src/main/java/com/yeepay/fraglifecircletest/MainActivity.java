package com.yeepay.fraglifecircletest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.yeepay.fraglifecircletest.abs.AbsActivity;
import com.yeepay.fraglifecircletest.frag.FragA;
import com.yeepay.fraglifecircletest.frag.FragB;

public class MainActivity extends AbsActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;
    //widgets
    private Button btn1;
    private Button btn2;
    //Fragments
    private FragA fragA;
    private FragB fragB;
    private String[] fragNames;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void findViewsById() {
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
    }

    @Override
    public void initWidgets() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void loadData() {
        fragmentManager = getFragmentManager();
        fragNames = getResources().getStringArray(R.array.array_frag_name);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        switch (v.getId()) {
//            case R.id.button1:
//                if (fragA == null) {
//                    fragA = new FragA();
//                    fragmentTransaction.replace(R.id.frag_container, fragA, fragNames[0]);
//                    fragmentTransaction.addToBackStack(fragNames[0]);
//                } else {
//                    Fragment fragment = fragmentManager.findFragmentByTag(fragNames[0]);
//                    fragmentTransaction.replace(R.id.frag_container, fragment, fragNames[0]);
//                }
//                break;
//            case R.id.button2:
//                if (fragB == null) {
//                    fragB = new FragB();
//                    fragmentTransaction.replace(R.id.frag_container, fragB, fragNames[1]);
//                    fragmentTransaction.addToBackStack(fragNames[1]);
//                } else {
//                    Fragment fragment = fragmentManager.findFragmentByTag(fragNames[1]);
//                    fragmentTransaction.replace(R.id.frag_container, fragment, fragNames[1]);
//                }
//                break;
//            default:
//                break;
//        }

        switch (v.getId()) {
            case R.id.button1:
                hideAllFrags(fragmentTransaction);
                if (fragA == null) {
                    fragA = new FragA();
                    fragmentTransaction.add(R.id.frag_container, fragA, fragNames[0]);
                    fragmentTransaction.addToBackStack(fragNames[0]);
                } else {
                    fragmentTransaction.show(fragA);
                }
                break;
            case R.id.button2:
                hideAllFrags(fragmentTransaction);
                if (fragB == null) {
                    fragB = new FragB();
                    fragmentTransaction.add(R.id.frag_container, fragB, fragNames[1]);
                    fragmentTransaction.addToBackStack(fragNames[1]);
                } else {
                    fragmentTransaction.show(fragB);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideAllFrags(FragmentTransaction fragmentTransaction) {
        Log.i("hideAllFrags", "hideAllFrags");
        for (String name : fragNames) {
            Fragment fragment = fragmentManager.findFragmentByTag(name);
            if (fragment != null && !fragment.isHidden()) {
                fragmentTransaction.hide(fragment);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
