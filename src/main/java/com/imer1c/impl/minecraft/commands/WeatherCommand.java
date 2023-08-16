package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.world.Weather;
import com.imer1c.generator.formatter.Formatters;

public class WeatherCommand extends AbstractCommand {

    @Override
    public String getId()
    {
        return "weather";
    }

    public void setWeather(Weather weather)
    {
        this.write(0, Formatters.format(weather));
    }

    public void setWeather(Weather weather, int duration)
    {
        this.write(0, Formatters.format(weather), duration);
    }
}
