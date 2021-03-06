package com.tw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentGradeSystem {
    private final static String STUDENT_GRADE_INFO_FORMAT_REGEX = "([^，]+)，(\\w+)，语文：(\\d+)，数学：(\\d+)，英语：(\\d+)，编程：(\\d+)";

    public StudentGradeInfo parseStudent(String studentGradeInfoString) {
        Matcher matcher = Pattern.compile(STUDENT_GRADE_INFO_FORMAT_REGEX).matcher(studentGradeInfoString);
        if (!matcher.matches()) {
            return null;
        }
        return new StudentGradeInfo(matcher.group(1), matcher.group(2),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)),
                Integer.parseInt(matcher.group(5)),
                Integer.parseInt(matcher.group(6)));
    }

    public boolean save(StudentGradeInfo studentGradeInfo) {
        try {
            List<StudentGradeInfo> studentGradeInfos = FileUtil.getAll();
            boolean isExisted = studentGradeInfos.stream().anyMatch(item -> item.getStudentId().equals(studentGradeInfo.getStudentId()));
            if (isExisted) {
                return false;
            }
            studentGradeInfos.add(studentGradeInfo);
            FileUtil.save(studentGradeInfos);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public List<StudentGradeInfo> find(List<String> ids) {
        List<StudentGradeInfo> studentGradeInfos = new ArrayList<>();
        try {
            studentGradeInfos = FileUtil.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentGradeInfos.stream().filter(item -> ids.contains(item.getStudentId())).collect(Collectors.toList());
    }

    public List<StudentGradeReport> generateReport(List<StudentGradeInfo> studentGradeInfos) {
        return studentGradeInfos.stream()
                .map(item -> new StudentGradeReport(
                        item.getName(),
                        item.getChineseScore(),
                        item.getMathScore(),
                        item.getEnglishScore(),
                        item.getProgramScore()))
                .collect(Collectors.toList());
    }

    public List<String> parseStudentIds(String ids) {
        return Arrays.stream(ids.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
