package org.example.model;

import java.io.*;
import java.util.Scanner;

// 보상에 대한 로직을 관리하는 모델 클래스
public class ControlRewardModel {
    public int rewardCount;
    public String rewardPath;

    public ControlRewardModel() {
        this.rewardPath = "dog_txt/reward.txt";
    }

    // 파일에서 현재 보상 개수 읽고 반환
    public int getReward() {
        try {
            File rewardfile = new File(rewardPath);
            Scanner scanner = new Scanner(rewardfile);
            while (scanner.hasNext())
                this.rewardCount = scanner.nextInt();
            scanner.close();
            return this.rewardCount;
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return -1;
        }
    }

    // 투두 달성한 후 받은 보상을 추가하고 파일에 저장
    public void addReward(int num){
        try {
            this.rewardCount += num;

            FileWriter rewardFileWriter = new FileWriter(rewardPath, false);
            BufferedWriter bw = new BufferedWriter(rewardFileWriter);
            bw.write(Integer.toString(this.rewardCount));
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // 사용한 보상만큼 감소시키고 파일에 저장
    public void useReward() {
        try {
            FileWriter rewardFileWriter = new FileWriter(rewardPath, false);
            BufferedWriter bw = new BufferedWriter(rewardFileWriter);
            bw.write(Integer.toString(--this.rewardCount));
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
