package com.example.rdit_id_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // hooks
    EditText etName, etEmail, etPassword;
    Button btnSubmit, btnClear;
    RadioButton rbMale, rbFemale;
    ImageView ivGender;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                etName.setBackgroundColor(Color.WHITE);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etEmail.setText("");
                etPassword.setText("");
                ivGender.setVisibility(View.GONE);
                tvResult.setVisibility(View.GONE);
                rbMale.setChecked(false);
                rbFemale.setChecked(false);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();
                boolean genderMale = rbMale.isChecked();
                boolean genderFemale = rbFemale.isChecked();
                if(name.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Name can't be empty", Toast.LENGTH_SHORT).show();
                    etName.setBackgroundColor(Color.RED);
                }
                else if(email.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Email can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                } else if (!genderMale && !genderFemale) {
                    Toast.makeText(MainActivity.this, "Select the gender", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    String text;
                    text = "NAME : "+name+
                            "\n"
                            +"EMAIL : "+email+
                            "\n"
                            +"PASSWORD : "+password;
                    tvResult.setText(text);

                    ivGender.setVisibility(View.VISIBLE);
                    tvResult.setVisibility(View.VISIBLE);
                    if(genderFemale)
                    {
                        ivGender.setImageDrawable(getDrawable(R.drawable.female));
                    }
                    else
                    {
                        ivGender.setImageDrawable(getDrawable(R.drawable.male));
                    }

                }
            }
        });



    }

    void init()
    {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        tvResult = findViewById(R.id.tvResult);
        ivGender = findViewById(R.id.ivGender);

        tvResult.setVisibility(View.GONE);
        ivGender.setVisibility(View.GONE);

    }
}