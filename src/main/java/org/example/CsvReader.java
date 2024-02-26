package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    public List<Product> readCsvByResource(String csvFile) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(csvFile);
        if (inputStream == null) throw new IllegalArgumentException("파일을 찾을 수 없습니다.");

        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(inputStream);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] columns = line.split(",");
            products.add(new Product(columns[0], columns[1], Integer.parseInt(columns[2])));
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("inputStream을 종료하는데 실패했습니다.", e);
        }
        return products;
    }

    public List<Product> readCsvByNormalPath(String csvFile) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // CSV 파일에서 값을 파싱
                products.add(new Product(columns[0], columns[1], Integer.parseInt(columns[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
        return products;
    }
}
