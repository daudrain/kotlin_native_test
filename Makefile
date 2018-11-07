
LIBNAME := test
LIBFILENAME := $(LIBNAME).klib

all: $(APPFILENAME) test_macos.kexe test_android_arm64.kexe

$(LIBFILENAME): test.def
	cinterop -def test.def -o $(LIBNAME)


test_android_arm64.kexe: $(LIBFILENAME) test.kt
	konanc test.kt -target android_arm64 -l $(LIBFILENAME) -g -o test_android_arm64

test_macos.kexe: $(LIBFILENAME) test.kt
	konanc test.kt -target macos -l $(LIBFILENAME) -g -o test_macos