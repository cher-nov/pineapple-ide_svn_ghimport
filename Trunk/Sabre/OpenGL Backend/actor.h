#ifndef ACTOR_H
#define ACTOR_H

#include "pineapple.h"

class Pineapple::Actor
{
protected:
    Texture* t;
    float x, y, angle;
    float hspeed, vspeed;
    float direction, speed, friction;
    float gravity, gravity_direction;
public:
    Actor();

    void move();

    virtual void update() {}
    virtual void draw();

    virtual void onKeyDown(SDLKey key) {};
    virtual void onKeyUp(SDLKey key) {};
};

#endif
