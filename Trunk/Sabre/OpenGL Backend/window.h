#ifndef WINDOW_H
#define WINDOW_H

#include "pineapple.h"

class Pineapple::Window
{
    static int width;
    static int height;
    static char* caption;
    static bool fullscreen;
    static bool resizable;

    static inline void update();
public:
    static void setSize(int width, int height, bool fullscreen = false);
    static void setFullscreen(bool fullscreen);
    static void setCaption(const char* title);
    static void setResizable(bool resizable);

    static int getWidth() { return width; }
    static int getHeight() { return height; }

    static void run();
};

#endif
