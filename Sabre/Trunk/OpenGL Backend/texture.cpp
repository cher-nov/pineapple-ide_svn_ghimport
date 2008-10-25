#include "pineapple.h"
#include "SDL.h"
#include "SDL/SDL_opengl.h"
#include "SDL/SDL_image.h"
#include "GL/glu.h"

pineapple::objects::Texture::Texture(string file)
{
    SDL_Surface *surface = IMG_Load(file.c_str());
    
    glPixelStorei(GL_UNPACK_ALIGNMENT, 4);
    glGenTextures(1, &textureid);
    glBindTexture(GL_TEXTURE_2D, textureid);
    SDL_PixelFormat *format = surface->format;
    
    if(format->Amask){
        gluBuild2DMipmaps(GL_TEXTURE_2D, 4, surface->w, surface->h, GL_RGBA, GL_UNSIGNED_BYTE, surface->pixels);
    }
    else{
        gluBuild2DMipmaps(GL_TEXTURE_2D, 3, surface->w, surface->h, GL_RGB, GL_UNSIGNED_BYTE, surface->pixels);
    }
    
    width = surface->w;
    height = surface->h;
    
    SDL_FreeSurface(surface);
}

pineapple::objects::Texture::~Texture()
{
    glDeleteTextures(1, &textureid);
}

int pineapple::objects::Texture::getWidth()
{
    return width;
}

int pineapple::objects::Texture::getHeight()
{
    return height;
}

void pineapple::objects::Texture::GLDraw(int x, int y)
{
    glBindTexture(GL_TEXTURE_2D, textureid);
    
    glTranslatef(x, y, 0);
    
    glBegin(GL_QUADS);
        glTexCoord2i(0, 0);
        glVertex3f(0, 0, 0);

        glTexCoord2i(0, 1);
        glVertex3f(0, getHeight(), 0);

        glTexCoord2i(1, 1);
        glVertex3f(getWidth(), getHeight(), 0);

        glTexCoord2i(1, 0);
        glVertex3f(getWidth(), 0, 0);
    glEnd();
    glLoadIdentity();
}
