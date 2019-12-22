package com.example.topic8.api;

import com.example.topic8.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeApi {

    @GET("employees")
    Call<List<Employee>> getEmployee();
}
