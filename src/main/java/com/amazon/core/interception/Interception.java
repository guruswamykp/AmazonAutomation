package com.amazon.core.interception;

import com.amazon.core.BaseTest;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.fetch.Fetch;
import org.openqa.selenium.devtools.v138.fetch.model.RequestPattern;

import java.util.List;
import java.util.Optional;

public class Interception extends BaseTest {
    DevTools devTools;

    public void interceptNetwork(){

        devTools = createDevToolSession();


        //List<RequestPattern> reqPattern = createRequestPattern();
        //devTools.send(Fetch.enable(Optional.of(reqPattern),Optional.of(false)));

    }

    /*private List<RequestPattern> createRequestPattern() {
        
    }*/


}
