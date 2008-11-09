#ifndef TEXTURE_H
#define TEXTURE_H

#include "sdlengine.h"
#include "SDL/SDL_opengl.h"

class SDLEngine::Texture
{
private:
    int width;
    int height;
    GLuint textureid;
public:
    Texture(char* file);
    ~Texture();
    int getWidth();
    int getHeight();
    void draw(float x, float y);
};

#endif
