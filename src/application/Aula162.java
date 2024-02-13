package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Aula162 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number of products: ");
		int n = sc.nextInt();
		
		List<Product> products = new ArrayList<Product>();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			System.out.print("Common, imported or used? (c/i/u) ");
			char ciu = sc.next().charAt(0);
			
			if (ciu == 'c') {
				Product p = new Product(name, price);
				products.add(p);
			} else if (ciu == 'i') {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, fee);
				products.add(p);
			} else if (ciu == 'u') {
				System.out.print("Manufacture date: (dd/mm/yyyy) ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date md = sdf.parse(sc.next()); // * add throws declaration
				Product p = new UsedProduct(name, price, md);
				products.add(p);
			}
		}
		
		System.out.println("\nPRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}