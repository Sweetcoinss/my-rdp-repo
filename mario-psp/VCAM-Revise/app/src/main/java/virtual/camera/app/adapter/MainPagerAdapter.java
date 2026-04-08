package virtual.camera.app.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import virtual.camera.app.view.main.AppsFragment;
import virtual.camera.app.view.main.XposedFragment;

public class MainPagerAdapter extends FragmentStateAdapter {
    
    private final Context context;
    
    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.context = fragmentActivity;
    }
    
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AppsFragment();
            case 1:
                return new XposedFragment();
            default:
                return new AppsFragment();
        }
    }
    
    @Override
    public int getItemCount() {
        return 2;
    }
    
    public String getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Applications";
            case 1:
                return "Xposed Modules";
            default:
                return "";
        }
    }
}
