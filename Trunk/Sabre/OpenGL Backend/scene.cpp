#include "scene.h"

using namespace SDLEngine;

void Scene::draw()
{
    for (int i = 0; i < actors.size(); i++)
    {
        actors[i]->draw();
    }
}
