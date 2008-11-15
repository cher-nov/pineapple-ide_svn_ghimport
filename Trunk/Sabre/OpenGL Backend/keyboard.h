#ifndef KEYBOARD_H
#define KEYBOARD_H

#include "pineapple.h"
#include "keycodes.h"

class Pineapple::Keyboard
{
    static Uint8* keys;
public:
    static void update() { keys = SDL_GetKeyState(NULL); }
    static bool isKeyDown(Key key) { return keys[key]; }
};

#endif
