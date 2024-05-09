package com.imer1c.generator;

public class PackMeta {
    private final Pack pack;

    public PackMeta(Pack pack)
    {
        this.pack = pack;
    }

    public static PackMeta generateMetaData(DataPackInstance instance)
    {
        Pack pack = new Pack(instance.getFormat(), instance.getDescription());

        return new PackMeta(pack);
    }

    public Pack getPack()
    {
        return pack;
    }

    protected static class Pack {
        private final int packFormat;
        private final String description;

        public Pack(int packFormat, String description)
        {
            this.packFormat = packFormat;
            this.description = description;
        }

        public int getPackFormat()
        {
            return packFormat;
        }

        public String getDescription()
        {
            return description;
        }
    }
}
