#include <stdio.h>
#include <stdlib.h>
#include "math_utils.h"

#define ASSERT_EQ(expected, actual)                         \
    if ((expected) != (actual)) {                           \
        printf("Test failed: %s:%d\n", __FILE__, __LINE__); \
        printf("Expected %d, got %d\n", (expected), (actual)); \
        exit(1);                                            \
    }

void test_add() {
    ASSERT_EQ(5, add(2, 3));
    ASSERT_EQ(0, add(-1, 1));
}

void test_subtract() {
    ASSERT_EQ(1, subtract(3, 2));
    ASSERT_EQ(-2, subtract(1, 3));
}

int main() {
    test_add();
    test_subtract();
    printf("All tests passed!\n");
    return 0;
}
