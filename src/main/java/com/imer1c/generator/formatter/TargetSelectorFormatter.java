package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.entity.target.*;
import com.imer1c.impl.minecraft.entity.target.TargetSelectorImpl;
import com.imer1c.utils.FixedRange;
import com.imer1c.utils.Range;

public class TargetSelectorFormatter implements IFormatter<TargetSelectorImpl> {

    @Override
    public String format(TargetSelectorImpl value)
    {
        StringBuilder builder = new StringBuilder(this.formatTarget(value)).append("[");

        boolean first = true;

        if (value.getLimit() != 0)
        {
            this.addValue("limit", value.getLimit(), builder, true);
            first = false;
        }

        if (value.getGameMode() != null)
        {
            this.addValue("gamemode", value.getGameMode(), builder, first);
            first = false;
        }

        if (value.getHorizontalRot() != null)
        {
            Range range = value.getHorizontalRot();

            this.addValue("y_rotation", range, builder, first);

            first = false;
        }

        if (value.getVerticalRot() != null)
        {
            Range range = value.getVerticalRot();

            this.addValue("x_rotation", range, builder, first);

            first = false;
        }

        if (value.getXpLevel() != null)
        {
            FixedRange range = value.getXpLevel();

            this.addValue("level", range, builder, first);

            first = false;
        }

        if (value.getName() != null)
        {
            this.addValue("name", value.getName(), builder, first);

            first = false;
        }

        if (value.getSelectionArea() != null)
        {
            SelectionArea selectionArea = value.getSelectionArea();

            if (selectionArea == SelectionArea.RADIUS)
            {
                Range range = value.getDistance();

                this.addValue("distance", range, builder, first);
            }
            else
            {
                this.addValue("dx", value.getToX(), builder, first);
                this.addValue("dy", value.getToY(), builder, first);
                this.addValue("dz", value.getToZ(), builder, first);
            }

            first = false;
        }

        if (value.getSort() != null)
        {
            this.addValue("sort", this.formatClassic(value.getSort()), builder, first);
            first = false;
        }

        if (value.getX() != 0)
        {
            this.addValue("x", value.getX(), builder, first);
            this.addValue("y", value.getY(), builder, first);
            this.addValue("z", value.getZ(), builder, first);

            first = false;
        }

        if (value.getTeamName() != null)
        {
            TeamOption teamOption = value.getTeamOption();
            String teamName = (teamOption == TeamOption.NOT_ANY_TEAM || teamOption == TeamOption.ON_ANY_TEAM ? "" : value.getTeamName());

            this.addValue("team", teamName, builder, first, this.formatEqualsForTeam(teamOption));

            first = false;
        }

        String string = builder.append("]").toString();

        if (string.endsWith("[]"))
        {
            return this.formatTarget(value);
        }

        return string;
    }

    private void addValue(String id, Object value, StringBuilder builder, boolean first)
    {
        this.addValue(id, value, builder, first, "=");
    }

    private void addValue(String id, Object value, StringBuilder builder, boolean first, String equals)
    {
        if (!first)
        {
            builder.append(",");
        }

        builder.append(id).append(equals).append(value);
    }

    private String formatTarget(TargetSelector selector)
    {
        return switch (selector.getTarget())
                {
                    case ALL_PLAYERS -> "@a";
                    case ALL_ENTITIES -> "@e";
                    case RANDOM_PLAYER -> "@r";
                    case NEAREST_PLAYER -> "@p";
                    case COMMAND_EXECUTOR -> "@s";
                };
    }

    private String formatClassic(Sort sort)
    {
        return Formatters.format(sort);
    }

    private String formatEqualsForTeam(TeamOption option)
    {
        return switch (option)
                {
                    case ON_ANY_TEAM -> "=!";
                    case NOT_ANY_TEAM, ONLY_IN_TEAM -> "=";
                    case NOT_THIS_TEAM -> "!=";
                };
    }
}
