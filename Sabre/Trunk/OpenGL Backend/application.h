/* 
 * File:   application.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:19
 */

#ifndef _APPLICATION_H
#define	_APPLICATION_H

#include "pineapple.h"

class pineapple::std::Application
{
    private:
        Application(); //Don't construct
    public:
        static void initialize(int* argc, char*** argv);
        static int getArgumentCount();
        static string getArgumentAt(int index);
        static bool isRunning(); //requestExit();
        static void requestExit();
        static void kill(int errorcode);
        static int getPreferredSpeed();
        static void setPreferredSpeed(int fps);
};

#endif	/* _APPLICATION_H */

