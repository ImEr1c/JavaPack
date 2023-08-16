package com.imer1c.api.minecraft.chatting.text;

public interface IScoreTextComponent extends ITextComponent {
    Score getScore();

    class Score {
        private final String name;
        private final String objective;

        public Score(String name, String objective)
        {
            this.name = name;
            this.objective = objective;
        }

        public String getName()
        {
            return name;
        }

        public String getObjective()
        {
            return objective;
        }
    }
}
