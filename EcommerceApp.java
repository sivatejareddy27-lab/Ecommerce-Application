package p1;

import java.util.Scanner;

public class EcommerceApp {
	public String[] products = { "Laptop", "Mobile", "HeadPhones", "Tablets" };
	public int[] stock = { 5, 10, 15, 8 };
	public int[] cart = { 0, 0, 0, 0 };
	public double[] price = { 50000, 20000, 30000, 15000 };

	public void displayProducts() {
		System.out.println("\n===== Available Products =====");
		for (int i = 0; i < products.length; i++) {
			System.out.println((i + 1) + ". " + products[i] +
					" | Price: ₹" + price[i] +
					" | Stock: " + stock[i]);
		}
	}

	public void addToCart(int productIndex, int quantity) {
		if (quantity > stock[productIndex]) {
			System.out.println("Insufficient stock! Available: " + stock[productIndex]);
			return;
		}
		cart[productIndex] += quantity;
		stock[productIndex] -= quantity;
		System.out.println(quantity + " " + products[productIndex] + " added to cart!");
	}

	public void removeFromCart(int productIndex, int quantity) {
		if (quantity > cart[productIndex]) {
			System.out.println("Cannot remove more than cart quantity!");
			return;
		}
		cart[productIndex] -= quantity;
		stock[productIndex] += quantity;
		System.out.println(quantity + " " + products[productIndex] + " removed from cart!");
	}

	public void viewCart() {
		System.out.println("\n===== Your Cart =====");
		boolean empty = true;
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] > 0) {
				System.out.println(products[i] + " x" + cart[i] +
						" = ₹" + (cart[i] * price[i]));
				empty = false;
			}
		}
		if (empty)
			System.out.println("Cart is empty!");
	}

	public void checkout() {
		System.out.println("\n===== Checkout Summary =====");
		double total = 0;
		boolean empty = true;
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] > 0) {
				double subtotal = cart[i] * price[i];
				System.out.println(products[i] + " x" + cart[i] +
						" = ₹" + subtotal);
				total += subtotal;
				empty = false;
			}
		}
		if (empty) {
			System.out.println("Cart is empty!");
		} else {
			System.out.println("----------------------------");
			System.out.println("Total Amount: ₹" + total);
			System.out.println("Order Placed Successfully! 🎉");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EcommerceApp shop = new EcommerceApp();

		while (true) {
			System.out.println("\n===== Menu =====");
			System.out.println("1. View Products");
			System.out.println("2. Add to Cart");
			System.out.println("3. Remove from Cart");
			System.out.println("4. View Cart");
			System.out.println("5. Checkout");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = s.nextInt();

			switch (choice) {
				case 1:
					shop.displayProducts();
					break;

				case 2:
					shop.displayProducts();
					System.out.print("Enter product number: ");
					int pIndex = s.nextInt() - 1;
					System.out.print("Enter quantity: ");
					int qty = s.nextInt();
					shop.addToCart(pIndex, qty);
					break;

				case 3:
					shop.viewCart();
					System.out.print("Enter product number: ");
					int rIndex = s.nextInt() - 1;
					System.out.print("Enter quantity: ");
					int rqty = s.nextInt();
					shop.removeFromCart(rIndex, rqty);
					break;

				case 4:
					shop.viewCart();
					break;

				case 5:
					shop.checkout();
					break;

				case 6:
					System.out.println("Thank you for shopping!");
					System.exit(0);

				default:
					System.out.println("Invalid choice! Enter 1-6");
			}
		}
	}
}