#ifndef TEXTURE_H
#define TEXTURE_H

#include "sdlengine.h"

class SDLEngine::Texture
{
private:
    int width;
    int height;
    int originx;
    int originy;
    GLuint textureid;
public:
    Texture(const char* file, int originx = 0, int originy = 0);
    ~Texture();
    int getWidth() { return width; }
    int getHeight() { return height; }
    void draw(float x, float y, float angle = 0);
};

#endif
