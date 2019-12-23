package com.example.topic8.api;

import com.example.topic8.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeApi {

    @GET("employees")
    Call<List<Employee>> getEmployee();

    @GET("employee/{empID}")
    Call<Employee> getEmployeeID(@Path("empID") int empId);

}
