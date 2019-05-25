package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return true;
    }
}
