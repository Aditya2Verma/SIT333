package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Main class for starting the Spring Boot application
@SpringBootApplication(scanBasePackages = "web")
public class MyServer extends SpringBootServletInitializer {

    // Override to configure the app when running in a servlet container
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyServer.class);
    }

    // Application entry point
    public static void main(String[] args) {
        SpringApplication.run(MyServer.class, args);
    }
}
