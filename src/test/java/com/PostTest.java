package com;

import com.constants.FCwithSingleton;
import com.constants.FrameworkConstants;
import com.pojo.Employee;
import com.requestbuilder.RequestBuilder;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.utils.RandomUtils.*;

public class PostTest {

    @Test
    public static void postCallTest(){
        Employee employee = Employee
                .builder()
                .setFname(getFirstName())
                .setLname(getLastName())
                .setId(getId())
                .build();

        Response response = RequestBuilder.buildRequestForPostCalls()
                .body(employee)
                .post("/employees");

        response.prettyPrint();
        //Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Test
    public static void postRequestUsingExternalFile(Method method){
       String resource =  ApiUtils
               .readJsonAndGetString(FrameworkConstants.getRequestJsonFolderPath()+method.getName())
               .replace("fname", RandomUtils.getFirstName())
               .replace("id",String.valueOf(RandomUtils.getId()));


        Response response = RequestBuilder
                .buildRequestForPostCalls()
                .body(resource)
                .post("/employees");

        response.prettyPrint();

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath()+ method.getName() + "/response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Test
    public static void postRequestUsingExternalFileUsingSingleton(Method method){
        String resource =  ApiUtils
                .readJsonAndGetString(FCwithSingleton.getInstance().getRequestJsonFolderPath()+"request.json")
                .replace("fname", RandomUtils.getFirstName())
                .replace("id",String.valueOf(RandomUtils.getId()));


        Response response = RequestBuilder
                .buildRequestForPostCalls()
                .body(resource)
                .post("/employees");

        response.prettyPrint();

        ApiUtils.storeStringAsJsonFile(FCwithSingleton.getInstance().getResponseJsonFolderPath()+ method.getName() + "/response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);


    }

    
}
