package com.ll;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//명령 : 명언 등록, 목록, 삭제, 수정, 프로그램 종료

class Main {
    public static void main(String[] args){
        new App().run();


    }
}

class Word{
    String word;
    String author;

    int wordNum;

    Word(String word, String author, int wordNum){
        this.word = word;
        this.author = author;
        this.wordNum = wordNum;
    }
}