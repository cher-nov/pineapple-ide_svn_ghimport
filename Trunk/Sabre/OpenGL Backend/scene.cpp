#include "scene.h"

using namespace SDLEngine;

void Scene::update()
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->update();
    }
}

void Scene::draw()
{
    glClear(GL_COLOR_BUFFER_BIT);

    if (views.size() == 0)
    {
        drawActors();
    }
    else
    {
        for (unsigned int i = 0; i < views.size(); i++)
        {
            View* v = views[i];
            v->set();
            drawActors();
        }
    }
}

void Scene::drawActors()
{
    for (unsigned int i = 0; i < actors.size(); i++)
    {
        actors[i]->draw();
    }
}

void Scene::addActor(Actor* actor)
{
    actors.push_back(actor);
}

void Scene::addView(View* view)
{
    views.push_back(view);
}
