package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner le = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date currentTime = new Date();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = le.nextLine();
		System.out.print("Email: ");
		String clientEmail = le.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf1.parse(le.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("\nEnter order data:");
		System.out.print("STATUS: ");
		String status = le.next().toUpperCase();
		
		Order order = new Order(currentTime, OrderStatus.valueOf(status), client);
		
		System.out.print("How many items do this order: ");
		int n = le.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			le.nextLine();
			String productName = le.nextLine();
			System.out.print("Product price: ");
			Double productPrice = le.nextDouble();
			System.out.print("Quantity: ");
			int quantity = le.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem it = new OrderItem(quantity, productPrice, product);
			order.addItem(it);
		}
		
		System.out.println(order.toString());
		
		le.close();
	}

}