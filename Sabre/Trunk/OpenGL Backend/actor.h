/* 
 * File:   actor.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:23
 */

#ifndef _ACTOR_H
#define	_ACTOR_H

#include "pineapple.h"

class pineapple::objects::Actor
{
    private:
        int x, y;
        Texture* t;
        bool visible;
    public:
        Actor();
        virtual void draw();
        
        virtual bool isVisible();
        virtual int getX();
        virtual int getY();
        
        virtual void setVisible(bool visible);
        virtual void setX(int x);
        virtual void setY(int y);
};

#endif	/* _ACTOR_H */

