#include "actor.h"
#include <math.h>
#define PI 3.14159265

using namespace SDLEngine;

void Actor::draw()
{
    t->draw(x, y, angle);
}

void Actor::update()
{
    if (gravity != 0)
    {
        hspeed += gravity * cos(gravity_direction * PI/180);
        vspeed -= gravity * sin(gravity_direction * PI/180);
    }
    x += hspeed;
    y += vspeed;
}
