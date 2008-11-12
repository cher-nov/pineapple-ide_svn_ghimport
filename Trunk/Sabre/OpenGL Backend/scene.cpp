#include "scene.h"

using namespace SDLEngine;

void Scene::update()
{
    for (int i = 0; i < actors.size(); i++)
    {
        actors[i]->update();
    }
}

void Scene::draw()
{
    if (views.size() == 0)
    {
        drawActors();
    }
    else
    {
        for (int i = 0; i < views.size(); i++)
        {
            View* v = views[i];
            v->set();
            drawActors();
        }
    }
}

void Scene::drawActors()
{
    for (int i = 0; i < actors.size(); i++)
    {
        actors[i]->draw();
    }
}
