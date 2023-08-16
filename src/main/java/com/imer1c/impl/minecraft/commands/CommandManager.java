package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.world.Weather;

public class CommandManager {
    public static final TellrawCommand tellraw = new TellrawCommand();
    public static final TitleCommand title = new TitleCommand();
    public static final DamageCommand damage = new DamageCommand();
    public static final ClearCommand clear = new ClearCommand();
    public static final BossbarCommand bossbar = new BossbarCommand();
    public static final ForceLoadCommand forceLoad = new ForceLoadCommand();
    public static final KillCommand kill = new KillCommand();
    public static final LocateCommand locate = new LocateCommand();
    public static final RideCommand ride = new RideCommand();
    public static final SpawnPointCommand spawnPoint = new SpawnPointCommand();
    public static final SetWorldSpawnCommand setWorldSpawn = new SetWorldSpawnCommand();
    public static final SayCommand say = new SayCommand();
    public static final SpectateCommand spectate = new SpectateCommand();
    public static final TagCommand tag = new TagCommand();
    public static final TeleportCommand tp = new TeleportCommand();
    public static final TimeCommand time = new TimeCommand();
    public static final WeatherCommand weather = new WeatherCommand();
    public static final WorldBorderCommand worldBorder = new WorldBorderCommand();
    public static final DefaultGameModeCommand defaultGameMode = new DefaultGameModeCommand();
    public static final DifficultyCommand difficulty = new DifficultyCommand();
    public static final GameModeCommand gamemode = new GameModeCommand();
    public static final XpCommand xp = new XpCommand();
    public static final BroadcastNarrativeMessageCommand me = new BroadcastNarrativeMessageCommand();
}
