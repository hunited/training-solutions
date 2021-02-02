package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Orders {

    private final Map<String, List<String>> orderList = new HashMap<>();
    private final Map<String, Integer> productList = new HashMap<>();

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                String[] items = row[1].split(",");
                orderList.put(row[0], List.of(items));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
        makeProductList();
    }

    public List<String> orderFinder(String term) {
        List<String> result;
        result = new ArrayList<>(orderList.get(term));
        Collections.sort(result);
        return result;
    }

    public int productFinder(String name) {
        if (productList.get(name) != null) {
            return productList.get(name);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

    public int numOfProductByName(String name) {
        if (orderList.get(name) != null) {
            return orderList.get(name).size();
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }

    public Map<String, List<String>> getOrderList() {
        isError();
        return orderList;
    }

    public Map<String, Integer> getProductList() {
        isError();
        return productList;
    }

    private void makeProductList() {
        for (String name : orderList.keySet()) {
            buildProductList(name);
        }
    }

    private void buildProductList(String name) {
        for (String product : orderList.get(name)) {
            if (productList.containsKey(product)) {
                productList.replace(product, productList.get(product) + 1);
            } else {
                productList.put(product, 1);
            }
        }
    }

    private void isError() {
        if (orderList.isEmpty() || productList.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
    }

}
