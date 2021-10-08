package com.demo.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExcelReader {
    private File excelFileLocation;
    private String sheetName;
    private int startRow;
    private int startColumn;
    private int totalRow;
    private int totalColumn;
    private Workbook workbook;
    private Sheet sheet;
    private FileInputStream fis = null;

    public ExcelReader(File excelFileLocation, String sheetName, int startRow, int startColumn) {
        this.excelFileLocation = excelFileLocation;
        this.sheetName = sheetName;
        this.startRow = startRow;
        this.startColumn = startColumn;
        try{
            fis = new FileInputStream(excelFileLocation);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(this.sheetName);
            totalRow = sheet.getPhysicalNumberOfRows();
            totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
            fis.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCellValue(int rowNo, int colNo){
        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(colNo);
        String cellValue = "";
        CellType cellType = cell.getCellType();
        if(cellType.equals(CellType.STRING))
            cellValue = cell.getStringCellValue();
        if(cellType.equals(CellType.NUMERIC)) {
            NumberFormat nf = new DecimalFormat("#.####");
            cellValue = String.valueOf(nf.format(cell.getNumericCellValue()));
        }
        return cellValue;
    }

    public int getTotalRow(){
        return this.totalRow;
    }

    public int getTotalColumn(){
        return this.totalColumn;
    }
}
