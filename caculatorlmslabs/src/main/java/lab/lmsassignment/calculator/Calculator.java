package lab.lmsassignment.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {
	
	//define a GET endpoint that takes two integers as parameters and returns their sum

	@GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return  "<center><h2> sum of a&b is " + (a+b) +  "!!!!</h2></center";
    }

	////define a GET endpoint that takes two integers as parameters and returns their substraction result

    @GetMapping("/subtract")
    public String subtraction(@RequestParam int a, @RequestParam int b) {
        return "<center><h2> substraction of a-b is " + (a-b) +  "!!!!</h2></center";
    }
  //define a GET endpoint that takes two integers as parameters and returns their multiplication

    @GetMapping("/multi")
    public String multiplication(@RequestParam int a, @RequestParam int b) {
        return "<center><h2> multiplication of a&b is " + (a*b) +  "!!!!</h2></center";
    }
    
  //define a GET endpoint that takes two integers as parameters and returns their Quotient
    // throws an exception if the second integer is 0 (to avoid dividing by zero)
    @GetMapping("/div")
    public String divide(@RequestParam int a, @RequestParam int b) throws Exception {
        if (a == 0) {
            throw new Exception("Cannot divide by zero");
        }
        return "<center><h2> Quotient is " + (a/b) +  "!!!!</h2></center"; 
        
    }
    
}
