package com.example.lab23;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Nhận dữ liệu từ LoginActivity (nếu có)
        Intent loginData = getIntent();
        String username = loginData.getStringExtra("Username");
        String password = loginData.getStringExtra("password");

        navView = findViewById(R.id.nav_view);

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {

                Fragment fragment = null;
                int id = item.getItemId();

                if (id == R.id.navigation_home) {
                    fragment = new HomeFragment();
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle("Home");
                    }

                } else if (id == R.id.navigation_dashboard) {
                    fragment = new DashboardFragment();
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle("Dashboard");
                    }

                } else if (id == R.id.navigation_notifications) {
                    fragment = new NotificationsFragment();
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle("Notification");
                    }

                } else if (id == R.id.navigation_account) {
                    // Mở InforActivity, truyền dữ liệu từ Login sang
                    Intent intent = new Intent(MainActivity.this, InforActivity.class);
                    intent.putExtra("Username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    return true;
                }

                if (fragment != null) {
                    loadFragment(fragment);
                    return true;
                }
                return false;
            }
        });

        // Chọn mặc định Dashboard
        navView.setSelectedItemId(R.id.navigation_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}
