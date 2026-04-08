package virtual.camera.app.view.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import virtual.camera.app.R;
import virtual.camera.app.adapter.MainPagerAdapter;
import virtual.camera.app.util.AppUtil;
import virtual.camera.app.util.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private WormDotsIndicator dotsIndicator;
    private FloatingActionButton fab;
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupViewPager();
        setupListeners();
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        dotsIndicator = findViewById(R.id.dots_indicator);
        fab = findViewById(R.id.fab);
    }

    private void setupViewPager() {
        pagerAdapter = new MainPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        dotsIndicator.setViewPager2(viewPager);
    }

    private void setupListeners() {
        fab.setOnClickListener(v -> {
            // إضافة تطبيق جديد
            ToastUtils.showToast("Add new app feature coming soon");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_setting) {
            // فتح إعدادات الكاميرا
            ToastUtils.showToast("Settings");
            return true;
        } else if (id == R.id.killApps) {
            AppUtil.killAllApps();
            ToastUtils.showToast("All apps killed");
            return true;
        } else if (id == R.id.open_source) {
            DialogUtil.showDialog(this, false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
