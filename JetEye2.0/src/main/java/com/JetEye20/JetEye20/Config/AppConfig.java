package com.JetEye20.JetEye20.Config;



import com.JetEye20.JetEye20.API.ApiController;
import com.JetEye20.JetEye20.API.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("JetEye20.Repos")
public class AppConfig {

    private final AuthController holderController;

    private final ApiController apiController;


    @Autowired
    public AppConfig(AuthController mailHolderController, ApiController apiController) {
        this.holderController = mailHolderController;
        this.apiController = apiController;
    }


}
