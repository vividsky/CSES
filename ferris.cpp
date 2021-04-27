#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, weight;
    cin >> n >> weight;
    vector<int> arr(n);
    for (int &x : arr) {
        cin >> x;
    }
    sort(arr.begin(), arr.end());
    int i = 0, j = n - 1, count = 0;
    while (i <= j) {
        if (arr[i] + arr[j] <= weight) {
            i++;
        }
        count++;
        j--;
    }
    cout << count << endl;
    return 0;
}