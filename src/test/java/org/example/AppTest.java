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
        // System.out 에 대한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕"); // 화면(x)

        // 그 동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();

        // System.out에 대한 화면출력 금지 끝
        TestUtil.clearSetOutToByteArray(output);    // 원상복구
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

