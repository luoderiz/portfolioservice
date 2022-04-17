package com.myservice.portfolioservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortfolioServiceApplicationTests {
    @BeforeAll
    static void setUp() {
        System.setProperty("DB_URL", "jdbc:mysql://localhost:3306/portfolio");
        System.setProperty("DB_USERNAME", "root");
    }

    @Test
    void contextLoads() {
    }

}
