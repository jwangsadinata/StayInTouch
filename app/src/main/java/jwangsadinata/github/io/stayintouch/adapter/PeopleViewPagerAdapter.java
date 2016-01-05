package jwangsadinata.github.io.stayintouch.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jwangsadinata.github.io.stayintouch.fragment.ProfessorFragment;
import jwangsadinata.github.io.stayintouch.fragment.StaffFragment;
import jwangsadinata.github.io.stayintouch.fragment.StudentFragment;

/**
 * Created by Jason on 12/6/15.
 */
public class PeopleViewPagerAdapter extends FragmentPagerAdapter {

    public PeopleViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Student";
            case 1:
                return "Professor";
            case 2:
                return "Staff";
            default:
                return "Student";
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StudentFragment();
            case 1:
                return new ProfessorFragment();
            case 2:
                return new StaffFragment();
            default:
                return new StudentFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
