package Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public void putData(String sheetName, List<String> data) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(data.get(i));
        }
        
        String filePath = System.getProperty("user.dir") + "\\Excel Files\\Book1.xlsx";
        FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "\\Excel Files\\Book1.xlsx"));
        workbook.write(out);
        out.close();
    }
}





