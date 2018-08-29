package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
// Classical controller, not REST controller
public class HelloController {

	/**
	 * Spring MVC feature
	 * 	 - string returned from method is interpreted as HTML page body
	 *
	 * 	 - to get this result, type: http://localhost:8080/hello
	 */
	@RequestMapping("/hello")
	public @ResponseBody String mvcHello() {
		return "Hello from the MVC side!";
	}

	/**
	 * Spring MVC feature with Path variable
	 * 	 - string returned from method is interpreted as logical view name
	 *
	 * 	 - to get this result, type: http://localhost:8080/hello/<any_name_you_want>
	 */
	@RequestMapping("/hello/{param_name}")
	public String mvcHelloWithPath(Map model, @PathVariable String param_name) {
		model.put("name", param_name);
		return "hello";
	}

	/**
	 *    - string returned from method is interpreted as logical view name
	 *    (name of the view used to render the response)
	 *    - in this case it's view named hello, and since in resources/templates hello.html exists,
	 *    it will be used to render the response
	 *
	 * 	 - to get this result, type: http://localhost:8080/hello
	 */
	@GetMapping("/")
	public String initial() {
		return "hello";
	}
}
