package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	//login 기능
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userID = "";
//		String passwd = "";
//		
//		ModelAndView mav = new ModelAndView();
//		
//		request.setCharacterEncoding("utf-8");
//		userID = request.getParameter("userID");
//		passwd = request.getParameter("passwd");
//		
//
//		mav.addObject("userID", userID);
//		mav.addObject("passwd", passwd);
//		mav.setViewName("result");
//		return mav;
//	}
	
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView(); //내장 클래스
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName=getViewName(request); //getViewName()메소드를 호출해 요청명에서 확장명 .do를 제외한 뷰이름을 가져옴
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result"); //큰따음표 사용 , 미사용 구분할수 있어야함.
		mav.setViewName(viewName);	//().jsp로 포워
	    System.out.println("ViewName:"+viewName);
		return mav;
	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}
	
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("loginForm");
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("loginForm");
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      System.out.println("contextPath:"+contextPath); //pro21
	      
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      System.out.println("uri1:"+uri);	
	      
	      if(uri == null || uri.trim().equals("")) {
	         uri = request.getRequestURI();
	         System.out.println("uri2:"+uri);		///pro21/test/loginForm.do
	      }

	      int begin = 0;
	      if(!((contextPath==null)||("".equals(contextPath)))){
	         begin = contextPath.length();
	         System.out.println("begin:"+begin);
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");
	         System.out.println("end1:"+end);
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");
	         System.out.println("end2:"+end);
	      }else{
	         end=uri.length();
	         System.out.println("end3:"+end);
	      }

	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));
	         System.out.println("fileName1:"+fileName);
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
	         System.out.println("fileName2:"+fileName);
	      }
	      return fileName;
	   }
	
}
