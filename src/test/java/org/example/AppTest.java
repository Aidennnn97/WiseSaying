package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    // 테스트 유틸 테스트 시작
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

    // 테스트 유틸 테스트 끝

    // 앱 테스트 시작

    @Test
    @DisplayName("프로그램_시작시_타이틀_출력_그리고_종료")
    public void t3() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs)
                .contains("== 명언 앱 ==")
                .contains("명령) ")
                .doesNotContain("올바르지 않은 명령입니다.")
                .contains("프로그램이 종료되었습니다.");
    }

    // 앱 테스트 끝
}

