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
    glClear(GL_COLOR_BUFFER_BIT);
    for (int i = 0; i < actors.size(); i++)
    {
        actors[i]->draw();
    }
}
