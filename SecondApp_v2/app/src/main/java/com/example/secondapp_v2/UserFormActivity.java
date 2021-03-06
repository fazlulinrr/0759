package com.example.secondapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserFormActivity extends AppCompatActivity {
    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        // Находим кнопку на форме
        insertUserBtn = findViewById(R.id.insertUserBtn);
        // Навешиваем на кнопку обработчик клика
        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем пользователя у которого рандомно сгенирировался uuid
                User user = new User();
                // Добавляем остальные свойства,читаем из текстовых полей на форме в которые мы печатаем данные
                user.setUserName(editTextName.getText().toString());
                user.setUserLastName(editTextLastName.getText().toString());
                user.setPhone(editTextPhone.getText().toString());
                // Добавляем пользователя
                Users users = new Users(UserFormActivity.this);
                users.addUser(user);
                // Возвращаемся к списку пользователей.Возвращаемся на предыдущую активность
                onBackPressed();
            }
        });
    }
}

