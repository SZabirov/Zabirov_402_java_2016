package ru.itis.inform.knights;

public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }
    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
