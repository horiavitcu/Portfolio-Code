package com.mrpound;

import com.mrpound.framework.Screen;
import com.mrpound.framwork.implementation.AndroidGame;

public class MrPoundGame extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
} 
