package com.itheima.tliaswebmanagement;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

//@SpringBootTest
class TliasWebManagementApplicationTests {
	/**
	 * 生成JWT
	 */
	@Test
	public void testGenJwt(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1);
		claims.put("name", "tom");

		String jwt = Jwts.builder()
				.signWith(HS256, "itheima") //指定数字签名的算法 HS256，指定数字签名的秘钥 itheima
				.setClaims(claims)  //设置自定义的内容(载荷) → Java程序可以把自定义的数据封装到Map集合当中
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置令牌的有效期为1h
				.compact();//调用compact方法，可以拿到一个字符串类型的返回值 → 就是生成的JWT令牌

		System.out.println(jwt);
	}
}
