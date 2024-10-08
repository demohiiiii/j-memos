package top.demohiiiii.memos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("top.demohiiiii.memos")
public class MemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemosApplication.class, args);
	}

}
