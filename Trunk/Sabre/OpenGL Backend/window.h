#ifndef WINDOW_H
#define WINDOW_H

#include "sdlengine.h"

class SDLEngine::Window
{
    static int width;
    static int height;
    static char* caption;
    static int bpp;
    static bool fullscreen;
    static bool resizable;

public:
    static void init(int width = 640, int height = 480, const char* caption = "SDL Engine", int bpp = 32, bool fullscreen = false, bool resizable = false);
    static void setSize(int width, int height);

    static int getWidth() { return width; }
    static int getHeight() { return height; }

    static inline void* update();

    static void run();
};

#endif
