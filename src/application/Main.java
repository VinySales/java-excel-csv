package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {
		String path = "c:\\temp\\Pasta1.csv";
		File file = new File(path);
		
		boolean outDirectory = new File(file.getParent() + "\\out").mkdir();
		
		//Criando caminho destino do meu arquivo
		String targetFilePath = file.getParent() + "\\out\\sumary.csv";

		List<Product> products = new ArrayList<Product>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while (line != null) {
				
				String name = line.split(",")[0];
				double value = Double.parseDouble(line.split(",")[1]);
				int quantity = Integer.parseInt(line.split(",")[2]);
				
				products.add(new Product(name, value, quantity));
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath))) {
			for (Product product : products) {
				bw.write(product.getName() + "," + product.total());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		
		System.out.println(products);
		
	}

}
