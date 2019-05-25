package com.tw;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentGradeSystem studentGradeSystem = new StudentGradeSystem();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 添加学生\n" +
                    "2. 生成成绩单\n" +
                    "3. 退出\n" +
                    "请输入你的选择（1～3）：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                    addStudent();
                    break;
                case 2:
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    generateReport();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String studentGradeInfoStr = scanner.nextLine();
        StudentGradeInfo studentGradeInfo = studentGradeSystem.parseStudent(studentGradeInfoStr);
        if (studentGradeInfo == null) {
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            addStudent();
            return;
        }
        if (!studentGradeSystem.save(studentGradeInfo)) {
            System.out.println("此学生已存在，请重新输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            addStudent();
            return;
        }
        System.out.println("学生" + studentGradeInfo.getName() + "的成绩被添加");
    }

    private static void generateReport() {
        Scanner scanner = new Scanner(System.in);
        String idsStr = scanner.nextLine();
        List<String> studentIds = studentGradeSystem.parseStudentIds(idsStr);
        if (studentIds.size() <= 0) {
            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            generateReport();
            return;
        }
        List<StudentGradeInfo> studentGradeInfos = studentGradeSystem.find(studentIds);
        List<StudentGradeReport> studentGradeReports = studentGradeSystem.generateReport(studentGradeInfos);
        String reportStr = PrintUtil.formatReport(studentGradeReports);
        System.out.println(reportStr);
    }
}
