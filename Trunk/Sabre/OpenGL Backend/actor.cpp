#include "actor.h"

using namespace Pineapple;

//
//Set actor defaults
//
Actor::Actor()
{
    angle = 0;
    x = y = 0;
    motion = new VectorXY(0, 0);
    gravity = new VectorRV(0, 270);
    friction = 0;
}

Actor::~Actor()
{
    delete motion;
    delete gravity;
}

//
//Loop outside the room
//
void Actor::loop()
{
    if (x > Application::getScene()->getWidth() + texture->getOriginX())
        x = -texture->getOriginX();
    if (x < -texture->getOriginX())
        x = Application::getScene()->getWidth() + texture->getOriginX();

    if (y > Application::getScene()->getHeight() + texture->getOriginY())
        y = -texture->getOriginY();
    if (y < -texture->getOriginY())
        y = Application::getScene()->getHeight() + texture->getOriginY();
}

//
//Actor motion
//Updates location based on local vars
//
void Actor::move()
{
    motion->setSpeed(sign(motion->getSpeed()) * min(abs(motion->getSpeed()) - friction, 8.0f));

    x += motion->getX();
    y += motion->getY();
}

//
//Draws the actor
//
void Actor::draw()
{
    texture->draw(50, 50, 0);
}
