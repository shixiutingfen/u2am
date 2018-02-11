package com.jiuling.core.feature.test;

import com.jiuling.core.util.RandomUtils;

public class Test {
 public static void main(String[] args) {
//	  ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc.xml");
//	  DataSource dataSource =(DataSource) context.getBean("dataSource");
//	 
//	  System.out.println(dataSource.getClass());
     
     //HttpGetUtils.postHttp("webservice", paramMap);
     
     //String a = "orgvideos\\1478160783008.avi".replaceAll("\\\\", "/");
     //System.out.print(a);
     System.out.print(RandomUtils.getRandom32PK());
}
}
