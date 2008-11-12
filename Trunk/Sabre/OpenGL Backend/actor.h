#ifndef ACTOR_H
#define ACTOR_H

#include "sdlengine.h"

class SDLEngine::Actor
{
protected:
    Texture* t;
    float x, y, angle;
    float hspeed, vspeed;
    float gravity, gravity_direction;
public:
    virtual void update();
    virtual void draw();
};

#endif
