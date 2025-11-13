package com.demoqa.utils;

import com.demoqa.models.UserForm;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    /**
     * Lee usuarios desde un archivo Excel (.xlsx) ubicado en cualquier ruta.
     *
     * @param filePath Ruta completa del archivo Excel.
     * @return Lista de UserForm.
     */
    public static List<UserForm> readUsersFromExcel(String filePath) {
        List<UserForm> users = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Saltar encabezado
            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();

                String firstName = getCellValue(row, 0);
                String lastName = getCellValue(row, 1);
                String email = getCellValue(row, 2);
                String gender = getCellValue(row, 3);
                String mobile = getCellValue(row, 4);
                String dateOfBirth = getCellValue(row, 5);
                String subject = getCellValue(row, 6);
                String hobbie = getCellValue(row, 7);
                String address = getCellValue(row, 8);
                String state = getCellValue(row, 9);
                String city = getCellValue(row, 10);

                users.add(new UserForm(firstName, lastName, email, gender, mobile,
                        dateOfBirth, subject, hobbie, address, state, city));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Obtiene el valor de la celda como String.
     */
    private static String getCellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) return "";
        cell.setCellType(CellType.STRING); // Forzar a String
        return cell.getStringCellValue().trim();
    }
}
