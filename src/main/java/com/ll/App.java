package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Word> words = new ArrayList<>();
    int wordId = 0;

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) { //기능 : 명언 등록(번호 출력), 명언 목록(번호 포함), 삭제(예외처리), 수정, 파일 영속성, data.json 빌드, 종료
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                addWord();
            } else if (cmd.equals("목록")) {
                showList();
            } else if (cmd.startsWith("삭제")) {
                deleteWord(cmd);
            } else if (cmd.startsWith("수정")) {
                modifyWord(cmd);
            }
        }
        scanner.close();
    }

    private void addWord() {
        System.out.print("명언 : ");
        String sentence = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Word word = new Word(sentence, author, ++wordId);
        words.add(word);
        System.out.println(wordId + "번 명언이 등록되었습니다.");
    }

    private void showList() {
        Word word;
        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for (int i = words.size() - 1; i >= 0; i--) {
            word = words.get(i);
            System.out.println(word.id + " / " + word.author + " / " + word.sentence);
        }
    }

    private void deleteWord(String cmd) {
        int queryId = findIdFromQuery(cmd);
        int queryIndex = findIndexById(queryId);

        if (queryIndex != -1) {
            words.remove(queryIndex);
            System.out.println(queryId + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(queryId + "번 명언은 존재하지 않습니다.");
        }
    }

    private void modifyWord(String cmd) {
        int queryId = findIdFromQuery(cmd);
        int queryIndex = findIndexById(queryId);

        if (queryIndex != -1) {
            Word queryWord = words.get(queryIndex);
            System.out.print("명언(기존) : " + queryWord.sentence + "\n명언 : ");
            queryWord.sentence = scanner.nextLine();
            System.out.print("작가(기존) : " + queryWord.author + "\n작가 : ");
            queryWord.author = scanner.nextLine();
        }
        else{
            System.out.println(queryId +"번 명언은 존재하지 않습니다.");
        }
    }

    private int findIdFromQuery(String query){
        return Integer.parseInt(query.substring(6));
    }
    private int findIndexById(int id) {
        Word word;
        for (int i = 0; i < words.size(); i++) {
            word = words.get(i);
            if (word.id == id) {
                return i;
            }
        }
        return -1;
    }
}