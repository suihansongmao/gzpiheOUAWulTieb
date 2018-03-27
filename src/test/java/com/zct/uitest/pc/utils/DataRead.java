package com.zct.uitest.pc.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取数据的类
 */

public class DataRead {
    private static Object[][] getDataFromCSV() throws Exception {
        List<Object[]> records = new ArrayList<Object[]>();
        BufferedReader br = new BufferedReader(new FileReader("E:\\idea\\intert\\src\\test\\java\\loginData.csv"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String item[] = line.split(",");
            records.add(item);
        }
        Object[][] results = new Object[records.size()][];
        for (int i=0; i<records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }
    public static Object[][] getDataFromExcel(String filePath, String sheetname) throws Exception {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = filePath.substring(filePath.indexOf("."));
        if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }
        Sheet sheet = workbook.getSheet(sheetname);
        int rowCnt = sheet.getLastRowNum() - sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();
        for (int i=0; i<rowCnt; i++) {
            Row row = sheet.getRow(i);
            String fields[] = new String[row.getLastCellNum()];
            for (int j=0; j<row.getLastCellNum(); j++) {
                fields[j] = row.getCell(j).getStringCellValue();
            }
            records.add(fields);
        }
        Object[][] results = new Object[records.size()][];
        for (int i=0; i<records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }
    public static void main(String args[]) throws Exception {
        Object[][] data = getDataFromCSV();
    }
}
