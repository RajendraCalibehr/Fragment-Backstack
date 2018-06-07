package com.hussain_chachuliya.fragback;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

public class FragmentUtil {

    // Get exist Fragment by it's tag name.
    public static Fragment getFragmentByTagName(FragmentManager fragmentManager, String fragmentTagName) {
        Fragment ret = null;

        // Get all Fragment list.
        List<Fragment> fragmentList = fragmentManager.getFragments();

        if (fragmentList != null) {
            int size = fragmentList.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragmentList.get(i);

                if (fragment != null) {
                    String fragmentTag = fragment.getTag();

                    // If Fragment tag name is equal then return it.
                    if (fragmentTag.equals(fragmentTagName)) {
                        ret = fragment;
                    }
                }
            }
        }

        return ret;
    }

    public static Fragment getVisibleFragment(FragmentManager fragmentManager){
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }
}
