package fixacao;

import fixacao.entities.ImportedProduct;
import fixacao.entities.Product;
import fixacao.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n;i++){
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(type == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product importedProduct = new ImportedProduct(name, price, customsFee);
                productList.add(importedProduct);
            }
            if(type == 'c') {
                Product product = new Product(name, price);
                productList.add(product);
            }
            if(type == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                Product usedProduct = new UsedProduct(name, price, manufactureDate);
                productList.add(usedProduct);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (int i = 0; i < n; i++){
            System.out.println(productList.get(i).priceTag());
        }


        sc.close();
    }
}
