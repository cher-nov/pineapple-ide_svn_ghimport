/* 
 * File:   drawingprimitives.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:22
 */

#ifndef _DRAWINGPRIMITIVES_H
#define	_DRAWINGPRIMITIVES_H

#include "pineapple.h"

class pineapple::objects::DrawingPrimitives
{
    private:
        DrawingPrimitives();
    public:
        static void drawRectangle(int x, int y, int width, int height,
                Color* c);
        static void drawRectangleGradient(int x, int y, int width, int height,
                Color* c1, Color* c2, Color* c3, Color* c4);
};

#endif	/* _DRAWINGPRIMITIVES_H */

