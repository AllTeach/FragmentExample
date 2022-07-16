package com.example.fragmentcodelab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment.

        final View rootView =
                inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        final RatingBar ratingBar = rootView.findViewById(R.id.rbFragment);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getContext(),"" + rating,Toast.LENGTH_SHORT).show();

            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            //TextView textView =
              //      rootView.findViewById(R.id.tvFragmentResut);
            switch (index) {
                case YES: // User chose "Yes."
                //    textView.setText("Great");
                    Toast.makeText(getContext(),"Like!",Toast.LENGTH_SHORT).show();
                    break;
                case NO: // User chose "No."
                   // textView.setText("Try Again...");
                    Toast.makeText(getContext(),"Not Quite!",Toast.LENGTH_SHORT).show();
                    break;
                default: // No choice made.
                    // Do nothing.
                    break;
            }
        });

    // Return the View for the fragment's UI.
        return rootView;
    }
}