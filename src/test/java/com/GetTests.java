package com;

import com.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTests {

    @Test
    public void getCalltoServer(){
        Response response = RequestBuilder.buildRequestForGetCalls()
                        .get("/employees"); //we can write it in config file
        //response.prettyPrint();

        System.out.println(response.getStatusCode());

        int initialize = response.jsonPath().getList("$").size();
        System.out.println(" Initial size of Employee : "+ initialize);

    }


}
