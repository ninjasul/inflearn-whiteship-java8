package inflearn.whiteship.java8._07_java_interfaces;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Product {
    private String name;
    private int price;

    @Builder
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
