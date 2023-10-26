package com.ll;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//기능 : 명언 등록(번호 출력), 명언 목록(번호 포함), 삭제(예외처리), 수정, 파일 영속성, data.json 빌드, 종료
class Main {
    public static void main(String[] args) throws IOException {
        new App().run();
    }
}