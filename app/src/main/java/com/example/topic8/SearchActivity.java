package com.example.topic8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topic8.api.EmployeeApi;
import com.example.topic8.model.Employee;
import com.example.topic8.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private EditText etEmpNo;
    private TextView tvData;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etEmpNo = findViewById(R.id.etNo);
        tvData = findViewById(R.id.tvData);
        btnSearch = findViewById(R.id.btnS);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });


    }

    private void loadData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeApi employeeApi = retrofit.create(EmployeeApi.class);

        Call<Employee> listCall = employeeApi.getEmployeeID(Integer.parseInt(etEmpNo.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(SearchActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                String data = "";
                data += " Id : " + response.body().getId() + "\n";
                data += " Name : " + response.body().getEmployee_name() + "\n";
                data += " Age : " + response.body().getEmployee_age() + "\n";
                data += " Salary : " + response.body().getEmployee_salary() + "\n";

                tvData.setText(data);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
