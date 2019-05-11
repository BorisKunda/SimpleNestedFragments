package com.example.simplenestedfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
                                                  implements ChildFragment.ChildToParentCommunicator,
                                                             ChildFragment.ChildToChild2Communicator {

    private ParentFragment mParentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mParentFragment = new ParentFragment();

        getSupportFragmentManager().beginTransaction().
                add(R.id.container, mParentFragment,"parent_fragment")
                .commit();


    }

    @Override
    public void sendChToPr(String message) {
        mParentFragment.setTextView(message);
    }

    @Override
    public void sendChToCh2(String message) {
        mParentFragment.setTextViewToCh2(message);
    }
}
