package com.imer1c.impl.minecraft.commands;

import com.imer1c.JavaPackWriter;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractCommand {

    private final Map<Integer, String> commands = new HashMap<>();

    public AbstractCommand()
    {
        String path = "data/commands/" + this.getId() + ".mccmd";
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);

        if (stream == null)
        {
            throw new RuntimeException("Can't find " + path);
        }

        this.init(stream);
    }

    private void init(InputStream stream)
    {
        Scanner scanner = new Scanner(stream);
        int i = 0;

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();

            if (line.isEmpty() || line.isBlank() || line.startsWith("//"))
            {
                continue;
            }

            this.commands.put(i++, line);
        }
    }

    protected String getCommand(int index, Object... args)
    {
        return String.format(this.commands.get(index), args);
    }

    protected void write(String s)
    {
        JavaPackWriter writer = JavaPackWriter.getInstance();
        writer.write(s);
        writer.write("\n");
    }

    protected void write(int index, Object... args)
    {
        String command = this.getCommand(index, args);
        this.write(command);
    }

    public abstract String getId();
}
