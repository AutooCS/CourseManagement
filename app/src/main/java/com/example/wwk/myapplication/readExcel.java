package com.example.wwk.myapplication;
        import android.os.Bundle;
        import android.os.Environment;
        import java.io.File;

        import jxl.Cell;
        import jxl.CellType;
        import jxl.Sheet;
        import jxl.Workbook;

/**
 * Created by wwk on 2015/9/29.
 */
public class readExcel  {
    public static Bundle main(String filepath) {
        Bundle data = null;
        try {
            Workbook workbook = null;
            try {
                File file = new File(filepath);
                workbook = Workbook.getWorkbook(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //得到一张表
            Sheet sheet = workbook.getSheet(0);
            //列数
            int colCount = sheet.getColumns();
            //行数
            int rowCount = sheet.getRows();
            //单元格
            data = new Bundle();
            Character colId = 'A';
            for (int col = 0; col < colCount; col++, colId++) {
                for (int j = 0; j < rowCount; j++) {
                    Cell[] cellcol = sheet.getColumn(col);
                    data.putString(colId + "" + (j + 1), cellcol.toString());
                }
            }
            //关闭workbook,防止内存泄露
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

