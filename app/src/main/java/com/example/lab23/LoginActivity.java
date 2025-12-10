package com.example.lab23;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Sự kiện LOGIN
        btnLogin.setOnClickListener(v -> {

            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            // Nếu username hoặc password trống -> hiện dialog hỏi có muốn đăng ký không
            if (user.isEmpty() || pass.isEmpty()) {

                final Dialog dialog = new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.dialog_custom);   // layout dialog_custom.xml
                dialog.getWindow().setLayout(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT
                );

                Button btnOK = dialog.findViewById(R.id.btnOk);
                Button btnCancel = dialog.findViewById(R.id.btnCancel);

                // OK -> sang RegisterActivity để đăng ký (for result)
                btnOK.setOnClickListener(view -> {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivityForResult(intent, 100);
                    dialog.dismiss();
                });

                // Cancel -> chỉ đóng dialog
                btnCancel.setOnClickListener(view -> dialog.dismiss());

                dialog.show();

            } else if (edtPassword.getText().toString().length() < 6) {
                // Nếu password < 6 ký tự
                edtPassword.setError("Minimum 6 number!");
            } else {
                // Đủ điều kiện -> sang InforActivity (Hình 4)
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("Username", edtUsername.getText().toString());
                // Nếu muốn truyền luôn password:
                intent.putExtra("password", edtPassword.getText().toString());
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(intent, 100);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }

        if(requestCode == 102 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
    }
}