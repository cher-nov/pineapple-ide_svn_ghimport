#include "actor.h"

using namespace SDLEngine;

//
//Set actor defaults
//
Actor::Actor()
{
    x = 0;
    y = 0;

    hspeed = 0;
    vspeed = 0;

    speed = 0;
    direction = 0;
    friction = 0;

    gravity = 0;
    gravity_direction = 270;

    angle = 0;
}

//
//Actor motion
//Updates location based on local vars
//
void Actor::move()
{
    //friction
    speed = sign(speed) * max(abs(speed) - friction, 0.0f);

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

//
//Draws the actor
//
void Actor::draw()
{
    t->draw(x, y, angle);
}
