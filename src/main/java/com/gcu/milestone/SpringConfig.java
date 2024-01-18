package com.gcu.milestone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.gcu.business.LoginBusinessService;
import com.gcu.business.ProductBusinessService;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.LoginRepository;
import com.gcu.interfaces.LoginBusinessServiceInterface;
import com.gcu.interfaces.ProductBusinessServiceInterface;
import com.gcu.models.LoginModel;

@Configuration
public class SpringConfig {
    @Bean(name="productBusinessService")
    public ProductBusinessServiceInterface getProductBusiness()
    {
        return new ProductBusinessService();
    }

    @Bean(name = "lbsi")
    public LoginBusinessServiceInterface getLoginBusiness()
    {
        return new LoginBusinessService();
    }

    @Autowired
    private DataSource dataSource;

    @Bean(name="loginDAO")
    @RequestScope
    public DataAccessInterface<LoginModel> getLogins()
    {
        return new LoginRepository(dataSource);
    }
}
