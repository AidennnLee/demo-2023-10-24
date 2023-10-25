package com.ll;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//명령 : 명언 등록, 목록, 삭제, 수정, 프로그램 종료

class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        Word [] words = new Word[10];
        String word, author;
        int wordNum = 0;
        //FileReader fin = new FileReader("c:\\Users\\yw010\\source\\demo20231024\\text.text");
        //FileWriter fout = new FileWriter("c:\\Users\\yw010\\source\\demo20231024\\text.txt");


        System.out.println("== 명언 앱 ==");
        while (!cmd.equals("종료")){
            System.out.print("명령) ");
            cmd = scanner.nextLine();
            if(cmd.equals("등록")){
                System.out.print("명언 : ");
                word = scanner.nextLine();
                System.out.print("작가 : ");
                author = scanner.nextLine();
                words[wordNum] = new Word(word, author, wordNum++);
                System.out.println(wordNum + "번 명언이 등록되었습니다.");
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언\n" +
                        "----------------------");
                for(int i = wordNum; i > 0; i--){
                    if(words[i - 1] != null){
                        System.out.println(i + " / " + words[i - 1].author + " / " + words[i - 1].word);
                    }
                }
            }
            else if(cmd.startsWith("삭제")){
                int num = Integer.parseInt(cmd.substring(6));
                if(words[num - 1] == null){
                    System.out.println(num + "번 명언은 존재하지 않습니다.");
                }
                else{
                    words[num - 1] = null;
                    System.out.println(num + "번 명언이 삭제되었습니다.");
                }
            }
            else if(cmd.startsWith("수정")){
                int num = Integer.parseInt(cmd.substring(6));
                System.out.print("명언(기존) : " + words[num - 1].word + "\n명언 : ");
                words[num - 1].word = scanner.nextLine();
                System.out.print("작가(기존) : " + words[num - 1].author + "\n작가 : ");
                words[num - 1].author = scanner.nextLine();
            }
        }

        scanner.close();
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