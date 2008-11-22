#ifndef VECTOR_H
#define VECTOR_H

#include "pineapple.h"

class Pineapple::Vector
{
public:
    virtual void setX(float x) = 0;
    virtual void setY(float y) = 0;

    virtual float getX() = 0;
    virtual float getY() = 0;

    virtual void setDirection(float d) = 0;
    virtual void setSpeed(float s) = 0;

    virtual float getDirection() = 0;
    virtual float getSpeed() = 0;
};

class Pineapple::VectorXY : public Pineapple::Vector
{
    float x;
    float y;
    float direction;
public:
    VectorXY(float x, float y) { this->x = x; this->y = y; }

    void setX(float x) { this->x = x; }
    void setY(float y) { this->y = y; }

    float getX() { return x; }
    float getY() { return y; }

    void setDirection(float d)
    {
        x = cos(d * PI/180) * getSpeed();
        y = -sin(d * PI/180) * getSpeed();
        direction = d;
    }

    void setSpeed(float s)
    {
        x = cos(direction ? direction : getDirection() * PI/180) * s;
        y = -sin(direction ? direction : getDirection() * PI/180) * s;
    }

    float getDirection() { return direction = atan2(x, y); }
    float getSpeed() { return sqrt(x * x + y * y); }
};

class Pineapple::VectorRV : public Pineapple::Vector
{
    float direction;
    float speed;
public:
    VectorRV(float d, float s) { direction = d; speed = s; }

    void setDirection(float d) { direction = d; }
    void setSpeed(float s) { speed = s; }

    float getDirection() { return direction; }
    float getSpeed() { return speed; }

    void setX(float x)
    {
        direction = atan2(x, getY());
        speed = sqrt(x * x + getY() * getY());
    }

    void setY(float y)
    {
        direction = atan2(getX(), y);
        speed = sqrt(getX() * getX() + y * y);
    }

    float getX() { return cos(direction * PI/180) * speed; }
    float getY() { return -sin(direction * PI/180) * speed; }
};

#endif
