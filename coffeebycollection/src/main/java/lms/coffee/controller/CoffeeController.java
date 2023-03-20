package lms.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.coffee.entity.Coffee;
@RestController
public class CoffeeController {
	private List<Coffee> coffee = new ArrayList<>();
	
public CoffeeController() {
	coffee.addAll(List.of(
			
			new Coffee("Bourburn",200.30),
			new Coffee("Nescafe",100.00),
			new Coffee("Nestle",20.00),
			new Coffee("Sun",50.00),
			new Coffee("Bru",80.00)
			
			));
}
@GetMapping("/cofee")
	Iterable<Coffee> getAllCoffee(){
		return coffee;
	
    }
}

