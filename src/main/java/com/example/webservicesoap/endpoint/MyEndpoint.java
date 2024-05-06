package com.example.webservicesoap.endpoint;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.webservicesoap.model.Category;
import com.example.webservicesoap.repository.CategoryRepository;


import com.example.demo.GetAllCategoriesRequest;
import com.example.demo.GetAllCategoriesResponse;
import com.example.demo.MyRequest;
import com.example.demo.MyResponse;


//digenerate jaxb

@Endpoint
public class MyEndpoint {
    
    @Autowired
    private CategoryRepository CategoryRepository;

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "MyRequest")
    @ResponsePayload
    public MyResponse myMethod(@RequestPayload MyRequest request) {
        MyResponse response = new MyResponse();
        response.setResponseMessage("This is a response to: " + request.getRequestMessage());
        return response;
    } 

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "GetAllCategoriesRequest")
    @ResponsePayload
    public GetAllCategoriesResponse getAllCategories(@RequestPayload GetAllCategoriesRequest request) {
        GetAllCategoriesResponse response = new GetAllCategoriesResponse();
        List<Category> categories = CategoryRepository.findAll();
        List<com.example.demo.Category> responseCategories = new ArrayList<>();
        for (Category category : categories) {
            com.example.demo.Category responseCategory = new com.example.demo.Category();
            responseCategory.setId(category.getId());
            responseCategory.setCategory(category.getCategory());
            responseCategory.setAbout(category.getAbout());
            responseCategories.add(responseCategory);
           // System.out.println("Category: " + Category.getName());
            
        }
        response.getCategory().addAll(responseCategories);
        





        return response;
    }
      
}





