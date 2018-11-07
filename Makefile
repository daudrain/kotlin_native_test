
LIBNAME := lib
LIBNAME_ANDROID_ARM64 := $(LIBNAME)_android_arm64
LIBNAME_MACOS := $(LIBNAME)_macos

LIBFILENAME_ANDROID_ARM64 := $(LIBNAME_ANDROID_ARM64).klib
LIBFILENAME_MACOS := $(LIBNAME_MACOS).klib

all: test_macos.kexe test_android_arm64.so

$(LIBFILENAME_ANDROID_ARM64): test.def
	cinterop -target android_arm64 -def test.def -o $(LIBNAME_ANDROID_ARM64)

$(LIBFILENAME_MACOS): test.def
	cinterop -target macos -def test.def -o $(LIBNAME_MACOS)

# konanc generates a so file, not a program, even if 
test_android_arm64.so: $(LIBFILENAME_ANDROID_ARM64) test.kt
	konanc test.kt -target android_arm64 -l $(LIBFILENAME_ANDROID_ARM64) -p dynamic -g -o test_android_arm64

test_macos.kexe: $(LIBFILENAME_MACOS) test.kt
	konanc test.kt -target macos -l $(LIBFILENAME_MACOS) -g  -o test_macos