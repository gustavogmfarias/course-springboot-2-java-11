package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController // informa ao sping que é uma classe de controller
@RequestMapping(value = "/orders") // informa qual url vai ser acessado
public class OrderResource {

	@Autowired
	private OrderService service; // precisa ser referenciado por um Service que vai fazer "o trabalho sujo" da
									// JPA.

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {

		List<Order> list = service.findAll(); // vamos listar os pedidos, retornando uma list, pelo service.
		return ResponseEntity.ok().body(list); // informa que está ok e manda na resposta que coloque no body do html o
												// list;

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
