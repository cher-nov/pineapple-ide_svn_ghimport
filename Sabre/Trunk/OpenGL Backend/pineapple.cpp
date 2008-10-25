#include "pineapple.h"

using pineapple::std::Application;
using pineapple::std::Window;

int main(int argc, char** argv)
{
    Application::initialize(&argc, &argv);
    
    Window::setSize(640, 480, false);
    Window::setTitle("Hello World!");
    Window::run();
}
