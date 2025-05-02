package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.dto.request.AddOrderDTO;
import com.training.model.Bill;
import com.training.model.Customer;
import com.training.model.Item;
import com.training.model.Order;
import com.training.model.OrderItem;
import com.training.model.Stock;
import com.training.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	RestTemplate template;

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody AddOrderDTO orderDTO) {

		// create order
		Order savedOrder = orderService.createOrder(orderDTO.getOrder());

		// create bill
		String url1 = "http://localhost:9113/api/add";
		ResponseEntity<Bill> result = template.postForEntity(url1, orderDTO.getBill(), Bill.class);

		// To reduce stock
		List<OrderItem> itemList =orderDTO.getOrderItems(); // Get the list of items

		// Loop through each item in the list
		for (OrderItem item : itemList) {
			Long itemId = item.getStock().getItem().getId();
			Long locationId = item.getStock().getLocation().getId();
			Long cityId = item.getStock().getCity().getId();
			int quantity = item.getQuantity();

			// Construct the URL with query parameters
			String url2 = "http://localhost:9082/api/stocks/reduce?itemId=" + itemId + "&locationId=" + locationId
					+ "&cityId=" + cityId + "&quantity=" + quantity;

			// Send the PUT request for each item
			ResponseEntity<String> result1 = template.exchange(url2, HttpMethod.PUT, null, String.class);

		}

		// update customer reward points
		String url3 = "http://localhost:9114/api/addOrUpdate";
		ResponseEntity<Customer> result2 = template.postForEntity(url3, orderDTO.getOrder().getCustomer(), Customer.class);
		
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

	}

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id).map(order -> new ResponseEntity<>(order, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}