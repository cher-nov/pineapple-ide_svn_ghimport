#ifndef ACTOR_H
#define ACTOR_H

#include "sdlengine.h"

class SDLEngine::Actor
{
private:
    Texture* t;
protected:
    float x, y;
    float hspeed, vspeed;
    float gravity, gravity_direction;
public:
    virtual void create() = 0;
    virtual void destroy() = 0;
    virtual void update() = 0;
    virtual void draw() = 0;
};

#endif
