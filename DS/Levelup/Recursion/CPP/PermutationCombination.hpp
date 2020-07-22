#include <iostream>
#include <string>
#include <vector>

using namespace std;

int printCombination(string str, int idx, const string &ans) {
    if (idx == str.length()) {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    for (int i = idx; i < str.length(); i++) {
        count += printCombination(str, i + 1, ans + str[i]);
    }

    return count;
}

int printCombinationWithRepetition(vector<int> arr, int idx, const string &ans, int ssf, int tar) {
    if (ssf == tar) {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = idx; i < arr.size(); i++) {
        if (ssf + arr[i] <= tar) {
            count += printCombinationWithRepetition(arr, i, ans + to_string(arr[i]), ssf + arr[i], tar);
        }
    }

    return count;
}

int printPermutations(vector<int> arr, const string &ans, int ssf, int tar, vector<bool> &visited) {
    if (ssf == tar) {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    for (int i = 0; i < arr.size(); i++) {
        if (!visited[i]) {
            visited[i] = true;
            count += printPermutations(arr, ans + to_string(arr[i]), ssf + arr[i], tar, visited);
            visited[i] = false;
        }
    }

    return count;
}

int printPermutationWithRepetition(vector<int> arr, const string &ans, int ssf, int tar) {
    if (ssf == tar) {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    for (int i = 0; i < arr.size(); i++) {
        if (ssf + arr[i] <= tar) {
            count += printPermutationWithRepetition(arr, ans + to_string(arr[i]), ssf + arr[i], tar);
        }
    }

    return count;
}
