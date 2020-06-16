package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Calendar CurrentMoment = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");		
		
		System.out.println("Hello, welcome to the best management system!!!");
		System.out.println("ENTER CLIENT DATA:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYY): ");
		Date clientBirthDate = sdf.parse(sc.nextLine());		
		System.out.println("ENTER ORDER DATA:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine().toUpperCase();
		Order order = new Order(CurrentMoment.getTime(), OrderStatus.valueOf(orderStatus), new Client(clientName, clientEmail, clientBirthDate));
		
		System.out.print("How many items to this order? ");
		Integer ordersQuantity = sc.nextInt();
		for(int i=1; i<=ordersQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.println();
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();			
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();	
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			OrderItem items = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(items);			
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
