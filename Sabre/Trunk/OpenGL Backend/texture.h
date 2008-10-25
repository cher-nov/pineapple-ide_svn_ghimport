/* 
 * File:   texture.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:21
 */

#ifndef _TEXTURE_H
#define	_TEXTURE_H

#include "pineapple.h"

class pineapple::objects::Texture : Drawable
{
    private:
        int width;
        int height;
        GLuint textureid;
    public:
        Texture(string file);
        ~Texture();
        int getWidth();
        int getHeight();
        virtual void GLDraw(int x, int y);
};

#endif	/* _TEXTURE_H */

