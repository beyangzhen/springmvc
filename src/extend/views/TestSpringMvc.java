package extend.views;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beyang.cn.entity.User;

@Controller
@RequestMapping("/demo")
public class TestSpringMvc {
	@RequestMapping("/testView")
	public String testView() {
		return "helloView";
	}
	@RequestMapping("/hello")
	public String testHello() {
		return "success";
	}
	@RequestMapping("/testExecl") 
	public String testExecl(Map<String,Object> model) {
		List<User> userList = new ArrayList<>();
		// String userName, Integer userAge, String userNo, String address
		userList.add(new User("bruce", "123", "123@yeah.net", 23));
		userList.add(new User("yoyo", "123", "123@yeah.net", 23));
		userList.add(new User("xiaofen", "123", "123@yeah.net", 23));
		userList.add(new User("tom", "123", "123@yeah.net", 23));
		model.put("userList", userList);
		return "myExcelView";
	}
	
	
}
