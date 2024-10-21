import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CourseInfo {
    private String name;
    private String courses;
    private String fee;

    public CourseInfo(String name, String courses, String fee) {
        this.name = name;
        this.courses = courses;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Courses: " + courses + ", Fee: " + fee;
    }
}

class ReadAnWriteData {
    public static void main(String[] args) {
        List<CourseInfo> courseList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("Data.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // Skip the header row
                if (row.getRowNum() == 0) continue;
                DataFormatter formatter = new DataFormatter();

                String name = row.getCell(0).getStringCellValue();
                String courses = row.getCell(1).getStringCellValue();
                String fee = formatter.formatCellValue(row.getCell(2));

                CourseInfo courseInfo = new CourseInfo(name, courses, fee);
                courseList.add(courseInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Displaying the data
        for (CourseInfo info : courseList) {
            System.out.println(info);
        }
    }
}
