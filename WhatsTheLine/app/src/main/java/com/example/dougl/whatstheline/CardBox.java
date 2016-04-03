package com.example.dougl.whatstheline;

import android.graphics.drawable.Drawable;

public class CardBox {
    public final Drawable icon;
    public final String title;
    public final String description;
    public final int rin;

    public CardBox(Drawable icon, String title, String description, int rin){
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.rin = rin;
    }
}
