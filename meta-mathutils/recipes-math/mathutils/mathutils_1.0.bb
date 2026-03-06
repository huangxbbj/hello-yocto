SUMMARY = "Simple math utils application"
DESCRIPTION = "A small C program providing add/subtract functions"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://main.c \
           file://math_utils.c \
           file://math_utils.h \
           file://test_math.c"

S = "${WORKDIR}"

inherit ptest

do_compile() {
    ${CC} ${CFLAGS} -I${S} \
        ${S}/math_utils.c ${S}/main.c \
        -o mathutils_app \
        ${LDFLAGS}

    # Build test_mathutils
    ${CC} ${CFLAGS} ${CPPFLAGS} \
        -I${S} \
        ${S}/math_utils.c ${S}/test_math.c \
        ${LDFLAGS} \
        -o test_mathutils

    # Run the test (fails build if test fails)
#    ./test_mathutils 
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 mathutils_app ${D}${bindir}/
}

do_install_ptest() {
    install -d ${D}${PTEST_PATH}
    install -m 0755 test_mathutils ${D}${PTEST_PATH}
    install -m 0755 ${WORKDIR}/run-ptest ${D}${PTEST_PATH}
}
