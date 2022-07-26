package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		//스프링 컨테이너를 만든다. bean을 담는다.
		//실행시 person.xml을 읽어 들려 빈을 생성
		PersonService person = (PersonService) factory.getBean("personService");
		// id가 personService인 빈을 가져옴
		// 이것도 객체 생성 아닌가?
		
		//PersonService person = new PersonServiceImpl(); 
		//더이상 자바코드에서 new를 사용안해도 되므로 주석처리 함.
		person.sayHello();
	}

}
