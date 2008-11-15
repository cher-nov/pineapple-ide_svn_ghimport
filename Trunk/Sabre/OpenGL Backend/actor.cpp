#include "actor.h"
#include <math.h>
#define PI 3.14159265

using namespace SDLEngine;

Actor::Actor()
{
    x = 0;
    y = 0;
    angle = 0;
    gravity = 0;
    gravity_direction = 270;
}

void Actor::update()
{
    //direction/speed
    if (speed != 0)
    {
        x += speed * cos(direction * PI/180);
        y -= speed * sin(direction * PI/180);
    }

    //gravity
    if (gravity != 0)
    {
        hspeed += gravity * cos(gravity_direction * PI/180);
        vspeed -= gravity * sin(gravity_direction * PI/180);
    }

    //h/v speed
    x += hspeed;
    y += vspeed;
}


void Actor::draw()
{
    t->draw(x, y, angle);
}

void Actor::onKeyDown(SDLKey key)
{

}

void Actor::onKeyUp(SDLKey key)
{

}
