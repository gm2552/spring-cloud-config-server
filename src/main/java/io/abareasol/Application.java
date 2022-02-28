package io.abareasol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@EnableConfigServer
public class Application implements CommandLineRunner
{
	@Autowired
	protected Environment env;

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
    }

	public void run(String... args)
	throws Exception
	{
		System.out.println("ConfigMap test data setting: " + env.getProperty("spring.testdata.data"));
		System.out.println("Namespace: " + env.getProperty("spring.cloud.kubernetes.config.namespace"));
	}
}
