#
# Gererated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=build/Release/GNU-Linux-x86

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/pineapple.o \
	${OBJECTDIR}/actor.o \
	${OBJECTDIR}/drawingprimitives.o \
	${OBJECTDIR}/view.o \
	${OBJECTDIR}/texture.o \
	${OBJECTDIR}/scene.o \
	${OBJECTDIR}/color.o \
	${OBJECTDIR}/math.o \
	${OBJECTDIR}/window.o \
	${OBJECTDIR}/application.o

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-lSDL -lGL -lSDL_image -lGLU

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} dist/Release/GNU-Linux-x86/opengl_backend

dist/Release/GNU-Linux-x86/opengl_backend: ${OBJECTFILES}
	${MKDIR} -p dist/Release/GNU-Linux-x86
	${LINK.cc} -o dist/Release/GNU-Linux-x86/opengl_backend -s ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/pineapple.o: pineapple.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/pineapple.o pineapple.cpp

${OBJECTDIR}/actor.o: actor.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/actor.o actor.cpp

${OBJECTDIR}/drawingprimitives.o: drawingprimitives.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/drawingprimitives.o drawingprimitives.cpp

${OBJECTDIR}/view.o: view.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/view.o view.cpp

${OBJECTDIR}/texture.o: texture.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/texture.o texture.cpp

${OBJECTDIR}/scene.o: scene.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/scene.o scene.cpp

${OBJECTDIR}/color.o: color.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/color.o color.cpp

${OBJECTDIR}/math.o: math.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/math.o math.cpp

${OBJECTDIR}/window.o: window.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/window.o window.cpp

${OBJECTDIR}/application.o: application.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -s -D_RELEASE_ -I/usr/include/SDL -o ${OBJECTDIR}/application.o application.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	${RM} -r build/Release
	${RM} dist/Release/GNU-Linux-x86/opengl_backend

# Subprojects
.clean-subprojects:
