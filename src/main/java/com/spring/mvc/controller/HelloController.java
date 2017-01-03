package com.spring.mvc.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.Calculation;

 
@RestController
public class HelloController {
 
    @RequestMapping(value = "/anil", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }
 
    @RequestMapping(value = "/tako", method = RequestMethod.GET)
    public String sayHelloAgain() {
        return "Authenticated";
    }
    
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public static int add() {
////    	CalculationImpl cal = new CalculationImpl();
////    	return cal.add(3, 3);
//    	
//    }
    
}