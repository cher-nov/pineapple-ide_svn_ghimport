#include <math.h>
#define PI 3.14159265

namespace Pineapple
{
    template <class T>
    inline int sign(T a)
    {
        return (a < 0) ? -1 : ((a > 0) ? 1 : 0);
    }

    template <class T>
    inline int max(T a, T b)
    {
        return (a > b) ? a : b;
    }

    template <class T>
    inline int min(T a, T b)
    {
        return (a < b) ? a : b;
    }

    template <class T>
    inline T abs(T a)
    {
        return (a > 0) ? a : -a;
    }
}