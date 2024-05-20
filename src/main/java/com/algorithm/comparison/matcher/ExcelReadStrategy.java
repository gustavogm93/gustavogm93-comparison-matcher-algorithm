package com.algorithm.comparison.matcher;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReadStrategy implements ReadStrategy<Contact> {
    private final String filePath;

    public ExcelReadStrategy(String filePath) {
        this.filePath = filePath;
    }

    public List<Contact> parse() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        if (iterator.hasNext()) iterator.next();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Contact contact = new Contact(
                    (int) nextRow.getCell(0).getNumericCellValue(), // ID
                    nextRow.getCell(1).getStringCellValue(), // First Name
                    nextRow.getCell(2).getStringCellValue(), // Last Name
                    nextRow.getCell(3).getStringCellValue(), // Email
                    String.valueOf(nextRow.getCell(4).getNumericCellValue()), // Zip Code
                    nextRow.getCell(5).getStringCellValue()  // Address
            );
            contacts.add(contact);
        }

        workbook.close();
        inputStream.close();
        return contacts;
    }

    @Override
    public Contact parse(String[] fields) {
        return null;
    }
}