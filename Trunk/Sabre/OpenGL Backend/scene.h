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
    Scene();
    virtual ~Scene();

    virtual void update();
    virtual void draw();

    virtual void addActor(Actor* actor);
    virtual void addView(View* view);

    virtual void onKeyDown(SDLKey key);
    virtual void onKeyUp(SDLKey key);
};

#endif
