package com.itheima;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TliasWebManagementApplication {

	public static void main(String[] args) {
		log.info("查询全部的部门数据");
		SpringApplication.run(TliasWebManagementApplication.class, args);
	}

}
