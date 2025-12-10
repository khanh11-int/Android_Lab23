package com.example.lab23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtUsername, edtPassword, edtConfirm;
    Button btnSignIn, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPass);
        edtConfirm = findViewById(R.id.edtConfirm);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnCancel = findViewById(R.id.btnCancel);

        // Cancel -> quay lại Login
        btnCancel.setOnClickListener(v -> finish());

        // SIGN IN -> kiểm tra dữ liệu
        btnSignIn.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirm = edtConfirm.getText().toString().trim();
            // 1. Kiểm tra email
            if (!isValid(email)) {
                edtEmail.setError("Invalid Email Address");
                return;
            }
            // 2. Kiểm tra username rỗng
            if (username.isEmpty()) {
                edtUsername.setError("Username cannot be null");
                return;
            }
            // 3. Kiểm tra password rỗng
            if (password.isEmpty()) {
                edtPassword.setError("Password required");
                return;
            }

            // 4. Kiểm tra confirm rỗng
            if (confirm.isEmpty() && confirm.length() < 6) {
                edtConfirm.setError("Password required");
                return;
            }

            // 5. Kiểm tra password trùng confirm
            if (!password.equals(confirm)) {
                edtPassword.setError("Password and confirm password does not match");
                edtConfirm.setText("");
                return;
            }

            // Nếu hợp lệ -> gửi về LoginActivity (cho đồng bộ với tài liệu)
            Intent i = new Intent();
            i.putExtra("username", username);
            i.putExtra("password", password);
            setResult(101, i);

            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Hàm kiểm tra email hợp lệ
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }
}
