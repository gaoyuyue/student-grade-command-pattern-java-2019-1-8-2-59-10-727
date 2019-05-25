package com.tw;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private final static String FILE_PATH = "student_grade_infos.json";

    public static void save(List<StudentGradeInfo> studentGradeInfos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(FILE_PATH), studentGradeInfos);
    }

    public static List<StudentGradeInfo> getAll() throws IOException {
        File src = new File(FILE_PATH);
        if (!src.exists()) {
            return new ArrayList<>();
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(src, new TypeReference<List<StudentGradeInfo>>() {});
    }
}
