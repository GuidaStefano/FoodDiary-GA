package it.unisa.loader;

import it.unisa.obj.Food;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FoodLoader {

    private static final String PATH = "src/main/resources/nutrition-data.xlsx";
    public static final Set<Food> ALL_FOODS = new HashSet<>();

    public static void init() {
        try (FileInputStream fis = new FileInputStream(PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Ottieni il primo foglio di lavoro
            Sheet sheet = workbook.getSheetAt(0);

            // Itera attraverso le righe del foglio
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                Food food = new Food();
                // Itera attraverso le celle della riga
                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 0:
                            food.setId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            food.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            food.setCalories((int) cell.getNumericCellValue());
                            break;
                        case 3:
                            food.setTotalFat(getCellData(cell));
                            break;
                        case 4:
                            food.setProtein((getCellData(cell)));
                            break;
                        case 5:
                            food.setCarbohydrate(getCellData(cell));
                            break;
                    }
                }
                ALL_FOODS.add(food);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static float getCellData(Cell cell) {
        try {
            String value = cell.getStringCellValue();
            value = value.replace("g", "").trim();
            return Float.parseFloat(value);
        } catch (IllegalStateException e) {
            return (float) cell.getNumericCellValue();
        }
    }

}
