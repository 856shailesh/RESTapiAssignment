package com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentSteps {

    @Test
    public void getCalls(){
        GetTests get = new GetTests();
        int initial_size = get.getCalltoServer();  // Steps 1,2,3

        PostTest post = new PostTest();
        post.postCallTest(); //Steps 4,5

        int intialPlusOne = get.getCalltoServer();
        Assert.assertTrue(intialPlusOne>initial_size, "Updated is greater than previous");

        
    }
}
