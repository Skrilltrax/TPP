#include <iostream>
#include "PermutationCombination.hpp"

int main() {
    vector<int> arr = {2, 3, 5, 7};
    vector<bool> visited(4, false);
    cout << printPermutations(arr, "", 0, 10, visited) << endl;
    return 0;
}
