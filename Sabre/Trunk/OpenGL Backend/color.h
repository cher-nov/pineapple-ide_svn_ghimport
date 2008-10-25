/* 
 * File:   color.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:22
 */

#ifndef _COLOR_H
#define	_COLOR_H

#include "pineapple.h"

class pineapple::objects::Color
{
    private:
        float r, g, b, a;
    public:
        Color(int r, int g, int b);
        Color(int r, int g, int b, int a);
        Color(int r, int g, int b, float a);
        Color(float r, float g, float b);
        Color(float r, float g, float b, float a);
        float getRed();
        float getGreen();
        float getBlue();
        float getAlpha();
};

#endif	/* _COLOR_H */

