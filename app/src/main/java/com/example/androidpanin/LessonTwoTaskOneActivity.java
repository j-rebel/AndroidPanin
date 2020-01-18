package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LessonTwoTaskOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_two_task_one);

        final TextView formMsg = findViewById(R.id.formMsg);
        final TextView formErr = findViewById(R.id.formErr);

        final EditText nameInput = findViewById(R.id.nameInput);
        nameInput.setText("");
        final EditText emailInput = findViewById(R.id.emailInput);
        emailInput.setText("");


        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = nameInput.getText().toString();
                final String email = emailInput.getText().toString();

                final String formMsgText = "Подписка на рассылку успешно оформлена для пользователя " + name + " на электронный адрес " + email;
                final String errText = "Не заполнено одно из полей!";

                if ("".equals(name) || "".equals(email)) {
                    formErr.setText(errText);
                } else {
                    formErr.setText("");
                    formMsg.setText(formMsgText);
                }
            }
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formErr.setText("");
                formMsg.setText("");
                nameInput.setText("");
                emailInput.setText("");
            }
        });

    }


}
