package com.imer1c.api.minecraft.chatting.text;

public interface INBTTextComponent extends ITextComponent {

    void entity(String entity);

    String getEntity();

    void blockCoordinates(String blockCoordinates);

    String getBlockCoordinates();

    void storage(String storage);

    String getStorage();

    void interpret(boolean interpret);

    boolean isInterpreting();
}
