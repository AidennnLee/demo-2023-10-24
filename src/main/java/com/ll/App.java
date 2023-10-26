package com.ll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    List<Word> words = new ArrayList<>();
    int wordNum = 0;

    public void run() throws IOException {
        System.out.println("== 명언 앱 ==");

        //String word, author;

        //String filePath = "c:\\Users\\yw010\\source\\demo20231024\\text.text";
        //FileReader fin = new FileReader(filePath);
        //FileWriter fout = new FileWriter(filePath);

        while (true){ //기능 : 명언 등록(번호 출력), 명언 목록(번호 포함), 삭제(예외처리), 수정, 파일 영속성, data.json 빌드, 종료
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                write();
            }
            else if(cmd.equals("목록")){
                read();
            }
            else if(cmd.startsWith("삭제")){
                delete(cmd);
            }
            else if(cmd.startsWith("수정")){
                modify(cmd);
            }
        }
        scanner.close();
        //fin.close();
        //fout.close();
    }

    void write(){
        System.out.print("명언 : ");
        String sectence = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        //fout.write(sectence);
        //fout.write(author);
        //fout.write(wordNum);
        Word word = new Word(sectence, author, ++wordNum);
        words.add(word);
        System.out.println(wordNum + "번 명언이 등록되었습니다.");
    }
    void read(){
        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for(int i = words.size() - 1; i >= 0; i--){
            if(words.get(i) != null){
                System.out.println(words.get(i).id + " / " + words.get(i).author + " / " + words.get(i).word);
            }
        }
    }

    void delete(String cmd){
        int queryIndex = Integer.parseInt(cmd.substring(6));
        if(words.get(queryIndex - 1) == null){
            System.out.println(queryIndex + "번 명언은 존재하지 않습니다.");
        }
        else{
            words.set(queryIndex - 1, null);
            System.out.println(queryIndex + "번 명언이 삭제되었습니다.");
        }
    }

    void modify(String cmd){
        int queryIndex = Integer.parseInt(cmd.substring(6)) - 1;
        System.out.print("명언(기존) : " + words.get(queryIndex).word + "\n명언 : ");
        words.get(queryIndex).word = scanner.nextLine();
        System.out.print("작가(기존) : " + words.get(queryIndex).author + "\n작가 : ");
        words.get(queryIndex).author = scanner.nextLine();
    }
}