package com.jiuling.core.feature.test;


public class TestCache {
	
	
 public static void main(String[] args) {
	 /* ApplicationContext context=new ClassPathXmlApplicationContext("spring-mvc.xml");
	  DataSource dataSource =(DataSource) context.getBean("dataSource");
	 
	  System.out.println(dataSource.getClass());*/
	 //缓存测试
	 //1 list
	/* List<Student> students = new ArrayList<Student>();
	 for (int i = 0;i<10;i++)
	 {
		 Student student = new Student();
		 student.setId(new Long(i));
		 student.setUsername("yangxianqing"+i);
		 student.setAddress("长沙"+i);
		 student.setAge(20+i);
		 students.add(student);
	 }
	 
	 //添加
	 EhcacheUtils.putItem("students", students);
	 //获取
	 List<Student> cacheStudent = (List<Student>)EhcacheUtils.getItem("students");
	 System.out.println("get cache="+cacheStudent.toString());
	 
	 List<Student> newstudent = new ArrayList<Student>();
	 for (int i=0;i<cacheStudent.size();i++)
	 {
		 if (i%2 == 0)
		 {
			 newstudent.add(cacheStudent.get(i));
		 }
	 }
	 //更新
	 EhcacheUtils.updateItem("students", newstudent);
	 
	 List<Student> cacheStudent2 = (List<Student>)EhcacheUtils.getItem("students");
	 System.out.println("get newcache="+cacheStudent2.toString());
	
	 //移除
	 EhcacheUtils.removeItem("students");
	List<Student> cacheStudent3 = (List<Student>)EhcacheUtils.getItem("students");
	 
	 System.out.println("get deletecache="+cacheStudent3);*/

	  
}
}
