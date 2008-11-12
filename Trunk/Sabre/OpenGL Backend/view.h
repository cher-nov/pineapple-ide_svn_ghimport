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
    View();
    void set();
};

#endif
