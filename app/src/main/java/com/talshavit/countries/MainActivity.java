package com.talshavit.countries;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.talshavit.mylibrary.CapitalResponse;
import com.talshavit.mylibrary.CapitalsRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText country_editTxt;
    private Button confirm_button;

    private TextView descripsionTxt, capital_Txt;
    private CapitalsRepository capitalsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        capitalsRepository = new CapitalsRepository();
        initViews();
    }

    private void initViews() {
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = country_editTxt.getText().toString();
                capitalsRepository.getCapital(country, new Callback<CapitalResponse>() {
                    @Override
                    public void onResponse(Call<CapitalResponse> call, Response<CapitalResponse> response) {
                        if (response.isSuccessful()) {
                            CapitalResponse capitalResponse = response.body();
                            if (capitalResponse != null) {
                                String capital = capitalResponse.getCapital();
                                descripsionTxt.setVisibility(View.VISIBLE);
                                capital_Txt.setText(country + " Is " + capital);
                                capital_Txt.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<CapitalResponse> call, Throwable t) {
                    }
                });
            }
        });

        country_editTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                descripsionTxt.setVisibility(View.INVISIBLE);
                capital_Txt.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void findViews() {
        country_editTxt = findViewById(R.id.country_editTxt);
        confirm_button = findViewById(R.id.confirm_button);
        descripsionTxt = findViewById(R.id.descripsionTxt);
        capital_Txt = findViewById(R.id.capital_Txt);
    }
}
