/**
 * 
 */
package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mathiarasi
 *
 */
@RestController
@RequestMapping(path="api")
public class HelloController {
 
	@GetMapping
     public void sayHello() {
		System.out.println("Hello");

	}

	@GetMapping("hello")
     public String sayHelloAll() {
		System.out.println("Hello all");
	      return "welcome";
		

	}
	@GetMapping("response")
    public ResponseEntity<String> sayHelloResponse() {
		System.out.println("Hello all");
	      return ResponseEntity.ok("hello this is from response method");
		

	}
	
	@GetMapping("model")
	public ModelAndView model(ModelAndView md)
	{
		md.addObject("name","Mathiarasi");
		md.setViewName("welcome");
	
		return md;
	}
	@GetMapping("modelrequest")
	public ModelAndView sayhello6(ModelAndView md,HttpServletRequest request)
	{
		md.addObject("name","Mathi");
		request.setAttribute("degree","BE");
		HttpSession session=request.getSession();
		session.setAttribute("sessionname", "session");
		md.setViewName("welcome");
		return md;
	}
	@GetMapping("varpath/{name}")
	public ModelAndView pathVariable(@PathVariable String name,ModelAndView md,HttpServletRequest request)
	{
		md.addObject("name",name);
		request.setAttribute("degree","BE");
		
		md.setViewName("welcome");
		return md;
		
	}
	@GetMapping("param")
	public ModelAndView requestParam(@RequestParam("uname") String name,ModelAndView md,HttpServletRequest request)
	{
		md.addObject("name",name);
		request.setAttribute("degree","BE");
		
		md.setViewName("welcome");
		return md;
		
	}

	@GetMapping("object")
	public ResponseEntity<User> sendObject() 
	{

		User user = new User();
		user.setUid(5);
		user.setUname("Mathi");
		return ResponseEntity.ok(user);

	}
	@PostMapping("user")
	public ResponseEntity<User> sendUser(@RequestBody User user)
	{
		user.setUid(5);
		user.setUname("Anu");
		return ResponseEntity.ok(user);
		
	}

	@PostMapping("UserName")
	public User sendUserName(@RequestBody User user)
	{
		user.setUid(5);
		user.setUname("Mathiarasi");
		return user;
		
	}
	
	
	@GetMapping("getobject")
	public ModelAndView returnObjectInJSP(ModelAndView md)
	{
		User user=new User();
		user.setUid(5);
		user.setUname("Mathiarasi");
		md.addObject("user", user);
		md.setViewName("welcome");
		
		return md;
	}

	
	
}
class User{
	private int uid;
	private String uname;
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
}

