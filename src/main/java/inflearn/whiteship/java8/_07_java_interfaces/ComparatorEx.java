package inflearn.whiteship.java8._07_java_interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("ninjasul", 1000),
            new Product("dy", 5000),
            new Product("sy", 3000),
            new Product( "foo", 10000),
            new Product( "foo", 2000),
            new Product( null, 100000),
            new Product( "", 5000),
            null
        );

        Comparator<String> nameComparator = Comparator.nullsLast(Comparator.naturalOrder());
        Comparator<Product> comparingWithName = Comparator.nullsFirst(Comparator.comparing(Product::getName, nameComparator));
        products.sort(comparingWithName);
        System.out.println("######### Comparing with name in natural order #########");
        System.out.println(products);

        products.sort(comparingWithName.reversed());
        System.out.println("######### Comparing with name in reversed order #########");
        System.out.println(products);

        Comparator<Product> comparingWithPrice = Comparator.nullsFirst(Comparator.comparing(Product::getPrice));
        products.sort(comparingWithName.thenComparing(comparingWithPrice));
        System.out.println("######### Comparing with name and price in natural order #########");;
        System.out.println(products);

        products.sort(comparingWithName.thenComparing(comparingWithPrice.reversed()));
        System.out.println("######### Comparing with name in natural and price in reversed order #########");;
        System.out.println(products);
    }
}
