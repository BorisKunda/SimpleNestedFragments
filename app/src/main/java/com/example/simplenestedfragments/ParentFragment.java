package com.example.simplenestedfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParentFragment extends Fragment {

    private TextView mTextView;
    private Child2Fragment mChild2Fragment;

    public ParentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ChildFragment childFragment = new ChildFragment();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.child_container1_ll, childFragment).commit();

        mChild2Fragment = new Child2Fragment();
        FragmentTransaction transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.replace(R.id.child_container2_ll, mChild2Fragment).commit();

        mTextView = view.findViewById(R.id.fr_parent_tv);

        Button button = view.findViewById(R.id.fr_parent_btn);
        Button button2 = view.findViewById(R.id.fr_parent_btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 11/05/2019 use child's public methods
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 11/05/2019 use child2's public methods
            }
        });

    }


    public void setTextView(String  textView) {
        mTextView.setText(textView);
    }

    public void setTextViewToCh2(String message) {
        mChild2Fragment.setText(message);
    }
}
