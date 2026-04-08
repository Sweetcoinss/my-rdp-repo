package virtual.camera.app.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.nukc.stateview.StateView;
import virtual.camera.app.R;

public class XposedFragment extends Fragment {
    
    private RecyclerView recyclerView;
    private StateView stateView;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        stateView = view.findViewById(R.id.stateView);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        // TODO: إعداد الـ Adapter لعرض قائمة وحدات Xposed
        
        return view;
    }
}
