package com.imer1c.impl.minecraft.entity.target;

import com.imer1c.api.minecraft.entity.target.*;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.FixedRange;
import com.imer1c.utils.Range;

public class TargetSelectorImpl implements TargetSelector {

    private final Target target;
    private int limit;
    private Sort sort;
    private double x, y, z;
    private double dx, dy, dz;
    private SelectionArea area;
    private Range distance, horizontalRot, verticalRot;
    private String teamName;
    private TeamOption teamOption;
    private String name;
    private FixedRange xpLevel;
    private GameMode gameMode;
    private String[] tags;
    private boolean nameEqual, gameModeEqual;

    public TargetSelectorImpl(Target target)
    {
        this.target = target;
    }

    @Override
    public Target getTarget()
    {
        return this.target;
    }

    @Override
    public TargetSelector limit(int limit)
    {
        this.limit = limit;
        return this;
    }

    @Override
    public int getLimit()
    {
        return this.limit;
    }

    @Override
    public TargetSelector sort(Sort sort)
    {
        this.sort = sort;
        return this;
    }

    @Override
    public Sort getSort()
    {
        return this.sort;
    }

    @Override
    public TargetSelector location(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public double getX()
    {
        return this.x;
    }

    @Override
    public double getY()
    {
        return this.y;
    }

    @Override
    public double getZ()
    {
        return this.z;
    }

    @Override
    public TargetSelector to(double x, double y, double z)
    {
        this.checkAndThrowForSelectionArea(SelectionArea.VOLUME);
        this.dx = x;
        this.dy = y;
        this.dz = z;
        return this;
    }

    @Override
    public double getToX()
    {
        return this.dx;
    }

    @Override
    public double getToY()
    {
        return this.dy;
    }

    @Override
    public double getToZ()
    {
        return this.dz;
    }

    private void checkAndThrowForSelectionArea(SelectionArea area)
    {
        if (this.area != null)
        {
            if (this.area == SelectionArea.VOLUME)
            {
                throw new RuntimeException("Can't set the distance because you already have the delta values for X, Y, Z");
            }
            else
            {
                throw new RuntimeException("Can't set the delta values for X, Y, Z because you already set a distance");
            }
        }

        this.area = area;
    }

    @Override
    public SelectionArea getSelectionArea()
    {
        return this.area;
    }

    @Override
    public TargetSelector distance(double min, double max)
    {
        this.distance = new Range(min, max);
        this.checkAndThrowForSelectionArea(SelectionArea.RADIUS);
        return this;
    }

    @Override
    public TargetSelector minDistance(double minDist)
    {
        this.distance = new Range(minDist, 0);
        this.checkAndThrowForSelectionArea(SelectionArea.RADIUS);
        return this;
    }

    @Override
    public TargetSelector maxDistance(double maxDist)
    {
        this.distance = new Range(0, maxDist);
        this.checkAndThrowForSelectionArea(SelectionArea.RADIUS);
        return this;
    }

    @Override
    public double getMinimumDistance()
    {
        return this.distance.getMin();
    }

    @Override
    public double getMaximumDistance()
    {
        return this.distance.getMax();
    }

    @Override
    public TargetSelector verticalRot(double min, double max)
    {
        this.verticalRot = new Range(min, max);
        return this;
    }

    @Override
    public TargetSelector minVerticalRot(double minXRot)
    {
        this.verticalRot = new Range(minXRot, 0);
        return this;
    }

    @Override
    public TargetSelector maxVerticalRot(double maxXRot)
    {
        this.verticalRot = new Range(0, maxXRot);
        return this;
    }

    @Override
    public double getMinimumVerticalRotation()
    {
        return this.verticalRot.getMin();
    }

    @Override
    public double getMaximumVerticalRotation()
    {
        return this.verticalRot.getMax();
    }

    @Override
    public TargetSelector horizontalRot(double min, double max)
    {
        this.horizontalRot = new Range(min, max);
        return this;
    }

    @Override
    public TargetSelector minHorizontalRot(double minYRot)
    {
        this.horizontalRot = new Range(minYRot, 0);
        return this;
    }

    @Override
    public TargetSelector maxHorizontalRot(double maxYRot)
    {
        this.horizontalRot = new Range(0, maxYRot);
        return this;
    }

    @Override
    public double getMinimumHorizontalRotation()
    {
        return this.horizontalRot.getMin();
    }

    @Override
    public double getMaximumHorizontalRotation()
    {
        return this.horizontalRot.getMax();
    }

    @Override
    public TargetSelector team(String team, TeamOption option)
    {
        this.teamName = team;
        this.teamOption = option;
        return this;
    }

    @Override
    public String getTeamName()
    {
        return this.teamName;
    }

    @Override
    public TeamOption getTeamOption()
    {
        return this.teamOption;
    }

    @Override
    public TargetSelector name(String name, boolean equals)
    {
        this.name = name;
        this.nameEqual = equals;
        return this;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public boolean isNameEqual()
    {
        return nameEqual;
    }

    @Override
    public TargetSelector gameMode(GameMode gameMode, boolean equals)
    {
        this.gameMode = gameMode;
        this.gameModeEqual = equals;
        return this;
    }

    @Override
    public GameMode getGameMode()
    {
        return this.gameMode;
    }

    public boolean isGameModeEqual()
    {
        return gameModeEqual;
    }

    @Override
    public TargetSelector xpLevel(int min, int max)
    {
        this.xpLevel = new FixedRange(min, max);
        return this;
    }

    @Override
    public TargetSelector minXPLevel(int min)
    {
        this.xpLevel = new FixedRange(min, 0);
        return this;
    }

    @Override
    public TargetSelector maxXPLevel(int max)
    {
        this.xpLevel = new FixedRange(0, max);
        return this;
    }

    @Override
    public int getMinimumXPLevel()
    {
        return this.xpLevel.getMin();
    }

    @Override
    public int getMaximumXPLevel()
    {
        return this.xpLevel.getMax();
    }

    @Override
    public TargetSelector tags(String... tags)
    {
        this.tags = tags;
        return this;
    }

    @Override
    public String[] getTags()
    {
        return this.tags;
    }

    @Override
    public String toString()
    {
        return Formatters.format(this);
    }

    public Range getHorizontalRot()
    {
        return horizontalRot;
    }

    public Range getVerticalRot()
    {
        return verticalRot;
    }

    public Range getDistance()
    {
        return distance;
    }

    public FixedRange getXpLevel()
    {
        return xpLevel;
    }
}
