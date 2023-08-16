package com.imer1c.api.minecraft.entity.target;

public interface TargetSelector {
    Target getTarget();

    //Entity type

    TargetSelector limit(int limit);

    int getLimit();

    TargetSelector sort(Sort sort);

    Sort getSort();

    TargetSelector location(double x, double y, double z);

    double getX();
    double getY();
    double getZ();

    TargetSelector to(double x, double y, double z);

    double getToX();
    double getToY();
    double getToZ();

    SelectionArea getSelectionArea();

    TargetSelector distance(double min, double max);

    TargetSelector minDistance(double minDist);

    TargetSelector maxDistance(double maxDist);

    double getMinimumDistance();
    double getMaximumDistance();

    TargetSelector verticalRot(double min, double max);

    TargetSelector minVerticalRot(double minXRot);

    TargetSelector maxVerticalRot(double maxXRot);

    double getMinimumVerticalRotation();
    double getMaximumVerticalRotation();

    TargetSelector horizontalRot(double min, double max);

    TargetSelector minHorizontalRot(double minYRot);

    TargetSelector maxHorizontalRot(double maxYRot);

    double getMinimumHorizontalRotation();
    double getMaximumHorizontalRotation();

    TargetSelector team(String team, TeamOption option);

    default TargetSelector team(String team)
    {
        return team(team, TeamOption.ONLY_IN_TEAM);
    }

    String getTeamName();

    TeamOption getTeamOption();

    TargetSelector name(String name, boolean equals);

    default TargetSelector name(String name)
    {
        return name(name, true);
    }

    String getName();

    //NBT

    TargetSelector gameMode(GameMode gameMode, boolean equals);

    default TargetSelector gameMode(GameMode gameMode)
    {
        return gameMode(gameMode, true);
    }

    GameMode getGameMode();

    TargetSelector xpLevel(int min, int max);

    TargetSelector minXPLevel(int min);

    TargetSelector maxXPLevel(int max);

    int getMinimumXPLevel();
    int getMaximumXPLevel();

    //Advancements

    TargetSelector tags(String... tags);

    String[] getTags();

    //Predicates

    //Scores
}
