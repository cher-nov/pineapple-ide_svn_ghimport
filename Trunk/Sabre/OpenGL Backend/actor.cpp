#include "actor.h"

using namespace SDLEngine;

void Actor::draw()
{
    t->draw(x, y, angle);
}
