/* 
 * File:   drawable.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:20
 */

#ifndef _DRAWABLE_H
#define	_DRAWABLE_H

#include "pineapple.h"

class pineapple::objects::Drawable
{
    public:
        virtual void GLDraw(int x, int y) = 0;
};

#endif	/* _DRAWABLE_H */

