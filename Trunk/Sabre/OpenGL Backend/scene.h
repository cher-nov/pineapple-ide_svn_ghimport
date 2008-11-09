#ifndef SCENE_H
#define SCENE_H

#include "sdlengine.h"
#include <vector>

class SDLEngine::Scene
{
protected:
    std::vector<Actor*> actors;
    int width;
    int height;
public:
    virtual void create() = 0;
    virtual void destroy() = 0;
    virtual void update() = 0;
    virtual void draw() = 0;
};

#endif
