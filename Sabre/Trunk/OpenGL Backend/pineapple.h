/* 
 * File:   pineapple.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 12:04
 */

#ifndef _PINEAPPLE_H
#define	_PINEAPPLE_H

#include <string>
#include "SDL_opengl.h"

typedef std::string string;

namespace pineapple
{
    namespace std
    {
        class Application;
        class Window;
    }
    namespace objects
    {
        class Drawable;
        class Texture;
        class DrawingPrimitives;
        class Color;
        
        class Actor;
    }
}

#include "application.h"
#include "window.h"

#include "drawable.h"
#include "texture.h"
#include "drawingprimitives.h"
#include "color.h"

#include "actor.h"

#endif	/* _PINEAPPLE_H */

