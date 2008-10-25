/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

#include "pineapple.h"

pineapple::objects::Actor::Actor()
{
    x = 0;
    y = 0;
    t = NULL;
    visible = false;
}

void pineapple::objects::Actor::draw(View* view)
{
    if(isVisible()&&t!=NULL)
    {
        if(view==NULL)
            t->GLDraw(getX(), getY());
        else
            t->GLDraw(getX()-view->getSourceX(), getY()-view->getSourceY());
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

pineapple::objects::Texture* pineapple::objects::Actor::getTexture()
{
    return t;
}

void pineapple::objects::Actor::setTexture(Texture* t)
{
    this->t = t;
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
