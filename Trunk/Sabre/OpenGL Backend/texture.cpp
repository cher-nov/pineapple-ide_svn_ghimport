#include "texture.h"

Texture::Texture(char* file)
{
    //load the image
    SDL_Surface *surface = IMG_Load(file);
    if (surface == NULL)
        throw "Could not load image";
    GLuint texture;

    //set up a gl texture
    glGenTextures(1, &texture);
    glBindTexture(GL_TEXTURE_2D, texture);
    glPixelStorei(GL_UNPACK_ALIGNMENT, 4);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);

    //put the image in the texture with correct alpha format
    SDL_PixelFormat *format = surface->format;
    if (format->Amask)
        gluBuild2DMipmaps(GL_TEXTURE_2D, 4, surface->w, surface->h, GL_RGBA, GL_UNSIGNED_BYTE, surface->pixels);
    else
        gluBuild2DMipmaps(GL_TEXTURE_2D, 3, surface->w, surface->h, GL_RGB, GL_UNSIGNED_BYTE, surface->pixels);

    //setup the sprite class' stuff
    this->texture = texture;
    this->originx = originx;
    this->originy = originy;
    this->size.w = surface->w;
    this->size.h = surface->h;

    //free the image
    SDL_FreeSurface(surface);
}
