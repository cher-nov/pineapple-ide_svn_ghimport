#include "pineapple.h"
#include <iostream>

using namespace Pineapple;

class Ship : public Actor
{
public:
    Ship(int x, int y, Texture* t)
    {
        this->x = x;
        this->y = y;
        this->t = t;

        this->friction = 1;
    }

    void update()
    {
        Uint8* keys = SDL_GetKeyState(NULL);

        if (keys[SDLK_UP])
            speed += 2;
        if (keys[SDLK_DOWN])
            speed -= 2;

        speed = sign(speed) * min(abs(speed), 8.0f);

        if (keys[SDLK_LEFT])
            direction += 2;
        if (keys[SDLK_RIGHT])
            direction -= 2;

        angle = direction;
    }
};

class TestScene : public Scene
{
public:
    TestScene()
    {
        addActor(new Ship(50, 50, new Texture("test.png", 16, 16)));
    }
};

int main(int argc, char** argv)
{
    Application::init();
    Window::setSize(640, 480);
    Window::setCaption("Hello");

    Scene* s = new TestScene();
    Application::setScene(s);

    Window::run();

    return 0;
}
