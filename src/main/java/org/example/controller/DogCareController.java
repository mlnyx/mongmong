package org.example.controller;
import org.example.model.ControlRewardModel;
import org.example.model.DogLevelModel;

// 강아지를 케어하는 업무를 수행하는 모델을 호출하는 컨트롤러 클래스
public class DogCareController {
    private DogLevelModel dogLevel;
    private ControlRewardModel controlReward;

    public DogCareController(DogLevelModel dogLevel, ControlRewardModel controlReward) {
        this.dogLevel = dogLevel;
        this.controlReward = controlReward;
    }

    public void careDog() {
        if (controlReward.getReward() > 0){
            controlReward.useReward();
            dogLevel.increaseCloseness(10);
            dogLevel.increaseLevel();
        }
    }

    // 강아지 버튼 클릭 시 친밀도 +1. 친밀도 100 달성 시 레벨 +1
    public void touchDog() {
        dogLevel.increaseCloseness(1);
        dogLevel.increaseLevel();
    }
}
