package com.development.spring.invest_ai.InvestAI;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableEncryptableProperties
@EnableTransactionManagement
public class InvestAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestAiApplication.class, args);
	}

}
