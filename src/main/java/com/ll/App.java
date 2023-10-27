package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Word> words = new ArrayList<>();
    int wordId = 0;

    public void run(){
        System.out.println("== 명언 앱 ==");

        while (true){ //기능 : 명언 등록(번호 출력), 명언 목록(번호 포함), 삭제(예외처리), 수정, 파일 영속성, data.json 빌드, 종료
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                addWord();
            }
            else if(cmd.equals("목록")){
                showList();
            }
            else if(cmd.startsWith("삭제")){
                deleteWord(cmd);
            }
            else if(cmd.startsWith("수정")){
                modifyWord(cmd);
            }
        }
        scanner.close();
    }

    private void addWord(){
        System.out.print("명언 : ");
        String sentence = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Word word = new Word(sentence, author, ++wordId);
        words.add(word);
        System.out.println(wordId + "번 명언이 등록되었습니다.");
    }
    private void showList(){
        Word word;
        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for(int i = words.size() - 1; i >= 0; i--){
            word = words.get(i);
            System.out.println(word.id + " / " + word.author + " / " + word.sentence);
        }
    }

    private void deleteWord(String cmd){
        int queryId = Integer.parseInt(cmd.substring(6));
        Word word;

        for(int i = 0; i < words.size(); i++){
            word = words.get(i);
            if(word.id == queryId){
                words.remove(i);
                System.out.println(queryId + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(queryId + "번 명언은 존재하지 않습니다.");
    }

    private void modifyWord(String cmd){
        int queryId = Integer.parseInt(cmd.substring(6));
        Word word;

        for(int i = 0; i < words.size(); i++){
            word = words.get(i);
            if(word.id == queryId){
                System.out.print("명언(기존) : " + word.sentence+ "\n명언 : ");
                word.sentence = scanner.nextLine();
                System.out.print("작가(기존) : " + word.author + "\n작가 : ");
                word.author = scanner.nextLine();
                return;
            }
        }
        System.out.println(queryId + "번 명언은 존재하지 않습니다.");
    }
}