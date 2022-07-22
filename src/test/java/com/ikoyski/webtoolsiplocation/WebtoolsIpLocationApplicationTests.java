package com.ikoyski.webtoolsiplocation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebtoolsIpLocationApplicationTests {

	@Test
	@DisplayName("WebtoolsIpLocationApplicationTests.contextLoads()")
	void contextLoads() {
	}

	@Test
	@DisplayName("WebtoolsIpLocationApplicationTests.mainSuccess()")
	void mainSuccess() {
		// when
		WebtoolsIpLocationApplication.main(new String[] {});
	}
}
