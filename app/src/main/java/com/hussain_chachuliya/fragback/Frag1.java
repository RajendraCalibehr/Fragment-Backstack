package com.hussain_chachuliya.fragback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_one, container, false);

        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentTwo = FragmentUtil.getFragmentByTagName(fragmentManager, "Fragment Two");
                if (fragmentTwo == null) {
                    fragmentTwo = new Frag2();
                    fragmentTransaction.add(R.id.fragment_holder, fragmentTwo, "Fragment Two");
                    fragmentTransaction.hide(fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1));
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                            .show(fragmentTwo)
                            .hide(fragmentManager.getFragments().get(fragmentManager.getFragments().indexOf(fragmentTwo) - 1))
                            .commit();
                }
            }
        });

        return view;
    }

}
