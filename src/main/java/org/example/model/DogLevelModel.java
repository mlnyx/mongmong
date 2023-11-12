package org.example.model;

import java.io.*;
import java.util.Scanner;

// 강아지의 친밀도, 레벨, 성장 단계에 대한 로직을 관리하는 모델 클래스
public class DogLevelModel {
    private String closenessPath, levelPath;
    private int closeness, level;
    private String dogImagePath;

    public DogLevelModel() {
        this.closenessPath = "dog_txt/closeness.txt";
        this.levelPath = "dog_txt/level.txt";
        this.closeness = this.getCloseness();
        this.level = this.getLevel();
        this.dogImagePath = this.growUp(this.getLevel());
    }

    // 파일에서 현재 친밀도 읽고 반환
    public int getCloseness() {
        try {
            File closenessfile = new File(closenessPath);
            Scanner scanner = new Scanner(closenessfile);

            while (scanner.hasNext())
                this.closeness = scanner.nextInt();
            scanner.close();

            return this.closeness;
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return -1;
        }
    }

    // 파일에서 현재 레벨 읽고 반환
    public int getLevel() {
        try {
            File levelfile = new File(levelPath);
            Scanner scanner = new Scanner(levelfile);

            while (scanner.hasNext())
                this.level = scanner.nextInt();
            scanner.close();

            return this.level;
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return -1;
        }
    }

    // 친밀도를 상승시키고 파일에 저장
    public void increaseCloseness(int num) {
        this.closeness += num;

        try {
            FileWriter closenessFileWriter = new FileWriter(closenessPath, false);
            BufferedWriter bw = new BufferedWriter(closenessFileWriter);
            bw.write(Integer.toString(this.closeness));
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // 친밀도 100이상이면 친밀도 -100, 레벨 +1 연산 후 파일에 저장.
    public void increaseLevel() {
        if(this.closeness >= 100){
            try {
                this.closeness -= 100;

                FileWriter closenessFileWriter = new FileWriter(closenessPath, false);
                BufferedWriter bw1 = new BufferedWriter(closenessFileWriter);
                bw1.write(Integer.toString(this.closeness));
                bw1.close();


                FileWriter levelFileWriter = new FileWriter(levelPath, false);
                BufferedWriter bw2 = new BufferedWriter(levelFileWriter);
                bw2.write(Integer.toString(++this.level));
                bw2.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // 특정 레벨에 도달 시 성장한 강아지의 이미지 경로를 반환
    public String growUp(int level) {
        if (level >= 50) {
            this.dogImagePath = "dog_image/dog_big_costume.png";
        } else if (level >= 40) {
            this.dogImagePath = "dog_image/dog_big.png";
        } else if (level >= 30) {
            this.dogImagePath = "dog_image/dog_middle_costume.png";
        } else if (level >= 20) {
            this.dogImagePath = "dog_image/dog_middle.png";
        } else if (level >= 10) {
            this.dogImagePath = "dog_image/dog_small_costume.png";
        } else if (level >= 0) {
            this.dogImagePath = "dog_image/dog_small.png";
        }
        return this.dogImagePath;
    }
}