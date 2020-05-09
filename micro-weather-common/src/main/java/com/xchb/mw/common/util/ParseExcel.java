package com.xchb.mw.common.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
public class ParseExcel {

    public static void main(String[] args) throws IOException {
        InputStream iso = new FileInputStream("C:\\Users\\XDD\\Desktop\\chian-city-list.xlsx");
        System.out.println(iso);
        Workbook workbook = WorkbookFactory.create(iso);
        int numberOfSheets = workbook.getNumberOfSheets();  //表格数量

        StringBuilder builder = new StringBuilder("{\"data\":[");

        for(int i=0;i<numberOfSheets;i++){
            Sheet sheetAt = workbook.getSheetAt(i);
            int rowCount = sheetAt.getPhysicalNumberOfRows(); //行的数量
            for(int j=0;j<rowCount;j++){
                Row row = sheetAt.getRow(j);
                if(row.getRowNum()>2){
                    String cityId = row.getCell(0).toString().replace("CN","");
                    String cityName = row.getCell(2).toString();
                    builder.append("{\"name\":\""+cityName+"\",\"id\":\""+cityId+"\"},");
                }

            }
        }
        builder.append("]}");

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\XDD\\Desktop\\chian-city-list.json");
        System.out.println(builder.toString());
        fileOutputStream.write(builder.toString().getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        workbook.close();
        iso.close();
    }
}
