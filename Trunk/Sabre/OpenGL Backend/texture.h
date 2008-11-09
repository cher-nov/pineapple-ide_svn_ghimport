#ifndef TEXTURE_H
#define TEXTURE_H

#include "sdlengine.h"
#include "SDL/SDL_opengl.h"

class SDLEngine::Texture
{
private:
    int width;
    int height;
    int originx;
    int originy;
    GLuint textureid;
public:
    Texture(char* file, int originx = 0, int originy = 0);
    ~Texture();
    int getWidth();
    int getHeight();
    void draw(float x, float y, float angle = 0);
};

#endif
