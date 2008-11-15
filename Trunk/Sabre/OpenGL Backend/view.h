#ifndef VIEW_H
#define VIEW_H

#include "sdlengine.h"

class SDLEngine::View
{
    int px;
    int py;
    int pwidth;
    int pheight;
    int sx;
    int sy;
    int swidth;
    int sheight;
public:
    View(int swidth = 640,
         int swidth = 480,
         int pwidth = 0,
         int pheight = 0,
         int sx = 0,
         int sy = 0,
         int px = 0,
         int py = 0);
    void set();
};

#endif
