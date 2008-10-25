#include "pineapple.h"

pineapple::objects::Actor::Actor()
{
    x = 0;
    y = 0;
    t = NULL;
    visible = false;
}

void pineapple::objects::Actor::draw()
{
    if(isVisible()&&t!=NULL)
    {
        t->GLDraw(getX(), getY());
    }
}

bool pineapple::objects::Actor::isVisible()
{
    return visible;
}

int pineapple::objects::Actor::getX()
{
    return x;
}

int pineapple::objects::Actor::getY()
{
    return y;
}

void pineapple::objects::Actor::setVisible(bool visible)
{
    this->visible = visible;
}

void pineapple::objects::Actor::setX(int x){
    this->x = x;
}

void pineapple::objects::Actor::setY(int y){
    this->y = y;
}
