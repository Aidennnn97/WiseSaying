package org.example;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {    // AppTest에 사용될 중복코드
    public static String run(String cmd) {
        cmd.stripIndent().trim();   // 공백 제거

        cmd += "\n종료";  // 어떤 명령어가 들어오던 간에 마지막에 종료를 붙임

        Scanner sc = TestUtil.genScanner(cmd);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        return rs;
    }
}
