#ifndef ACTOR_H
#define ACTOR_H

#include "pineapple.h"
using namespace Pineapple;

class Pineapple::Actor
{
    float x, y;
    Vector* motion;
    Vector* gravity;
    float friction;
protected:
    Texture* texture;
    float angle;
public:
    Actor();
    virtual ~Actor();

    float getX() { return x; }
    float getY() { return y; }
    void setX(float x) { this->x = x; }
    void setY(float y) { this->y = y; }

    float getHSpeed() { return motion->getX(); }
    float getVSpeed() { return motion->getY(); }
    void setHSpeed(float x) { motion->setX(x); }
    void setVSpeed(float y) { motion->setY(y); }

    float getSpeed() { return motion->getSpeed(); }
    float getDirection() { return motion->getDirection(); }
    void setSpeed(float s) { motion->setSpeed(s); }
    void setDirection(float d) { motion->setDirection(d); }

    float getFriction() { return friction; }
    void setFriction(float f) { friction = f; }

    float getGravity() { return gravity->getSpeed(); }
    float getGravityDirection() { return gravity->getDirection(); }
    void setGravity(float g) { gravity->setSpeed(g); }
    void setGravity(float g, float d) { gravity->setSpeed(g); gravity->setDirection(d); }
    void setGravityDirection(float d) { gravity->setDirection(d); }

    void loop();

    virtual void update() {}
    void move();
    virtual void draw();

    virtual void onKeyDown(SDLKey key) {}
    virtual void onKeyUp(SDLKey key) {}
};

#endif
