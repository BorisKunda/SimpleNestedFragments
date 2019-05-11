package com.example.simplenestedfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends Fragment {

    private ChildToParentCommunicator mChildToParentCommunicator;
    private ChildToChild2Communicator mChildToChild2Communicator;

    interface ChildToParentCommunicator {
        void sendChToPr(String message);
    }

    interface ChildToChild2Communicator {
        void sendChToCh2(String message);
    }

    public ChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn1 = view.findViewById(R.id.fr_ch_btn1);
        Button btn2 = view.findViewById(R.id.fr_ch_btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChildToParentCommunicator.sendChToPr("Hey From Child Fr");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mChildToChild2Communicator.sendChToCh2("Hey From another fragment");
            }
        });



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ChildToChild2Communicator) {
            mChildToChild2Communicator = (ChildToChild2Communicator) context;
        } else {
            throw
                    new RuntimeException("MainActivity must implement " +
                            "ChildToChild2Communicator");
        }


        if (context instanceof ChildToParentCommunicator) {
            mChildToParentCommunicator = (ChildToParentCommunicator) context;
        } else {
            throw
                    new RuntimeException("MainActivity must implement " +
                            "ChildToParentCommunicator");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mChildToParentCommunicator = null;
    }



}
