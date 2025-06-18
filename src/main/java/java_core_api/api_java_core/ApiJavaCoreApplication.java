package java_core_api.api_java_core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients(basePackages = "java_core_api.api_java_core.cliente")
public class ApiJavaCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJavaCoreApplication.class, args);
	}

}
