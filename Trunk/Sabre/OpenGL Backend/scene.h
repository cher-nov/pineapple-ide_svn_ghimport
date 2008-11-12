#ifndef SCENE_H
#define SCENE_H

#include "sdlengine.h"
#include <vector>

class SDLEngine::Scene
{
protected:
    std::vector<Actor*> actors;
    std::vector<View*> views;

    int width;
    int height;

    virtual void drawActors();
public:
    virtual void update();
    virtual void draw();

    void addActor(Actor* actor);
    void addView(View* view);
};

#endif
