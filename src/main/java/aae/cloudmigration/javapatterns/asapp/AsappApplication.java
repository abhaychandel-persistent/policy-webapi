package aae.cloudmigration.javapatterns.asapp;

import com.microsoft.applicationinsights.attach.ApplicationInsights;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsappApplication {

	public static void main(String[] args) {
		ApplicationInsights.attach();
		SpringApplication.run(AsappApplication.class, args);
	}

}
