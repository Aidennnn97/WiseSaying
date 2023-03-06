package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    @DisplayName("스캐너에_키보드가_아닌_문자열을_입력으로_설정")
    public void t1() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    @DisplayName("출력을_모니터에_하지_않고_문자열로_얻기")
    public void t2() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
    }

//    @Test
//    @DisplayName("문자열을_파일에_저장")
//    public void t3() {
//        Util.file.mkdir(App.getDataBaseDir());
//        Util.file.saveToFile(App.getDataBaseDir() + "/1.txt", "안녕");
//
//        String body = Util.file.readFromFile(App.getDataBaseDir() + "/1.txt", "");
//
//        assertEquals("안녕", body);
//    }
}

