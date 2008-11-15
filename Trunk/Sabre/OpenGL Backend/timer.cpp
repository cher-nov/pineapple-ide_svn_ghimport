#include "timer.h"

Timer::Timer()
{
    startTicks = 0;
    started = false;
}

void Timer::start()
{
    started = true;
    startTicks = SDL_GetTicks();
}

int Timer::get_ticks()
{
    if (started)
        return SDL_GetTicks() - startTicks;
}

