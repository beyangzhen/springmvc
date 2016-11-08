package com.beyang.cn.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.beyang.cn.entity.User;

@Controller
@RequestMapping("/demo") // 可有可无（写的时候，相当于struts的 @namespace）
@SessionAttributes(value={"user"}) // 会自动将指定的request域的属性（即：mv.addObject()）添加到session域中
public class HelloWorldHandler {
	private final String SUCCESS = "success";
	
	@RequestMapping("/helloWorld")
	public ModelAndView sayHello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(SUCCESS);
		// 相当于 request.setAttribute()
		mv.addObject("time", new Date()); // 页面通过el表达式获取①
		
		return mv;
	}
	
	@RequestMapping("/helloWorld")
	public String sayHello(Model model) {
		// 相当于 request.setAttribute()
		model.addAttribute("time", new Date()); // 页面通过el表达式获取②
		
		return SUCCESS;
	}
	
	// 直接指定转发的路径
	@RequestMapping("/testForword")
	public String testForword() {
		return "forward:WEB-INF/jsp/success.jsp"; 
	}
	
	// 直接指定重定向的路径
	@RequestMapping("/testRedirect")
	public String testRedirect(Map<String,Object> model) {
		model.put("userName", "bruce");
		return "redirect:index.jsp"; 
		// return "redirect:/testForword";
	}
	
	/**
	 *  REST 风格的使用
	 *     PUT   ： 修改
	 *     DELETE： 删除
	 *     POST  : 新增
	 *     GET   ： 获取
	 */
	@RequestMapping(value="testREST", method=RequestMethod.DELETE)
	public String testREST_DELETE() {
		System.out.println("DELETE....");
		return SUCCESS;
	}
	@RequestMapping(value="testREST", method=RequestMethod.PUT)
	public String testREST_PUT() {
		System.out.println("PUT....");
		return SUCCESS;
	}
	@RequestMapping(value="testREST", method=RequestMethod.GET)
	public String testREST_GET() {
		System.out.println("get....");
		return SUCCESS;
	}
	@RequestMapping(value="testREST", method=RequestMethod.POST)
	public String testREST_POST() {
		System.out.println("post....");
		return SUCCESS;
	}
	
	/**
	 *  Ant 风格资源地址支持 3 种匹配符：
	 *		? ：匹配文件名中的任意一个字符
	 *		* ：匹配文件名中的任意多个字符
	 *		**：匹配多层路径
	 */
	@RequestMapping("/testAnt/*/123")
	public String testAnt() {
		return SUCCESS;
	}
	
	// 访问请求必须是post
	@RequestMapping(value="testMethod", method=RequestMethod.POST)
	public String testMethod() {
		return SUCCESS;
	}
	
	// 访问必须带满足条件的参数
	@RequestMapping(value="/testParam", params={"userName","age!=10"}, headers={"Accept-Language=zh-CN,zh;q=0.8,en;q=0.6"})
	public String testRequestMappingParam() {
		return SUCCESS;   
	}
	
	// 可以来映射 URL 中的占位符到目标方法的参数中
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable(value="id") Integer id) {
		System.out.println("id" + id);
		return SUCCESS;
	}
	
	// 获取cookie里的参数值（了解）
	@RequestMapping("/testCookie")
	public String testCookie(@CookieValue("JSESSIONID") String JSESSIONID) {
		// JSESSIONID
		System.out.println("JSESSIONID:" + JSESSIONID);
		return SUCCESS;
	}
	
	// 获取请求头的信息
	@RequestMapping("/testHeader")
	public String getHeaders(@RequestHeader("Accept-Encoding") String ae) {
		// Accept-Encoding: gzip, deflate, sdch
		System.out.println("Accept-Encoding:" + ae);
		return SUCCESS;
	}
	
	
	/**
	 *  传请求参数使用 @RequestParam("")
	 *     若传递参数时不给age赋值，且age为int型，则springmvc自动给age赋为null。与int不符报错(解决方式)：
	 *   	   1. pojo中写成对应包装类的类型
	 *         2. 使用defaultValue来赋默认值
	 *    
	 */
	@RequestMapping(value="/testParameters")
	public String getParameters(
				// 请求参数和类属性一致时，@RequestParam()也可以不写
			
		           	// required=false代表，页面request请求中的参数可以没有该参数
				@RequestParam(value="userName", required=false) String userName, // required: 默认是 true
				// @RequestParam(value="age") pojo中写成 Integer age
				@RequestParam(value="age", defaultValue="0") int age
			) {
		System.out.println("userName:" + userName + ";age:" + age);
		return SUCCESS;
	}
	
	// 使用Servlet原生的方法，API
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException{
		System.out.println(request + ":" + response);
		out.write(" hello springmvc！！"); 
	}
	
	/**
	 *  构建Map模型的同时，会自动将该map添加到request域中 
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map) {
		// 会将map类型转为  BindingAwareModelMap 
		System.out.println(map.getClass().getName());
		map.put("user", new User("bruce", "123", "123@yeah.net", 23));
		return SUCCESS;
	}
	
	/**
	 * 	类上设置了@SessionAttributes(value={"user"})，
	 *  会自动将该request域的指定属性，添加到session域中
	 */
	@RequestMapping("/testSessionAttribute")
	public  String testSessionAttributes(Map<String,Object> map) {
		// 构建Map模型的同时，会自动将该map添加到request域中 
		map.put("user", new User("bruce", "123", "123@yeah.net", 23));
		return SUCCESS;
	}
	
	/**
	 *  springmvc将 POJO对象和请求参数值绑定（前提：参数名和类属性名必须一致，可以不加@RequestParam()）
	 *      支持绑定级联属性。如：User类中有Address类的对象，页面上参数写address.city、address.provice 等
	 *  --> 形参可以直接获取request域中的对象
	 * 
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(User user) {
		System.out.println(user);
		return SUCCESS;
	}
	
	// @ModelAttribute 可以指定pojo（非简单类型）回显到页面在request中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(
			Model model,
			@ModelAttribute("user") User user
			) {
		// 可以直接使用model将提交pojo回显到页面
		model.addAttribute("user", user);
		return SUCCESS;
	}
		
	// @ModelAttribute("user") 表示将函数返回值放在request中的key
	@ModelAttribute("user")
	public Map<String, String> getItemTypes() {
		Map<String, String> users = new HashMap<String, String>();
		users.put("101", "数码");
		users.put("102", "母婴");
		
		return users;
	}

	/**
	 * 更新运行流程：
	 * 	   1. 执行@ModelAttribute注解修饰的方法：从数据库中获取对象，把对象放到Map中，键为： user
	 * 	   2. springmvc从map中取出user对象，并把表单的请求参数赋值给该user对象的对应属性
	 *     3. springmvc会把上述对象传入目标方法的参数中
	 *     注意：在@ModelAttribute修饰的方法中，放入到Map的键必须与目标方法的参数名保持一致
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if(id != null ) {
			// 模拟从数据库中获取一个对象
			User user = new User("bruce", "88888888", "123@yeah.net", 23);
			// 设置到map中
			map.put("user", user);
		}
	}
	@RequestMapping("/testUpdate")
	public String testUpdate(User user) {
		// 从map中取出user对象，并把表单请求的参数赋给该user对象的对应属性
		// 再将修改后的request域的user传入该方法的形参中
		System.out.println("user:" + user);
		return SUCCESS;
	}

}
